package sGLabFis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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


		Scanner keyboard = new Scanner(System.in);
		Scanner keyboard2 = new Scanner(System.in);
		Scanner keyboard3 = new Scanner(System.in);
		Scanner keyboard4 = new Scanner(System.in);

		System.out.println("Bienvenido al Sistema de gestión de entrega de computadores del laboratorio de la FIS\n"
				+"Ingrese la RAM del computador: 1. 4, 2. 8, 3. 12, 4. 16");
		int option = keyboard.nextInt();

		//Asignar la cantidad de RAM necesaria
		switch (option){
			case 1:
				dg.verificarDisponibilidad(4);
				break;
			case 2:
				dg.verificarDisponibilidad(8);
				break;
			case 3:
				dg.verificarDisponibilidad(12);
				break;
			case 4:
				dg.verificarDisponibilidad(16);
				break;
			default:
				System.out.println("Seleccione una opción válida");
				break;
		}

		System.out.println();

		System.out.println("Seleccione que desea hacer: 1. Asignar computador, 2. Quitar computador");
		int option2 = keyboard2.nextInt();

		switch (option2){
			case 1:
				System.out.println("Ingrese el código de la solicitud:");
				//Solicitud code = keyboard3.next();
				System.out.println("Elija el computador a asignar\n" +
						"Recuerde que debe escribir el nombre del laboratorio seguido por el número de computador\n" +
						"Ejemplo: GAMMA_5");
				String computadorAsignado = keyboard4.nextLine();
				//dg.asignarComputador(code, computadorAsignado);
				break;
			case 2:
				System.out.println("Elija el computador a quitar\n" +
						"Recuerde que debe escribir el nombre del laboratorio seguido por el número de computador\n" +
						"Ejemplo: GAMMA_5");
				String computadorQuitado = keyboard4.nextLine();
				dg.quitarComputador(computadorQuitado);
				break;
			default:
				System.out.println("Seleccione una opción válida");
				break;
		}


	}

}
