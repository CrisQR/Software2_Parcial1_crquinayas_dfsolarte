/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.parcial1.service;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author dafer
 */
public class PagoTarjetaCredito implements Pago{
    
    private long numTarjeta;
    private int mesExpiracion;
    private int anioExpiracion;
    private int cvv;
    
    public PagoTarjetaCredito(){
    }
    
    @Override
    public boolean realizarPago() {
        try {
            Scanner leer = new Scanner(System.in);
            System.out.println("Ingrese el numero de la tarjeta: ");
            numTarjeta=leer.nextLong();
            System.out.println("Ingrese el mes de expiracion de la tarjeta: ");
            mesExpiracion=leer.nextInt();
            System.out.println("Ingrese el año de expiracion de la tarjeta: ");
            anioExpiracion=leer.nextInt();
            System.out.println("Ingrese el cvv: ");
            cvv=leer.nextInt();
            //Aqui se podrian verificar las credenciales llamando una capa de acceso
            //if(verificar(credenciales))...
        } catch (InputMismatchException ex) {
            System.out.println("No se admiten caracteres");
            return false;
        }
        return true;
    }
    
}
