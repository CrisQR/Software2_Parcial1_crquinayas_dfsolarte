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
public class Observado {
    private List<iObservador> listObservadores = new ArrayList<>();
    
    public void agregarObservador(iObservador newObservador){
        listObservadores.add(newObservador);
        //System.out.println("El observador ha sido agregado con exito");
    }
    
    public void actualizarAccion(Accion accion){
        //Se actualiza el precio de la accion recibida en cada observador
        for(iObservador observer : listObservadores ){
            observer.actualizar(accion);
        }
    }
}
