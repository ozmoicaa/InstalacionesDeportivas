package pii.Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class OpFicheros {

	public static ArrayList<String> leerFichero(String archivo, ArrayList<String> lineas) {

		try {
			FileReader fileReader = new FileReader(archivo);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				if (line.contains("*") || line.length() == 0) {
				} else
					lineas.add(line);
			}
			bufferedReader.close();
			fileReader.close();
		} catch (Exception IOException) {
			System.out.println("Error al leer el fichero");
		}
		return lineas;
	}
	
	public static void escribirAvisos(String docSalida, ArrayList<String> avisos) {

		try {
			FileWriter fileWriter = new FileWriter(docSalida);
			for (int i = 0; i < avisos.size(); i++) {
				fileWriter.write((avisos.get(i)).toString() + "\n");
			}
			fileWriter.close();

		} catch (Exception IOException) { // trata cualquier tipo de expcepcion
			System.out.println("Error al generar el fichero");
		}
	}

	public static void leerFicheroPersonas( String file, HashMap<Integer, Usuario> usuarios,
			HashMap<Integer, Monitor> monitores, HashMap<Integer, Persona> personas) {
		
		ArrayList<String> lineas = new ArrayList<String>();
		
		try {
			FileReader fileReader = new FileReader("personas.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				if (line.contains("*")) {
					//ES USUARIO
					if(lineas.size() == 7){
						String[] fechaNacimiento = lineas.get(4).split("/");
						int dia = Integer.parseInt(fechaNacimiento[0]);
						int mes = Integer.parseInt(fechaNacimiento[1]) - 1;
						int año = Integer.parseInt(fechaNacimiento[2]);
						Calendar fecha1 = new GregorianCalendar(año, mes, dia);

						// GENERO LOS ELEMENTOS DE LA FECHA DE INGRESO
						String[] fechaIngreso = lineas.get(5).split("/");
						int diaIngreso = Integer.parseInt(fechaIngreso[0]);
						int mesIngreso = Integer.parseInt(fechaIngreso[1]) - 1;
						int añoIngreso = Integer.parseInt(fechaIngreso[2]);
						Calendar fecha2 = new GregorianCalendar(añoIngreso, mesIngreso, diaIngreso);
						
						Usuario usuario = new Usuario(lineas.get(2), lineas.get(3),lineas.get(1),  Integer.parseInt(lineas.get(0)), fecha1, fecha2, Double.parseDouble(lineas.get(6)));
						Persona persona = new Usuario(lineas.get(2), lineas.get(3),lineas.get(1),  Integer.parseInt(lineas.get(0)), fecha1, fecha2, Double.parseDouble(lineas.get(6)));
						personas.put(persona.getId(), persona);
						usuarios.put(usuario.getId(), usuario);
					}
					
					else{
						
						String[] fechaNacimiento = lineas.get(4).split("/");
						int dia = Integer.parseInt(fechaNacimiento[0]);
						int mes = Integer.parseInt(fechaNacimiento[1]) - 1;
						int año = Integer.parseInt(fechaNacimiento[2]);
						Calendar fecha1 = new GregorianCalendar(año, mes, dia);
						
						Monitor monitor = new Monitor(lineas.get(2), lineas.get(3), lineas.get(1), Integer.parseInt(lineas.get(0)), fecha1, Integer.parseInt(lineas.get(5)));
						Persona persona = new Monitor(lineas.get(2), lineas.get(3), lineas.get(1), Integer.parseInt(lineas.get(0)), fecha1, Integer.parseInt(lineas.get(5)));
						personas.put(persona.getId(), persona);
						monitores.put(monitor.getId(), monitor);		
					}
					lineas.clear();
				} else
					lineas.add(line);
			}
			
			bufferedReader.close();
			fileReader.close();
			
		} catch (Exception IOException) {
			System.out.println("Error al leer el fichero");
		}
	}

	public static void escribirFicheroPersonas(String docSalida, HashMap<Integer, Usuario> usuarios,
			HashMap<Integer, Monitor> monitores) {

		try {
			FileWriter fileWriter = new FileWriter(docSalida);
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			DecimalFormat decimales = new DecimalFormat("0.00");

			for (Integer key : monitores.keySet()) {

				fileWriter.write((monitores.get(key)).getId() + "\n");
				fileWriter.write((monitores.get(key)).getPerfil() + "\n");
				fileWriter.write((monitores.get(key)).getNombre() + "\n");
				fileWriter.write((monitores.get(key)).getApellidos() + "\n");
				Date date = monitores.get(key).getFechaNacimiento().getTime();
				fileWriter.write(formato.format(date) + "\n");
				fileWriter.write(monitores.get(key).getHorasSemanales() + "\n");
				fileWriter.write("*************\n");

			}

			for (Integer key : usuarios.keySet()) {

				fileWriter.write((usuarios.get(key)).getId() + "\n");
				fileWriter.write((usuarios.get(key)).getPerfil() + "\n");
				fileWriter.write((usuarios.get(key)).getNombre() + "\n");
				fileWriter.write((usuarios.get(key)).getApellidos() + "\n");
				Date date1 = usuarios.get(key).getFechaNacimiento().getTime();
				fileWriter.write(formato.format(date1) + "\n");
				Date date2 = usuarios.get(key).getFechaAlta().getTime();
				fileWriter.write(formato.format(date2) + "\n");
				fileWriter.write(decimales.format(usuarios.get(key).getSaldo()) + "\n");
				fileWriter.write("*************\n");

			}
			fileWriter.close();

		} catch (Exception IOException) { // trata cualquier tipo de expcepcion
			System.out.println("Error al generar el fichero");
		}
	}

}
