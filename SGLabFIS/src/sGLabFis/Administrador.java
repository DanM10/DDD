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
			if(auxLab.getNombre().equals(lab)) {
				auxLab.getListComputadoras().get(numLab).setEstaOcupada(true);
				auxLab.getListComputadoras().get(numLab).setEstudiante(solicitud.getEstudiante());
				System.out.println(auxLab.getListComputadoras().get(numLab).getCredenciales());
				break;
			}
		}
	}
	
	public void quitarComputador(String codigoMaquina) {
		boolean seEncontro=false;
		for (Laboratorio auxlab : listLabs) {
			for (Computadora auxComputador : auxlab.getListComputadoras()) {
				if(auxComputador.getCodigo().equals(codigoMaquina)) {
					auxComputador.setEstaOcupada(false);
					seEncontro=true;
					auxComputador.setEstudiante(null);
				}
			}
		}
		if(!seEncontro) {
			System.out.println("C�digo de Computador Incorrecto");
		}
		
	}
	
	
	public List<Computadora> verificarDisponibilidad(int Ram) {
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
			System.out.println("C�digo\t\tRAM\tEstaOcupada\tUsuario\tAnydeskId\tContrase�a\tEstudiante");
			System.out.println(disponibles);
		}
		return disponibles;
	}

	public List<Solicitud> getListaSolic() {
		return listaSolic;
	}

	public boolean estaDisponible(String codigoMaquina) { //Verifica que un computador este disponible
		boolean disponible= false;
		for (Laboratorio auxlab : listLabs) {
			for (Computadora auxComputador : auxlab.getListComputadoras()) {
				if(auxComputador.getCodigo().equals(codigoMaquina) && auxComputador.getEstudiante()==null) {
					return disponible=false;
				}else {
					disponible = true;
				}
			}
		}
		return disponible;
	}

}
