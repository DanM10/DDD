package sGLabFis;

public class Computadora {
	private String Codigo;
	private int RAM;
	private boolean EstaOcupada = false;
	private String laboratorio;
	private String numero;
	private Credencial credencial;
	private Estudiante estudiante;
	
	
	public Computadora(String Codigo, int Ram, Credencial credencial) {
		this.Codigo = Codigo;
		this.RAM = Ram;
		String[] aux = Codigo.split("_");
		this.laboratorio = aux[0];
		this.numero = aux[1];
		this.credencial = credencial;
		this.estudiante = null;
	}

	public Computadora() {
	}

	public int getRAM() {
		return RAM;
	}


	public void setRAM(int rAM) {
		RAM = rAM;
	}


	public boolean isEstaOcupada() {
		return EstaOcupada;
	}


	public void setEstaOcupada(boolean estaOcupada) {
		EstaOcupada = estaOcupada;
	}


	public String getCodigo() {
		return Codigo;
	}


	public String getLaboratorio() {
		return laboratorio;
	}


	public String getNumero() {
		return numero;
	}

	public String getCredenciales() {
		return this.credencial.toString();
	}


	public Estudiante getEstudiante() {
		return estudiante;
	}


	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}


	@Override
	public String toString() {
		return Codigo+"\t"+RAM+"   \t"+EstaOcupada+"      \t"+credencial.toString()+"\t      "+estudiante+"\n";
	}
	
	
}
