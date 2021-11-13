package sGLabFis;

public class Estudiante {

	private String Codigo;
	private String Nombre;
	private String Correo;
	

	public Estudiante(String codigo, String nombre, String correo) {
		Codigo = codigo;
		Nombre = nombre;
		Correo = correo;
	}


	public String getCodigo() {
		return Codigo;
	}


	public void setCodigo(String codigo) {
		Codigo = codigo;
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public String getCorreo() {
		return Correo;
	}


	public void setCorreo(String correo) {
		Correo = correo;
	}


	@Override
	public String toString() {
		return Codigo;
	}
	
	

}
