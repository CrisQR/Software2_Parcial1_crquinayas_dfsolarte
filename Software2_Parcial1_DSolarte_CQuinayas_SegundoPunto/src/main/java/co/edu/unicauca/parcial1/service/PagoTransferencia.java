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
public class PagoTransferencia implements Pago{
    private long numCuenta;
    private int clave;
    private String nombreBanco;

    public PagoTransferencia(){
    }
    
    @Override
    public boolean realizarPago() {
        try{
            Scanner leer = new Scanner(System.in);
            System.out.println("Ingrese el nombre del banco: ");
            nombreBanco=leer.nextLine();
            System.out.println("Ingrese el numero de la cuenta: ");
            numCuenta=leer.nextLong();
            System.out.println("Ingrese la clave: ");
            clave = leer.nextInt();
            //Aqui se podrian verificar las credenciales llamando una capa de acceso
            //if(verificar(credenciales))...
        }catch(InputMismatchException ex){
            System.out.println("No se admiten caracteres");
            return false;
        }
        return true;
    }
    
    
}
