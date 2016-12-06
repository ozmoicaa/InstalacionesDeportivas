package pii.Main;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class OpInstalacionesDeportivas {

	public static void comprobarOperacion(String linea, HashMap<Integer, Usuario> usuarios,
			HashMap<Integer, Monitor> monitores, ArrayList<String> avisos,HashMap<Integer, Persona> personas) {

		String[] lineaPartida = linea.split("\\s");
		String instruccion = lineaPartida[1];

		switch (instruccion.toUpperCase()) {
		case "INSERTAPERSONA":
			// Partimos la cadena elemento a elemento hasta los apellidos, a
			// partir de ahí está todo en un mismo string
			String[] partes1 = linea.split("(\"\\s+\"|\\s+\"|\"\\s+)");
			String[] partes2 = partes1[(partes1.length - 1)].split("\\s* \\s*");
			String[] partes3 = partes1[0].split("\\s");
			// ARRAY QUE CONTIENE TODA LA INFORMACION CON LOS ELMENTOS POR
			// SEPARADO
			String[] partes = new String[10];
			// CONCATENO LOS ARRAYS DE STRINGS
			System.arraycopy(partes3, 0, partes, 0, partes3.length);
			System.arraycopy(partes1, 1, partes, partes3.length, 2);
			System.arraycopy(partes2, 0, partes, partes3.length + 2, partes2.length);

			insertaPersona(partes, usuarios, monitores, avisos, personas);
			break;

		case "ASIGNARMONITORGRUPO":
			System.out.println("Asignar monitor grupo");
			//asignarMonitorGrupo(lineaPartida);

		case "ALTA":
			System.out.println("Alta");
			break;

		default:
			System.out.println("No existe el comando:" + lineaPartida[1]);
		}
	}

	public static void insertaPersona(String[] partes, HashMap<Integer, Usuario> usuarios,
			HashMap<Integer, Monitor> monitores, ArrayList<String> avisos,HashMap<Integer, Persona> personas) {

		// LEO EL FICHERO PERSONAS
		// OpFicheros.leerFichero("personas.txt", lineas)

		// SI ES MONITOR

		// VARIABLES AUXILIARES EMPLEADAS PARA GUARDAR LOS IDS
		// DISPONIBLES
		// EN MONITORES Y EN USUARIOS
		
		int id = 1;

		// RECORREMOS LOS MONITORES EN BUSCA DE ALGÚN ID LIBRE
		while (personas.get(id) != null)
			id++;

		if (partes[2].equalsIgnoreCase("monitor")) {

			String perfil = partes[2];
			String nombre = partes[3].replace("\"", " ").trim();
			String apellidos = partes[4].replace("\"", " ").trim();

			// GENERO LOS ELEMENTOS DE LA FECHA
			String[] fecha = partes[5].split("/");
			int dia = Integer.parseInt(fecha[0]);
			int mes = Integer.parseInt(fecha[1]) - 1;
			int año = Integer.parseInt(fecha[2]);
			Calendar fecha1 = new GregorianCalendar(año, mes, dia);

			int horasAsignables = Integer.parseInt(partes[6]);

			// CREAMOS EL MONITOR Y LO METEMOS EN EL HASHMAP
			Monitor monitor = new Monitor(nombre, apellidos, perfil, id, fecha1, horasAsignables);
			Persona persona = new Monitor(nombre, apellidos, perfil, id, fecha1, horasAsignables);
			monitores.put(monitor.getId(), monitor);
			personas.put(persona.getId(), persona);

		}

		// SI ES USUARIO

		if (partes[2].equalsIgnoreCase("usuario")) {
			
			String perfil = partes[2];
			String nombre = partes[3].replace("\"", " ").trim();
			String apellidos = partes[4].replace("\"", " ").trim();

			// GENERO LOS ELEMENTOS DE LA FECHA DE NACIMIENTO
			String[] fechaNacimiento = partes[5].split("/");
			int dia = Integer.parseInt(fechaNacimiento[0]);
			int mes = Integer.parseInt(fechaNacimiento[1]) - 1;
			int año = Integer.parseInt(fechaNacimiento[2]);
			Calendar fecha1 = new GregorianCalendar(año, mes, dia);

			// GENERO LOS ELEMENTOS DE LA FECHA DE INGRESO
			String[] fechaIngreso = partes[6].split("/");
			int diaIngreso = Integer.parseInt(fechaIngreso[0]);
			int mesIngreso = Integer.parseInt(fechaIngreso[1]) - 1;
			int añoIngreso = Integer.parseInt(fechaIngreso[2]);
			Calendar fecha2 = new GregorianCalendar(añoIngreso, mesIngreso, diaIngreso);
			// SALDO DEL USUARIO
			
			partes[7]=partes[7].replace(".", ",");
			double saldo = Integer.parseInt(partes[7]);
			
			if(!(Validacion.esSaldo(saldo))){
			avisos.add("Saldo incorrecto");
			}
			
			/*if(!(Validacion.esFecha(fecha2, fecha1))){
				avisos.add("Fecha de ingreso incorrecta");
			}*/
			
			
			Persona persona = new Usuario(nombre, apellidos, perfil, id, fecha1, fecha2, saldo);
			Usuario usuario = new Usuario(nombre, apellidos, perfil, id, fecha1, fecha2, saldo);
			usuarios.put(id, usuario);
			personas.put(persona.getId(), persona);
		}
		System.out.println("a");

	}
}
