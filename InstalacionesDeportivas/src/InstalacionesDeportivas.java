
import java.util.ArrayList;
import java.util.HashMap;

import pii.Main.Monitor;
import pii.Main.OpFicheros;
import pii.Main.OpInstalacionesDeportivas;
import pii.Main.Persona;
import pii.Main.Usuario;

public class InstalacionesDeportivas {

	static Integer id;

	public static void main(String[] args) {

		String fileEjecucion = "ejecucion.txt";
		String filePersona = "avisos.txt";
		String fileAvisos = "avisos.txt";
		String fileActividades = "actividades.txt";

		// ArrayList donde almacenamos las líneas de comandos
		ArrayList<String> lineas = new ArrayList<String>();
		// HashMap<Integer, Persona> personas = new HashMap<Integer,Persona>();
		HashMap<Integer, Usuario> usuarios = new HashMap<Integer, Usuario>();
		HashMap<Integer, Monitor> monitores = new HashMap<Integer, Monitor>();
		HashMap<Integer, Persona> personas = new HashMap<Integer, Persona>();
		// obtenemos las líneas del fichero de los comandos
		lineas = OpFicheros.leerFichero(fileEjecucion, lineas);
		for (String lineaPartir : lineas) {
			System.out.println(lineaPartir + " *");

			OpInstalacionesDeportivas.comprobarOperacion(lineaPartir, usuarios, monitores,personas);
			OpFicheros.escribirFichero("personas.txt", usuarios, monitores);
		}
	}

	public static void asignarGrupo() {

	}

	public static void gestionarPagoActividades() {

	}

	public static void obtenerCalendario() {

	}

}
