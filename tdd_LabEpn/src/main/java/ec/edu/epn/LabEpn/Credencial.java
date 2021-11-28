package ec.edu.epn.LabEpn;

public class Credencial {
	private String usuario;
	private String anydeskID;
	private String clave;
	private boolean estadoCredencial;
	
	
	public Credencial(String usuario, String anydeskID, String clave) {
	this.anydeskID= anydeskID;
	this.clave = clave;
	this.usuario=usuario;
	this.estadoCredencial=true;
	}

	public boolean isEstadoCredencial() {
		return estadoCredencial;
	}

	public void setEstadoCredencial(boolean estadoCredencial) {
		this.estadoCredencial = estadoCredencial;
	}

	@Override
	public String toString() {
		return usuario+"\t"+anydeskID+"           \t"+clave;
	}
	
	

}
