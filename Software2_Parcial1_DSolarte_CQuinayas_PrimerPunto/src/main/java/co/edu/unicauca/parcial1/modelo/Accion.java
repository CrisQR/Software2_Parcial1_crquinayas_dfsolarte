/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.parcial1.modelo;

/**
 *
 * @author dafer
 */
public class Accion extends Observado{
    
    private String nombre;
    private long precioActual;
    private long precioAnterior;
    private long umbralInferior;
    private long umbralSuperior;
    
    public Accion(){
    }
    
    public Accion(String nombre, long precioActual){
        this.nombre=nombre;
        this.precioActual=precioActual;
        this.precioAnterior=0;
    }
    
    public Accion(String nombre, long precioActual, long precioAnterior, long umbralInferior, long umbralSuperior){
        this.nombre=nombre;
        this.precioActual=precioActual;
        this.precioAnterior=precioAnterior;
        this.umbralInferior=umbralInferior;
        this.umbralSuperior=umbralSuperior;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getPrecioActual() {
        return precioActual;
    }

    public void setPrecioActual(long precioActual) {
        this.precioActual = precioActual;
    }

    public long getPrecioAnterior() {
        return precioAnterior;
    }

    public void setPrecioAnterior(long precioAnterior) {
        this.precioAnterior = precioAnterior;
    }

    public long getUmbralInferior() {
        return umbralInferior;
    }

    public void setUmbralInferior(long umbralInferior) {
        this.umbralInferior = umbralInferior;
    }

    public long getUmbralSuperior() {
        return umbralSuperior;
    }

    public void setUmbralSuperior(long umbralSuperior) {
        this.umbralSuperior = umbralSuperior;
    }
    
}
