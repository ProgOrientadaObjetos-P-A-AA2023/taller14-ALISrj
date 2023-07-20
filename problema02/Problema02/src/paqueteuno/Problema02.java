package paqueteuno;

import paquetedos.Enlace;

public class Problema02 {

    public static void main(String[] args) {
       
        Enlace c = new Enlace();
        c.establecerListaDataEstudiante();
        
        for (int i = 0; i < c.obtenerLista().size(); i++) {
            System.out.printf("%s\n",c.obtenerLista().get(i));
        }
        
    }
    
}
