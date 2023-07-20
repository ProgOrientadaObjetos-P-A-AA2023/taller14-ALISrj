package paqueteuno;

import java.util.Locale;
import java.util.Scanner;
import paquetedos.Enlace;

public class Principal {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        entrada.useLocale(Locale.US);
        Enlace c = new Enlace();

        boolean bandera = true;

        while (bandera) {

            System.out.print("Ingrese la cedula del Trabajador\n> ");
            String cedula = entrada.nextLine();
            System.out.print("Ingrese el nombre del Trabajador\n> ");
            String nombres = entrada.nextLine();
            System.out.print("Ingrese el correo del Trabajador\n> ");
            String correo = entrada.nextLine();
            System.out.print("Ingrese el sueldo del Trabajador\n> ");
            int sueldo = entrada.nextInt();
            entrada.nextLine();

            System.out.print("Ingrese el mes del sueldo del Trabajador\n> ");
            String mesSueldo = entrada.nextLine();

            Trabajador t = new Trabajador(cedula, nombres, correo, sueldo, mesSueldo);
            c.insertarTrabajador(t);

            System.out.print("\nSi desea salir del proceso, ingrese 'si'\n> ");
            String opcion = entrada.nextLine();
            if (opcion.equals("si")) {
                bandera = false;
            }
            System.out.println("");
        }
        
        c.establecerListaDataTrabajador();
        
        for (int i = 0; i < c.obtenerLista().size(); i++) {
            System.out.printf("Trabajador %d\n%s",i+1,c.obtenerLista().get(i));
        }
    }

}
