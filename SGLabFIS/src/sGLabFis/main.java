package sGLabFis;

import java.util.ArrayList;
import java.util.List;

public class main {

	public main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		List<Laboratorio> ListLab = new ArrayList<Laboratorio>();
		ListLab.add(new Laboratorio("GAMMA"));
		ListLab.add(new Laboratorio("BETA"));
		
		Credencial aux = new Credencial("1234","1234","GR17");
		
		for(int i =0;i<5;i++) {
			String aux1 = "GAMMA_"+i;
			String aux2 = "BETTA_"+i;
			ListLab.get(0).getListComputadoras().add(new Computadora(aux1,8,aux));
			ListLab.get(1).getListComputadoras().add(new Computadora(aux2,8,aux));
		}
		
		for(int i =5;i<10;i++) {
			String aux1 = "GAMMA_"+i;
			String aux2 = "BETTA_"+i;
			ListLab.get(0).getListComputadoras().add(new Computadora(aux1,16,aux));
			ListLab.get(1).getListComputadoras().add(new Computadora(aux2,20,aux));
		}
		
		List<Solicitud> ListSol = new ArrayList<Solicitud>();
		
		Estudiante ej1 = new Estudiante("01","Daniel Garrido","dani@dfa");
		Estudiante ej2 = new Estudiante("01","Daniela","dani2@dfa");
		Estudiante ej3 = new Estudiante("01","Daniel C","dani3@dfa");
		
		Solicitud so1 = new Solicitud(ej1,8,"SSCC");
		Solicitud so2 = new Solicitud(ej2,20,"RED");
		Solicitud so3 = new Solicitud(ej3,16,"RA");
		
		ListSol.add(so1);
		ListSol.add(so2);
		ListSol.add(so3);
		
		
		Administrador dg = new Administrador(ListLab,ListSol);
		
		
		dg.verificarDisponibilidad(4);
		System.out.println();
		dg.asignarComputador(so3, "GAMMA_5");
		dg.verificarDisponibilidad(4);
		
			}

}
