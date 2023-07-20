package paqueteuno;

public class Estudiante {
    
    private String nombre;
    private String apellido;
    private double calificacion1;
    private double calificacion2;
    private double calificacion3;
    private double promedio;

    public void establecerNombre(String n) {
        nombre = n;
    }

    public void establecerApellido(String n) {
        apellido = n;
    }

    public void establecerCalificacion1(double n) {
        calificacion1 = n;
    }

    public void establecerCalificacion2(double n) {
        calificacion2 = n;
    }

    public void establecerCalificacion3(double n) {
        calificacion3 = n;
    }

    public void establecerPromedio() {
        double suma = calificacion1+calificacion2+calificacion3;
        promedio = suma/3;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public String obtenerApellido() {
        return apellido;
    }

    public double obtenerCalificacion1() {
        return calificacion1;
    }

    public double obtenerCalificacion2() {
        return calificacion2;
    }

    public double obtenerCalificacion3() {
        return calificacion3;
    }

    public double obtenerPromedio() {
        return promedio;
    }
    
    @Override
    public String toString(){
        return String.format("%s %s\n"
                + "\tCalificaciones:\n"
                + "\t%.2f\n"
                + "\t%.2f\n"
                + "\t%.2f\n"
                + "\tPromedio: %.2f\n",
                nombre,
                apellido,
                calificacion1,
                calificacion2,
                calificacion3,promedio);
    }
    
    
}
