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
			//ListLab.get(0).getListComputadoras().get(6).setEstudiante(new Estudiante("00","Juan Pere","sda"));
			
		List<Solicitud> ListSol = new ArrayList<Solicitud>();
		Administrador dg = new Administrador(ListLab,ListSol);
		dg.asignarComputador(new Solicitud(new Estudiante("00","Juan Pere","sda"),8,"Red"),"GAMMA_6");
		return dg;
	}



	private static void menu(Administrador dg) {


		Scanner keyboard = new Scanner(System.in);
		Scanner keyboard2 = new Scanner(System.in);
		Scanner keyboard3 = new Scanner(System.in);
		Scanner keyboard4 = new Scanner(System.in);

		System.out.println("Seleccione que desea hacer:\n1. Asignar computador,\n2. Quitar computador,\n3. Mostrar computadores,"
				+ "\n4. Salir");

		int option = keyboard.nextInt();

		//Menu Principal
		switch (option){
			case 1: //Asignar computador
				//Ingresar RAM del computador
				List<Computadora> disponibles = new ArrayList<Computadora>();
				System.out.println("Ingrese la RAM del computador: 1. 4GB, 2. 8GB, 3. 12GB, 4. 16GB");
				int option2 = keyboard2.nextInt();
				if(option2 == 1) { //RAM de 4GB
					disponibles = dg.verificarDisponibilidad(4);
				}else if(option2 == 2) { //RAM de 8GB
					disponibles = dg.verificarDisponibilidad(8);
				}else if(option2 == 3) { //RAM de 12GB
					disponibles= dg.verificarDisponibilidad(12);
				}else if(option2 == 4) { //RAM de 16GB
					disponibles= dg.verificarDisponibilidad(16);
				}else { //Mensaje de error
					System.out.println("Seleccione una opcion valida");
					menu(dg);
				}
				
				//Elegir Maquina
				System.out.println("Elija el computador a asignar\n" +
						"Recuerde que debe escribir el nombre del laboratorio seguido por el numero de computador\n" +
						"Ejemplo: GAMMA_5");
				String computadorAsignado = keyboard4.nextLine();
				boolean encontrado = false;
				for(Computadora aux:disponibles){
					if(aux.getCodigo().equals(computadorAsignado)) {
						//Estudiante
						System.out.print("Ingrese codigo de estudiante:");
						String codigo = keyboard.next();
						System.out.print("Ingrese Nombre del Estudiante: ");
						String nombre = keyboard2.next();
						System.out.print("Ingrese correo del estudiante: ");
						String correo = keyboard3.next();
						Estudiante auxE = new Estudiante(codigo,nombre,correo);
						
						//Solicitud
						System.out.print("Ingrese materia: ");
						String materia = keyboard.next();
						Solicitud auxS = new Solicitud(auxE,option2,materia);
						dg.getListaSolic().add(auxS);
						//asignar
						System.out.println("Estas son las credenciales: ");
						dg.asignarComputador(auxS, computadorAsignado);
						Computadora asignadoC=null;
						asignadoC = dg.buscarComputador(computadorAsignado);
						System.out.println(asignadoC.getCredenciales());
						//dg.imprimirLabs(option2);
						System.out.println();
						encontrado=true;
						break;
						//
					}
				}
				
				if(!encontrado) {
					System.out.println("No existe esa maquina en la lista de disponibles");
				}
				menu(dg);
				break;
			case 2: //Quitar computador
				System.out.println("Elija el computador a quitar\n" +
						"Recuerde que debe escribir el nombre del laboratorio seguido por el numero de computador\n" +
						"Ejemplo: GAMMA_5");
				String computadorQuitado = keyboard4.nextLine();
				dg.quitarComputador(computadorQuitado);
				System.out.println("Computador retirado con exito");
				menu(dg);
				break;
			case 3: // Mostrar computadores
				dg.imprimirLabs(4);
				menu(dg);
				break;
			case 4: //Salir del sistema
				System.exit(0);
				break;
			default: //Mensaje de error
				System.out.println("Seleccione una opcion valida");
				menu(dg);
				break;
		}

	}

}
