package co.edu.unicauca.parcial1.controlador;

import co.edu.unicauca.parcial1.modelo.*;
import co.edu.unicauca.parcial1.vista.Vista;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dafer
 */
public class Controlador {
    private List<Usuario> listUsuarios;
    private List<Accion> listAcciones;
    private Vista vista;
    
    public Controlador(){
        this.listAcciones=new ArrayList<>();
        this.listUsuarios=new ArrayList<>();
        this.vista = new Vista();
    }
    
    public Controlador(List<Usuario> listUsuarios, List<Accion> listAcciones){
        this.listAcciones=listAcciones;
        this.listUsuarios=listUsuarios;
        this.vista = new Vista();
    }

    public List<Usuario> getListUsuarios() {
        return listUsuarios;
    }

    public void setListUsuarios(List<Usuario> listUsuarios) {
        this.listUsuarios = listUsuarios;
    }

    public List<Accion> getListAcciones() {
        return listAcciones;
    }

    public void setListAcciones(List<Accion> listAcciones) {
        this.listAcciones = listAcciones;
    }
    
    public void modificarPrecio(Accion accion){
        //Se busca la accion en la lista de acciones del controlador
        for(Accion aux:listAcciones){
            if(aux.getNombre().equals(accion.getNombre())){
                //Una vez encontrada se le modifica el precioActual y el precioAnterior
                aux.setPrecioAnterior(aux.getPrecioActual());
                aux.setPrecioActual(accion.getPrecioActual());
                //Luego se llama a actualizarAccion de la clase observado
                aux.actualizarAccion(accion);
                break;
                
            }
        }
    }
    
    public void agregarAccionUsuario(Accion accion, Usuario usuario, long umbralInferior, long umbralSuperior){
        for(Accion auxAccion:listAcciones){
            if(auxAccion.getNombre().equals(accion.getNombre())){
                //Se crea una nueva accion para que no se modifiquen las demas
                Accion newAccion = new Accion(auxAccion.getNombre(), auxAccion.getPrecioActual(), auxAccion.getPrecioAnterior(), umbralInferior, umbralSuperior);
                for(Usuario auxUsuario: listUsuarios){
                    if(auxUsuario.getId()==usuario.getId()){
                        auxUsuario.agregarAccion(newAccion);
                        accion.agregarObservador(auxUsuario);
                        break;   
                    }
                }
            }
        }
    }
    
    public void cambiarUmbralInferiorAccionUsuario(String accion, Usuario usuario, long newUmbralInferior) {
        for(Accion auxAccion:usuario.getListAcciones()) {
            if(auxAccion.getNombre().equals(accion)) {
                auxAccion.setUmbralInferior(newUmbralInferior);
            }
        }
    }
    
     public void cambiarUmbralSuperiorAccionUsuario(String accion, Usuario usuario, long newUmbralSuperior) {
        for(Accion auxAccion:usuario.getListAcciones()) {
            if(auxAccion.getNombre().equals(accion)) {
                auxAccion.setUmbralInferior(newUmbralSuperior);
            }
        }
    }
    
    public boolean eliminarAccion(String nombreAccion) {
        Accion aux = new Accion();
        for(Accion auxAccion: listAcciones) {
            if(auxAccion.getNombre().equals(nombreAccion)) {
                aux = auxAccion;
                break;
            }
        }   
        
        for(Usuario auxUsuario: listUsuarios) {
            for(int i = 0; i < auxUsuario.getListAcciones().size(); i++) {
                if(auxUsuario.getListAcciones().get(i).getNombre().equals(nombreAccion)) {
                    auxUsuario.getListAcciones().remove(i);
                }
            }
        }
        
        if(listAcciones.remove(aux)) {
            return true;
        }
        
        return false;
    }
    
    public void imprimirUsuarios(){
        vista.imprimirUsuarios(listUsuarios);
    }
    
    public void imprimirAcciones(){
        vista.imprimirAcciones(listAcciones);
    }
    
    public void imprimirUsuarioAccion(){
        vista.imprimirUsuarioAccion(listUsuarios);
    }
}
