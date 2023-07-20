package paqueteuno;

public class Trabajador {

    private String cedula;
    private String nombres;
    private String correo;
    private int sueldo;
    private String mesSueldo;

    public Trabajador(){
    
    }
    
    public Trabajador(String c, String n, String co, int su, String m) {
        cedula = c;
        nombres = n;
        correo = co;
        sueldo = su;
        mesSueldo = m;
    }
    
    public void establecerCedula(String n) {
        cedula = n;
    }

    public void establecerNombres(String n) {
        nombres = n;
    }

    public void establecerCorreo(String n) {
        correo = n;
    }

    public void establecerSueldo(int n) {
        sueldo = n;
    }

    public void establecerMesSueldo(String n) {
        mesSueldo = n;
    }

    public String obtenerCedula() {
        return cedula;
    }

    public String obtenerNombres() {
        return nombres;
    }

    public String obtenerCorreo() {
        return correo;
    }

    public int obtenerSueldo() {
        return sueldo;
    }

    public String obtenerMesSueldo() {
        return mesSueldo;
    }

    @Override
    public String toString() {
        return String.format("\tNombre: %s\n"
                + "\tCedula: %s\n"
                + "\tCorreo: %s\n"
                + "\tSueldo: %d\n"
                + "\tMes del sueldo: %s\n", nombres, cedula,
                correo, sueldo, mesSueldo);
    }

}
