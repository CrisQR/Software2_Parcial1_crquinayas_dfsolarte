/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.parcial1.vista;

import co.edu.unicauca.parcial1.modelo.*;
import java.util.List;

/**
 *
 * @author dafer
 */
public class Vista {
    
    public void imprimirUsuarios(List<Usuario> listUsuarios){
        System.out.println("\nLista Usuarios");
        for(Usuario auxUsuario: listUsuarios){
            System.out.println("");
            System.out.println("Id usuario: "+auxUsuario.getId());
        }
    }
    
    public void imprimirAcciones(List<Accion> listAcciones){
        System.out.println("\nLista Acciones");
        for(Accion auxAccion: listAcciones){
            System.out.println("");
            System.out.println("Nombre: "+auxAccion.getNombre());
            System.out.println("Precio Actual: "+auxAccion.getPrecioActual());
            System.out.println("Precio Anterior: "+auxAccion.getPrecioAnterior());
        }
    }
    
    public void imprimirUsuarioAccion(List<Usuario> listUsuarios){
        for(Usuario auxUsuario: listUsuarios){
            System.out.println("");
            System.out.println("Id usuario: "+auxUsuario.getId());
            for(Accion auxAccion: auxUsuario.getListAcciones()){
                System.out.println("Nombre accion: "+auxAccion.getNombre());
            }
        }
    }
}
