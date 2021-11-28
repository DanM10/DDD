package sGLabFis;

import java.util.ArrayList;
import java.util.List;


public class Administrador {

	private List<Laboratorio> listLabs;
	private List<Solicitud> listaSolic;
	
	public Administrador(List<Laboratorio> listLabs, List<Solicitud> listaSolic) {
		this.listLabs = listLabs;
		this.listaSolic = listaSolic;
	}
	
	public void asignarComputador(Solicitud solicitud,String codigoMaquina) {
		String[] aux = codigoMaquina.split("_");
		String lab = aux[0];
		String num = aux[1];
		int numLab = Integer.parseInt(num);
		for(Laboratorio auxLab : listLabs) {
			if(auxLab.buscarComputador(codigoMaquina)!=null){
				final Computadora computadorAsignado = 	auxLab.getListComputadoras().get(numLab);
				computadorAsignado.setEstaOcupada(true);
				computadorAsignado.setEstudiante(solicitud.getEstudiante());

				break;
			}
		}

	}

	
	public void quitarComputador(String codigoMaquina) {
		boolean seEncontro=false;
		for (Laboratorio auxlab : listLabs) {
			final boolean computadorBuscado = auxlab.buscarComputador(codigoMaquina) != null;
			if(computadorBuscado){
				Computadora auxComputador = auxlab.buscarComputador(codigoMaquina);
				auxComputador.setEstaOcupada(false);
				seEncontro=true;
				auxComputador.setEstudiante(null);
			}
		}
		if(!seEncontro) {
			System.out.println("Codigo de Computador Incorrecto");
		}
	}
	
	
	public List<Computadora> verificarDisponibilidad(int Ram) {
		List<Computadora> disponibles = new ArrayList<Computadora>();
		return getComputadorasDisponibles(Ram, disponibles);
	}

	public List<Computadora> getComputadorasDisponibles(int Ram, List<Computadora> disponibles) {
		for(Laboratorio labAux :listLabs) {
			for(Computadora cpuAux: labAux.getListComputadoras()) {
				final boolean ramComputador = cpuAux.getRAM() >= Ram;
				final boolean computadorNoOcupado = !cpuAux.isEstaOcupada();
				if(ramComputador && computadorNoOcupado) {
					disponibles.add(cpuAux);
				}
			}
		}

		if(disponibles.isEmpty()) {
			System.out.println("No existen maquinas disponibles");
		}else {
			System.out.println("Las siguientes maquinas estan disponibles: "+"\n");
			System.out.println("Codigo\tRAM\tEstaOcupada\tUsuario\tAnydeskId\tContrase�a "+"Estudiante");
			System.out.println(disponibles);
		}
		return disponibles;
	}


	public Computadora buscarComputador(String codigoMaquina){
		for(Laboratorio Lab :this.listLabs) {
			for (Computadora auxComputador : Lab.getListComputadoras()) {
				if (auxComputador.getCodigo().equals(codigoMaquina)) {
					return auxComputador;
				}
			}
		}
		return null;
	}

	// ¿se esta usando este metodo?
	public List<Computadora> imprimirLabs(int Ram) {
		List<Computadora> disponibles = new ArrayList<Computadora>();
		for(Laboratorio labAux :listLabs) {
			for(Computadora cpuAux: labAux.getListComputadoras()) {
				final boolean ramComputador = cpuAux.getRAM() >= Ram;
				if(ramComputador) {
					disponibles.add(cpuAux);
				}
			}
		}
		
		if(disponibles.isEmpty()) {
			System.out.println("No existen maquinas disponibles");			
		}else {
			System.out.println("Las siguientes maquinas estan disponibles: "+"\n");
			System.out.println("Codigo\tRAM\tEstaOcupada\tUsuario\tAnydeskId\tContrasena "+"Estudiante");
			System.out.println(disponibles);
		}
		return disponibles;
	}
	
	
	public List<Solicitud> getListaSolic() {
		return listaSolic;
	}


	public boolean estaDisponible(String codigoMaquina) {
		for (Laboratorio auxlab : listLabs) {
			final boolean isAComputador = auxlab.buscarComputador(codigoMaquina)!=null;
			final boolean isOcupada = auxlab.buscarComputador(codigoMaquina).isEstaOcupada()==true;
			if (isAComputador && !isOcupada){
				return true;
			}
		}
		return false;
	}

	public List<Laboratorio> getListLabs() {
		return listLabs;
	}
}
