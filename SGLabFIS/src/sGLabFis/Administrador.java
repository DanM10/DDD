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
				auxLab.getListComputadoras().get(numLab).setEstaOcupada(true);
				auxLab.getListComputadoras().get(numLab).setEstudiante(solicitud.getEstudiante());
				System.out.println(auxLab.getListComputadoras().get(numLab).getCredenciales());
				break;

			}
		}
		Laboratorio auxLab = buscarLab(lab);
		auxLab.getListComputadoras().get(numLab).setEstaOcupada(true);
		auxLab.getListComputadoras().get(numLab).setEstudiante(solicitud.getEstudiante());
		System.out.println(auxLab.getListComputadoras().get(numLab).getCredenciales());
	}
	public Laboratorio buscarLab(String nombre){
		for (Laboratorio auxLab:listLabs) {
			if(auxLab.getNombre().equals(nombre)){
				return auxLab;
			}
		}
		return null;
	}
	
	public void quitarComputador(String codigoMaquina) {
		boolean seEncontro=false;
		for (Laboratorio auxlab : listLabs) {
			if(auxlab.buscarComputador(codigoMaquina)!=null){
				Computadora auxComputador = auxlab.buscarComputador(codigoMaquina);
				auxComputador.setEstaOcupada(false);
				seEncontro=true;
				auxComputador.setEstudiante(null);
			}
		}
		if(!seEncontro) {
			System.out.println("C�digo de Computador Incorrecto");
		}
	}
	
	
	public List<Computadora> verificarDisponibilidad(int Ram) {
		List<Computadora> disponibles = new ArrayList<Computadora>();
		return getComputadorasDisponibles(Ram, disponibles);
	}

	public List<Computadora> getComputadorasDisponibles(int Ram, List<Computadora> disponibles) {
		for(Laboratorio labAux :listLabs) {
			for(Computadora cpuAux: labAux.getListComputadoras()) {
				if(cpuAux.getRAM() >= Ram && cpuAux.isEstaOcupada() == false) {
					disponibles.add(cpuAux);
				}
			}
		}

		if(disponibles.isEmpty()) {
			System.out.println("No existen maquinas disponibles");
		}else {
			System.out.println("Las siguientes maquinas estan disponibles: "+"\n");
			System.out.println("C�digo\tRAM\tEstaOcupada\tUsuario\tAnydeskId\tContrase�a "+"Estudiante");
			System.out.println(disponibles);
		}
		return disponibles;
	}
	public Computadora buscarComputador(String codigoMaquina, Laboratorio auxLab){
		for (Computadora auxComputador:auxLab.getListComputadoras()) {
			if(auxComputador.getCodigo().equals(codigoMaquina)){
				return  auxComputador;
			}
		}
		return null;
	}

	// ¿se esta usando este metodo?
	public List<Computadora> imprimirLabs(int Ram) {
		List<Computadora> disponibles = new ArrayList<Computadora>();
		for(Laboratorio labAux :listLabs) {
			for(Computadora cpuAux: labAux.getListComputadoras()) {
				if(cpuAux.getRAM() >= Ram) {
					disponibles.add(cpuAux);
				}
			}
		}
		
		if(disponibles.isEmpty()) {
			System.out.println("No existen maquinas disponibles");			
		}else {
			System.out.println("Las siguientes maquinas estan disponibles: "+"\n");
			System.out.println("C�digo\tRAM\tEstaOcupada\tUsuario\tAnydeskId\tContrase�a "+"Estudiante");
			System.out.println(disponibles);
		}
		return disponibles;
	}
	
	
	public List<Solicitud> getListaSolic() {
		return listaSolic;
	}


	public boolean estaDisponible(String codigoMaquina) {
		for (Laboratorio auxlab : listLabs) {
			if (auxlab.buscarComputador(codigoMaquina)!=null&&auxlab.buscarComputador(codigoMaquina).isEstaOcupada()==false){
				return true;
			}
		}
		return false;
	}


}
