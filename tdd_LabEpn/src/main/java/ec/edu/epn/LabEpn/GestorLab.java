package ec.edu.epn.LabEpn;

public class GestorLab {

    public GestorLab (){

    }
//Al refactorizar este metodo se lo puede mover a clase Adminisrador y asi no necesita un parametro admin
    public Computadora addPc(String nombreLab, Computadora pc, Administrador admin){
        Laboratorio auxLab= admin.buscarLab(nombreLab);
        //Si esque no existe un laboratorio con ese nombre, entonces devuelve null
        boolean esCodigoValido = nombreLab.equals(pc.getLaboratorio());
        boolean esCredencial = pc.getCredencial().isEstadoCredencial();
        if(auxLab!=null && esCodigoValido &&esCredencial){
            auxLab.addComputador(pc);
            return  pc;
        }else{
            return null;
        }

    }

    public Laboratorio addLaboratorio(String nombre, Administrador admin){
        Laboratorio lab = new Laboratorio(nombre);
        Laboratorio auxLab = admin.buscarLab(nombre);
        if(auxLab==null){
            admin.getListLabs().add(lab);
            return lab;
        }else{
            return null;
        }
    }

    public Computadora buscarComputadorPorEstudiante(String nombreEstudiante, Administrador admin){
        for(Laboratorio Lab :admin.getListLabs()) {
            for (Computadora auxComputador : Lab.getListComputadoras()) {
                if (auxComputador.getEstudiante()!=null) {
                    if (auxComputador.getEstudiante().getNombre().equals(nombreEstudiante)) {
                        return auxComputador;
                    }
                }
            }
        }
       return null;
    }
}
