/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.parcial1.main;

import co.edu.unicauca.parcial1.service.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author dafer
 */
public class Main {
    public static void main(String [] args){
        Cliente cliente1 = new Cliente(123456,"Daniel","Solarte");
        Pago pago;
        /**
         * En las siguientes lineas se puede ver como el objeto pago puede
         * convertirse en un objeto de PagoTarjetaCredito o PagoPaypal o 
         * PagoTransferencia significando que se cumple el principio de 
         * sustitucion de Liskov. Ademas notese que el cliente llama al 
         * metodo realizarPago de la interfaz cumpliendo con el principio 
         * de inversion de Dependencias.
         */
        while(true){
            int tipoPago = menuTipoPago();
            switch(tipoPago){
                case 1:
                    pago=new PagoTarjetaCredito();
                    cliente1.procesarPago(pago);
                    break;
                case 2:
                    pago=new PagoPaypal();
                    cliente1.procesarPago(pago);
                    break;
                case 3:
                    pago=new PagoTransferencia();
                    cliente1.procesarPago(pago);
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
        
    }
    
    public static int menuTipoPago(){
        int tipoPago=0;
        do{
            try{
                System.out.println("Ingrese un Tipo de Pago valido:");
                System.out.println("1. Tarjeta de credito.");
                System.out.println("2. Paypal.");
                System.out.println("3. Transferencia Bancaria.");
                System.out.println("4. Salir.");
                System.out.println("Ingrese un numero...");
                Scanner leer = new Scanner(System.in);
                tipoPago=leer.nextInt();
                return tipoPago;
            }catch(InputMismatchException ex){
                System.out.println("No se admiten caracteres...\n");
            }
            
        }while(tipoPago!=1 && tipoPago!=2 && tipoPago!=3 && tipoPago!=4);
        
        return tipoPago;
    }
}
