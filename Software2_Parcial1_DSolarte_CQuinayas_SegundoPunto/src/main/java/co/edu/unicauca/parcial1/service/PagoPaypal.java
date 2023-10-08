package co.edu.unicauca.parcial1.service;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author dafer
 */
public class PagoPaypal implements Pago{
    
    private String correo;
    private String contrasenia;
    
    public PagoPaypal(){
    }
    
    //Metodo para realizar el pago (Retorna verdadero independientemente de las credenciales ingresadas)
    @Override
    public boolean realizarPago() {
        try{
            Scanner leer = new Scanner(System.in);
            System.out.println("Ingrese su correo: ");
            correo=leer.nextLine();
            System.out.println("Ingrese la contraseña: ");
            contrasenia=leer.nextLine();
            //Aqui se podrian verificar las credenciales llamando una capa de acceso
            //if(verificar(this))...
        }catch(InputMismatchException ex){
            System.out.println("No se admiten caracteres");
            return false;
        }
        return true;
    }
    
}
