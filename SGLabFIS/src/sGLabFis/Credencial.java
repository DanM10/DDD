package sGLabFis;

public class Credencial {
	private String usuario;
	private String anydeskID;
	private String clave;
	
	
	public Credencial(String usuario, String anydeskID, String clave) {
	this.anydeskID= anydeskID;
	this.clave = clave;
	this.usuario=usuario;	
	}


	@Override
	public String toString() {
		return usuario+"\t"+anydeskID+"           \t"+clave;
	}
	
	

}
