package pii.Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class OpFicheros {

	public static ArrayList<String> leerFichero(String archivo,  ArrayList<String> lineas) {

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
	
	public static ArrayList<String> leerFicheroPersonas(String archivo, ArrayList<String> lineas) {

		try {
			FileReader fileReader = new FileReader(archivo);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				if (line.contains("*")) {
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

	public static void escribirFichero(String docSalida, HashMap<Integer, Usuario> usuarios,
			HashMap<Integer, Monitor> monitores) {

		try {
			FileWriter fileWriter = new FileWriter(docSalida);
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

			for (Integer key : monitores.keySet()) {

				fileWriter.write((monitores.get(key)).getId() + "\n");
				fileWriter.write((monitores.get(key)).getPerfil() + "\n");
				fileWriter.write((monitores.get(key)).getNombre() + "\n");
				fileWriter.write((monitores.get(key)).getApellidos() + "\n");
				Date date = monitores.get(key).getFechaNacimiento().getTime();
				fileWriter.write(formato.format(date) + "\n");
				fileWriter.write(monitores.get(key).getHorasSemanales() + "\n");
				fileWriter.write("*\n");

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
				fileWriter.write("\n");
				
				

			}
			fileWriter.close();

		} catch (Exception IOException) { // trata cualquier tipo de expcepcion
			System.out.println("Error al generar el fichero");
		}
	}

}
