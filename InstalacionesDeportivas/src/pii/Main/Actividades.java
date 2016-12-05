package pii.Main;

import java.util.ArrayList;

public class Actividades {

	private String nombre;
	private String siglas;
	private int numeroUsuarios;
	private Monitor monitor;
	private ArrayList<String> actividadesAnteriores = new ArrayList<String>();
	
	
	
	public Actividades() {}
	
	public Actividades(String nombre, String siglas, int numeroUsuarios, Monitor monitor,
			ArrayList<String> actividadesAnteriores) {
		this.nombre = nombre;
		this.siglas = siglas;
		this.numeroUsuarios = numeroUsuarios;
		this.monitor = monitor;
		this.actividadesAnteriores = actividadesAnteriores;
	}
	
	@Override
	public String toString() {
		return "Actividades [nombre=" + nombre + ", siglas=" + siglas + ", numeroUsuarios=" + numeroUsuarios
				+ ", monitor=" + monitor + ", actividadesAnteriores=" + actividadesAnteriores + "]";
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSiglas() {
		return siglas;
	}
	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}
	public int getNumeroUsuarios() {
		return numeroUsuarios;
	}
	public void setNumeroUsuarios(int numeroUsuarios) {
		this.numeroUsuarios = numeroUsuarios;
	}
	public Monitor getMonitor() {
		return monitor;
	}
	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}
	public ArrayList<String> getActividadesAnteriores() {
		return actividadesAnteriores;
	}
	public void setActividadesAnteriores(ArrayList<String> actividadesAnteriores) {
		this.actividadesAnteriores = actividadesAnteriores;
	}

	
}
