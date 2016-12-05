package pii.Main;

import java.util.Calendar;

public class Persona {

	private String nombre;
	private String apellidos;
	private int id;
	private String perfil;
	private Calendar fechaNacimiento;

	public Persona(){}
	

	public Persona(String nombre, String apellidos, String perfil, int id, Calendar fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.perfil = perfil;
		this.id = id;
		this.fechaNacimiento = fechaNacimiento;
	}

	
	
	public String getPerfil() {
		return perfil;
	}


	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Calendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", id=" + id;
	}
	
}