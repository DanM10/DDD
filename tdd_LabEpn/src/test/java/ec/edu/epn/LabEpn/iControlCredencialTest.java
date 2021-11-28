package ec.edu.epn.LabEpn;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class iControlCredencialTest {

    private GestorLab g;
    private static Credencial credencial;
    private static Administrador admin;



    @BeforeClass
    public static void setUpClass(){
        List<Laboratorio> ListLab = new ArrayList<Laboratorio>();
        ListLab.add(new Laboratorio("GAMMA"));
        ListLab.add(new Laboratorio("BETA"));
        admin = new Administrador(ListLab,null);

    }

    @Before
    public void  setUp(){
        credencial = new Credencial("123","123","123");
        for(int i =0;i<5;i++) {
            String aux1 = "GAMMA_"+i;
            String aux2 = "BETA_"+i;
            admin.getListLabs().get(0).getListComputadoras().add(new Computadora(aux1,8,credencial));
            admin.getListLabs().get(1).getListComputadoras().add(new Computadora(aux2,16,credencial));
        }
    }

    @Test
    public void give_credencial_when_is_correct_then_true() {
        iControlCredencial control = Mockito.mock(iControlCredencial.class);
        credencial = new Credencial("120","3","3e");
        Mockito.when(control.verificarCredencial(Mockito.any())).thenReturn(true);
        g = new GestorLab();
        Computadora pc =  new Computadora("GAMMA_X",0,credencial);
        pc.getCredencial().setEstadoCredencial(control.verificarCredencial(credencial));
        assertNotNull(g.addPc("GAMMA",pc,admin));
    }

    @Test
    public void give_credencial_when_is_correct_then_False() {
        iControlCredencial control = Mockito.mock(iControlCredencial.class);
        credencial = new Credencial("120","3","3e");
        Mockito.when(control.verificarCredencial(Mockito.any())).thenReturn(false);
        g = new GestorLab();
        Computadora pc =  new Computadora("GAMMA_X",0,credencial);
        pc.getCredencial().setEstadoCredencial(control.verificarCredencial(credencial));
        assertNull(g.addPc("GAMMA",pc,admin));
    }


}