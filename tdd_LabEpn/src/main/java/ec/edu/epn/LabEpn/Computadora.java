package ec.edu.epn.LabEpn;

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
		separarCodigo(Codigo);
		this.credencial = credencial;
		this.estudiante = null;
	}


	//refactor pilas
	private String[] separarCodigo(String Codigo) {
		String[] aux = Codigo.split("_");
		this.laboratorio = aux[0];
		this.numero = aux[1];
		return aux;
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

	public String getCredencialesString() {
		return this.credencial.toString();
	}

	public Credencial getCredencial() {
		return credencial;
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
