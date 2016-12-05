package pii.Main;

import java.util.Calendar;

public class Usuario extends Persona {

	private Calendar fechaAlta;
	private double saldo;
	
	public Usuario(){}
	
	public Usuario(String nombre, String apellidos,String perfil, int id, Calendar fechaNacimiento, Calendar fechaAlta,
			double saldo) {
		super(nombre, apellidos, perfil, id, fechaNacimiento);
		this.fechaAlta = fechaAlta;
		this.saldo = saldo;
	}
	
	@Override
	public String toString() {
		return null;
	}

	public Calendar getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Calendar fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	
	
}
