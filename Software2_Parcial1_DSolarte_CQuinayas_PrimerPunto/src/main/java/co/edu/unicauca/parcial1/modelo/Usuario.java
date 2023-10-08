/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.parcial1.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dafer
 */
public class Usuario implements iObservador{
    
    private int id;
    private List<Accion> listAcciones;
    private List<Notificacion> listNotificaciones;

    public Usuario(){
        this.listAcciones=new ArrayList<>();
        this.listNotificaciones=new ArrayList<>();
    }
    
    public Usuario(int id){
        this.id=id;
        this.listAcciones=new ArrayList<>();
        this.listNotificaciones=new ArrayList<>();
    }
    
    public Usuario(int id, List<Accion> listAcciones){
        this.id=id;
        this.listAcciones=listAcciones;
        this.listNotificaciones=new ArrayList<>();
    }
    
    public Usuario(int id, List<Accion> listAcciones, List<Notificacion> listNotificaciones){
        this.id=id;
        this.listAcciones=listAcciones;
        this.listNotificaciones=listNotificaciones;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Accion> getListAcciones() {
        return listAcciones;
    }

    public void setListAcciones(List<Accion> listAcciones) {
        this.listAcciones = listAcciones;
    }

    public List<Notificacion> getListNotificaciones() {
        return listNotificaciones;
    }

    public void setListNotificaciones(List<Notificacion> listNotificaciones) {
        this.listNotificaciones = listNotificaciones;
    }
    
    public void agregarAccion(Accion accion){
        //PRECONDICION: La accion ya existe
        listAcciones.add(accion);
    }
    
    @Override
    public void actualizar(Accion accion) {
        //PRECONDICION: La accion ya existe
        //Se busca la accion en la lista de acciones del usuario
        for(Accion aux: listAcciones){
            if(aux.getNombre().equals(accion.getNombre())){
                //Una vez
                aux.setPrecioAnterior(accion.getPrecioAnterior());
                aux.setPrecioActual(accion.getPrecioActual());
                //Verificar si se supero alguno de los umbrales establecidos por el usuario
                if(aux.getPrecioActual()>aux.getUmbralSuperior()){
                    Notificacion ntf = new Notificacion();
                    ntf.setTitulo("Usuario: "+this.id+" --> ");
                    ntf.setDescripcion("Notificacion: La accion "+aux.getNombre()+" ha superado el umbral Superior");
                    listNotificaciones.add(ntf);
                    ntf.imprimirNotificacion();
                }else if(aux.getPrecioActual()<aux.getUmbralInferior()){
                    Notificacion ntf = new Notificacion();
                    ntf.setTitulo("Usuario: "+this.id+" --> ");
                    ntf.setDescripcion("Notificacion: La accion "+aux.getNombre()+" ha superado el umbral Inferior");
                    listNotificaciones.add(ntf);
                    ntf.imprimirNotificacion();
                }
                break;
            }
        }
    }
    
}
