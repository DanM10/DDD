package sGLabFis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

	public main() {
		// TODO Auto-generated constructor stub
		
	}

	public static void main(String[] args) {
		System.out.println("Bienvenido al Sistema de gestion de entrega de computadores del laboratorio de la FIS\n");
		Administrador dg = generarAdmin();
		menu(dg);
	}
	
	private static Administrador generarAdmin() {
		List<Laboratorio> ListLab = new ArrayList<Laboratorio>();
		ListLab.add(new Laboratorio("GAMMA"));
		ListLab.add(new Laboratorio("BETA"));

		Credencial aux = new Credencial("1234","1234","GR17");

		for(int i =0;i<5;i++) {
			String aux1 = "GAMMA_"+i;
			String aux2 = "BETA_"+i;
			ListLab.get(0).getListComputadoras().add(new Computadora(aux1,8,aux));
			ListLab.get(1).getListComputadoras().add(new Computadora(aux2,8,aux));
		}

		for(int i =5;i<10;i++) {
			String aux1 = "GAMMA_"+i;
			String aux2 = "BETA_"+i;
			ListLab.get(0).getListComputadoras().add(new Computadora(aux1,16,aux));
			ListLab.get(1).getListComputadoras().add(new Computadora(aux2,20,aux));
		}

		List<Solicitud> ListSol = new ArrayList<Solicitud>();

		Estudiante ej1 = new Estudiante("01","Daniel Garrido","dani@dfa");
		Estudiante ej2 = new Estudiante("02","Daniela","dani2@dfa");
		Estudiante ej3 = new Estudiante("03","Daniel C","dani3@dfa");

		Solicitud so1 = new Solicitud(ej1,8,"SSCC");
		Solicitud so2 = new Solicitud(ej2,20,"RED");
		Solicitud so3 = new Solicitud(ej3,16,"RA");

		ListSol.add(so1);
		ListSol.add(so2);
		ListSol.add(so3);


		Administrador dg = new Administrador(ListLab,ListSol);
		return dg;
	}
	
	
	
	private static void menu(Administrador dg) {
		

		Scanner keyboard = new Scanner(System.in);
		Scanner keyboard2 = new Scanner(System.in);
		Scanner keyboard3 = new Scanner(System.in);
		Scanner keyboard4 = new Scanner(System.in);

		System.out.println("Seleccione que desea hacer:\n1. Asignar computador,\n2. Quitar computador,\n3. Mostrar computadores");

		int option = keyboard.nextInt();

		//Menu Principal
		switch (option){
			case 1: //Asignar computador
				System.out.println("Ingrese la RAM del computador: 1. 4, 2. 8, 3. 12, 4. 16");
				int option2 = keyboard2.nextInt();
				if(option2 == 1) {
					dg.verificarDisponibilidad(4);
				}else if(option2 == 2) {
					dg.verificarDisponibilidad(8);
				}else if(option2 == 3) {
					dg.verificarDisponibilidad(12);
				}else if(option2 == 4) {
					dg.verificarDisponibilidad(16);
				}else {
					System.out.println("Seleccione una opcion valida");
					menu(dg);
				}

				System.out.println("Ingrese el codigo de la solicitud: so1, so2 o so3");
				String code = keyboard3.nextLine();
				System.out.println("Elija el computador a asignar\n" +
						"Recuerde que debe escribir el nombre del laboratorio seguido por el numero de computador\n" +
						"Ejemplo: GAMMA_5");
				String computadorAsignado = keyboard4.nextLine();
				if(code.equals("so1")) {
					dg.asignarComputador(dg.getListaSolic().get(0), computadorAsignado);
					dg.verificarDisponibilidad(4);
				}else if(code.equals("so2")){
					dg.asignarComputador(dg.getListaSolic().get(1), computadorAsignado);
					dg.verificarDisponibilidad(4);
				}else if(code.equals("so3")){
					dg.asignarComputador(dg.getListaSolic().get(2), computadorAsignado);
					dg.verificarDisponibilidad(4);
				}
				menu(dg);
				break;
			case 2: //Quitar computador
				System.out.println("Elija el computador a quitar\n" +
						"Recuerde que debe escribir el nombre del laboratorio seguido por el numero de computador\n" +
						"Ejemplo: GAMMA_5");
				String computadorQuitado = keyboard4.nextLine();
				dg.quitarComputador(computadorQuitado);
				menu(dg);
				break;
			case 3: // Mostrar computadores
				dg.verificarDisponibilidad(4);
				menu(dg);
				break;
			default:
				System.out.println("Seleccione una opcion valida");
				menu(dg);
				break;
		}

	}

}
