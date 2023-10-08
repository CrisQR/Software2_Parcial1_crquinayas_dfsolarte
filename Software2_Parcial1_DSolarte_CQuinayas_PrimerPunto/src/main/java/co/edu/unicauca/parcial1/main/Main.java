/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.parcial1.main;

import co.edu.unicauca.parcial1.controlador.Controlador;
import co.edu.unicauca.parcial1.modelo.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dafer
 */
public class Main {
    public static void main(String [] args){
        Controlador controlador = new Controlador();
        
        //USUARIOS
        Usuario usuario1 = new Usuario(1);
        Usuario usuario2 = new Usuario(2);
        
        //ACCIONES
        Accion accion1 = new Accion("Facebook",10000);
        Accion accion2 = new Accion("Google",20000);
        
        //LISTA USUARIOS
        List<Usuario> listUsuarios = new ArrayList<>();
        listUsuarios.add(usuario1);
        listUsuarios.add(usuario2);
        
        //LISTA ACCIONES
        List<Accion> listAcciones = new ArrayList<>();
        listAcciones.add(accion1);
        listAcciones.add(accion2);
        
        //AGREGAR LISTAS AL CONTROLADOR
        controlador.setListAcciones(listAcciones);
        controlador.setListUsuarios(listUsuarios);
        
        //IMPRIMIR LISTA ACCIONES
        System.out.print("====================================");
        controlador.imprimirAcciones();
        System.out.print("====================================");
        
        //IMPRIMIR LISTA USUARIOS
        controlador.imprimirUsuarios();
        System.out.print("====================================\n");
        
        //AGREGAR ACCION 1 A USUARIO 1 y 2 con Umbrales diferentes
        controlador.agregarAccionUsuario(accion1, usuario1, 500L, 12000L);
        controlador.agregarAccionUsuario(accion1, usuario2, 600L, 15000);
        
        //AGREGAR ACCION 2 A USUARIO 2
        controlador.agregarAccionUsuario(accion2, usuario2, 15000L, 25000L);
        
        //PRUEBA QUE SE CREARON CON UMBRALES DIFERENTES
        /*
        System.out.println("Umbral inferior de la accion 1 para el usuario 1: " + usuario1.getListAcciones().get(0).getUmbralInferior()); //Notar que ahora no se modifica la accion padre, sino la que cada usuario guarda en su lista
        System.out.println("Umbral inferior de la accion 1 para el usuario 2: " + usuario2.getListAcciones().get(0).getUmbralInferior());
        System.out.println("Umbral inferior de la accion 1 para el usuario 1: " + usuario1.getListAcciones().get(0).getUmbralInferior());
        */
        
        //IMPRIMIR LISTA DE ACCION PARA CADA USUARIO
        System.out.print("Lista de Acciones de Usuarios\n");
        controlador.imprimirUsuarioAccion();
        System.out.print("====================================\n");
        
        //SIMULAR NOTIFICACIONES
        
        System.out.print("\nSIMULAR NOTIFICACION A USUARIO 1 y 2 CAMBIO ACCION 1 precioActual=16000\n");
        accion1.setPrecioActual(16000L);
        controlador.modificarPrecio(accion1);
        
        System.out.print("\nSIMULAR NOTIFICACION A USUARIO 2 CAMBIO ACCION 2 precioActual=10000\n");
        accion2.setPrecioActual(10000L);
        controlador.modificarPrecio(accion2);
        
        //CAMBIAR UMBRALES A USUARIOS
        controlador.cambiarUmbralInferiorAccionUsuario("Facebook", usuario1, 1000L); 
        controlador.cambiarUmbralInferiorAccionUsuario("Facebook", usuario2, 800L);
        //System.out.println("Nuevo umbral inferior de la accion 1 para el usuario 1: " + usuario1.getListAcciones().get(0).getUmbralInferior());
        //System.out.println("Nuevo umbral inferior de la accion 1 para el usuario 2: " + usuario2.getListAcciones().get(0).getUmbralInferior());
        
        System.out.print("\nSIMULAR NOTIFICACION A USUARIO 1 CAMBIO ACCION 1 precioActual=900 nuevos umbrales\n");
        System.out.print("***LA NOTIFICICACION DEL USUARIO 2 NO DEBE APARECER YA QUE NO SUPERO SU UMBRAL***\n");
        accion1.setPrecioActual(900L);
        controlador.modificarPrecio(accion1);
        
        System.out.print("\nELIMINAR ACCION DE USUARIO 1: ACCION1\n");
        controlador.eliminarAccion("Google"); 
        System.out.print("====================================\n");
        System.out.print("Lista de Acciones de Usuarios\n");
        controlador.imprimirUsuarioAccion();
        System.out.print("====================================\n");
    }
}
