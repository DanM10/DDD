package sGLabFis;

import java.util.ArrayList;
import java.util.List;

public class Laboratorio {
	
	private String nombre;
	private List <Computadora> lab;
	
	
	public Laboratorio(String nombre) {
		this.nombre = nombre;
		lab = new ArrayList<Computadora>();
	}

	private  void addComputador(Computadora computadora) {
		lab.add(computadora);
	}

	public List<Computadora> getListComputadoras() {
		return lab;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Laboratorio [nombre=" + nombre + ", lab=" + lab.toString() + "]";
	}
	
	
	
}
