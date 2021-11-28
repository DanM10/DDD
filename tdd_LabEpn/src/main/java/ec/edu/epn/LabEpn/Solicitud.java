package ec.edu.epn.LabEpn;

public class Solicitud {

	private Estudiante estudiante;
	private int RAM;
	private String materia;
	
	
	public Solicitud(Estudiante estudiante, int rAM, String materia) {
		
		this.estudiante = estudiante;
		RAM = rAM;
		this.materia = materia;
	}


	public Estudiante getEstudiante() {
		return estudiante;
	}


	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}


	public int getRAM() {
		return RAM;
	}


	public void setRAM(int rAM) {
		RAM = rAM;
	}


	public String getMateria() {
		return materia;
	}


	public void setMateria(String materia) {
		this.materia = materia;
	}
	
	


}
