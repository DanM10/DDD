package ec.edu.epn.LabEpn;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GestorLabTest {
    GestorLab g = null;
    Administrador dg = null;

    @Before
    public void setup(){
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
         dg = new Administrador(ListLab,ListSol);
        dg.asignarComputador(new Solicitud(new Estudiante("00","Juan Pere","sda"),8,"Red"),"GAMMA_6");
    }

    @Test
    public void given_pcName_when_addComputador_then_ok(){
        g = new GestorLab();
        Computadora pc =  new Computadora("GAMMA_101",8,new Credencial( "123","123","123"));
        assertNotNull(g.addPc("GAMMA", pc, dg));

    }
    @Test
    public void given_a_non_existing_lab_name_when_addLaboratorio_then_OK(){
        g= new GestorLab();
        assertNotNull(g.addLaboratorio("ALFA",dg));
    }
    @Test
    public void given_a_studentName_asigned_to_a_Pc_when_BuscarComputadoraPorEstudiante_then_Ok(){
        g = new GestorLab();
        Computadora expectedPC = dg.buscarComputador("GAMMA_6");
        assertEquals(expectedPC ,g.buscarComputadorPorEstudiante("Juan Pere",dg));
    }
    @Test
    public void given_a_studentName_notasigned_to_a_Pc_when_BuscarComputadoraPorEstudiante_then_NULL(){
        g = new GestorLab();
        assertNull(g.buscarComputadorPorEstudiante("Fake Name", dg));
    }
}