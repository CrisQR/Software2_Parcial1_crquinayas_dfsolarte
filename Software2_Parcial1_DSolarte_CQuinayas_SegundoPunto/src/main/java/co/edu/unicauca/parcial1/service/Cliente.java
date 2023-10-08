/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.parcial1.service;

/**
 *
 * @author dafer
 */
public class Cliente {
    private long cedula;
    private String nombre;
    private String apellido;
    
    public Cliente (){
        
    }
    
    public Cliente (long cedula, String nombre, String apellido){
        this.cedula=cedula;
        this.nombre=nombre;
        this.apellido=apellido;
    }
    
    public void procesarPago(Pago pago){
        if(pago.realizarPago()){
            System.out.println("Pago realizado con exito.");
        }else{
            System.out.println("No se pudo realizar el pago");
        }
    }
}
