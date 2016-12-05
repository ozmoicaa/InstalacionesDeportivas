package pii.Main;

import java.util.Calendar;

public class Monitor extends Persona {

	private String especialidad=null;
	private int horasSemanales;
	
	public Monitor(){}
	
	public Monitor(String nombre, String apellidos, String perfil, int id, Calendar fechaNacimiento,
			int horasSemanales) {
		super(nombre, apellidos,perfil, id, fechaNacimiento);
		this.horasSemanales = horasSemanales;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public int getHorasSemanales() {
		return horasSemanales;
	}

	public void setHorasSemanales(int horasSemanales) {
		this.horasSemanales = horasSemanales;
	}
	
	
}
