package ec.edu.epn.LabEpn;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(value = Parameterized.class)
public class GestorLabParametersTest extends TestCase {

//inicilaizacion parametros

    private String Codigo,expected,Lab;
    private int RAM;
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

    //constructor
    public GestorLabParametersTest(String Lab, String Codigo,int RAM, String expected){
        this.Lab = Lab;
        this.Codigo=Codigo;
        this.RAM=RAM;
        this.expected= expected;
    }


    @Parameterized.Parameters
    public static Iterable<Object[]> parameters(){
        List <Object[]> objects = new ArrayList<Object[]>();
        //prueba en Gamma
        objects.add(new Object[]{"GAMMA","GAMMA_6",8,"GAMMA_6_8"});
        objects.add(new Object[]{"GAMMA","GAMMA_120",16,"GAMMA_120_16"});
        objects.add(new Object[]{"GAMMA","GAMMA_11",24,"GAMMA_11_24"});
        objects.add(new Object[]{"GAMMA","GAMMA_158",32,"GAMMA_158_32"});
        objects.add(new Object[]{"GAMMA","GAMMA_7818",64,"GAMMA_7818_64"});
        //prueba en beta
        objects.add(new Object[]{"BETA","BETA_6",8,"BETA_6_8"});
        objects.add(new Object[]{"BETA","BETA_12",16,"BETA_12_16"});
        objects.add(new Object[]{"BETA","BETA_110",24,"BETA_110_24"});
        objects.add(new Object[]{"BETA","BETA_12",32,"BETA_12_32"});
        objects.add(new Object[]{"BETA","BETA_69",64,"BETA_69_64"});
        return objects;
    }

    //se comprueba que no ecista problema al añadir una computadora
    @Test
    public void given_parameters_when_addPC_then_add(){
        g = new GestorLab();
        Computadora pc =  new Computadora(Codigo,RAM,credencial);
        assertNotNull(g.addPc(Lab,pc,admin));
    }

    //se comprueba que todas las maquinas no esten ocupadas
    @Test
    public void given_when_addPC_then_OK(){
        g=new GestorLab();
        Computadora pc =  new Computadora(Codigo,RAM,credencial);
        assertEquals(false,pc.isEstaOcupada());
    }


    //se comprueba que la Ram coincida con la maquina que se anadio
    @Test
    public void given_when2_addPC_then_OK(){
        g=new GestorLab();
        Computadora pc =  new Computadora(Codigo,RAM,credencial);
        g.addPc(Lab,pc,admin);
        Laboratorio aux = admin.buscarLab(Lab);
        int size_lab = aux.getListComputadoras().size()-1;
        String coigoActual =  aux.getListComputadoras().get(size_lab).getCodigo();
        String ramActual = Integer.toString( aux.getListComputadoras().get(size_lab).getRAM());
        String actual = coigoActual.concat("_").concat(ramActual);
        assertEquals(expected,actual);
    }

}