package ec.edu.epn.LabEpn;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RunWith(value = Parameterized.class)
public class GestorLabParametersTest extends TestCase {

    @BeforeClass
    public static Administrador setUpClass(){
        List<Laboratorio> ListLab = new ArrayList<Laboratorio>();
        List<Solicitud> ListSol = new ArrayList<Solicitud>();
        Administrador admin = new Administrador(ListLab,ListSol);
        return admin;
    }

    @Before
    public void  setUp(){
        Credencial aux = new Credencial("123","123","123");
        for(int i =0;i<5;i++) {
            String aux1 = "GAMMA_"+i;
            String aux2 = "BETA_"+i;
            setUpClass().getListLabs().get(0).getListComputadoras().add(new Computadora(aux1,8,aux));
            setUpClass().getListLabs().get(1).getListComputadoras().add(new Computadora(aux2,8,aux));
        }
    }

    private String Codigo;
    private int RAM;
    private String expected;

    public static Iterable<Object[]> parameters(){
        List <Object[]> objects = new ArrayList<Object[]>();
        //prueba en Gamma
        objects.add(new Object[]{"GAMMA_6",8,"GAMMA_6_8"});
        objects.add(new Object[]{"GAMMA_120",16,"GAMMA_120_16"});
        objects.add(new Object[]{"GAMMA_11",24,"GAMMA_11_24"});
        objects.add(new Object[]{"GAMMA_158",32,"GAMMA_158_32"});
        objects.add(new Object[]{"GAMMA_7818",64,"GAMMA_7818_64"});
        //prueba en beta
        objects.add(new Object[]{"BET_8",8,"BET_8_8"});
        objects.add(new Object[]{"BETA_12",16,"BETA_12_16"});
        objects.add(new Object[]{"BETA_110",24});
        objects.add(new Object[]{"BETA_12",32});
        objects.add(new Object[]{"BETA_69",64});
        return objects;
    }

    public void given_parameters_when_addPC_then_add(){
    }
}