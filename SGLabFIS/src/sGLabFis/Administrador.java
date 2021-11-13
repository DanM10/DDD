package sGLabFis;

import java.util.ArrayList;
import java.util.List;

public class Administrador {

	private List<Laboratorio> listLabs;
	private List<Solicitud> listaSolic;
	
	public Administrador(List<Laboratorio> listLabs, List<Solicitud> listaSolic) {
		super();
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
			System.out.println(disponibles);
		}
		return disponibles;
	}
	

}
