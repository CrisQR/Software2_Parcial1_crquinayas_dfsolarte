/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.parcial1.modelo;

/**
 *
 * @author dafer
 */
public class Notificacion {
    private String titulo;
    private String descripcion;
    
    public Notificacion(){
        
    }
    
    public Notificacion(String titulo, String descripcion){
        this.titulo=titulo;
        this.descripcion=descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void imprimirNotificacion(){
        System.out.print(titulo);
        System.out.print(descripcion+"\n");
    }
}
