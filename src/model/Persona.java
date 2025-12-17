package model;

import java.util.List;

public class Persona extends Direccion implements Registrable {
    private String nombre;
    private String apellido;
    private int edad;

    public Persona(String nombre, String apellido, int edad, String direccion, String comuna, int numero, String region) {
        super(direccion, comuna, numero, region);
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    @Override
    public void registrar(List<Object> datos) {
        datos.add(this);
        System.out.println("Persona registrada en Sistema!");
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Apellido: " + getApellido());
        System.out.println("Edad: " + getEdad());
        System.out.println("Direccion: " + getDireccion() + ", comuna: " + getComuna() +
                ", numero: " + getNumero() + ", region: " + getRegion());
    }

    @Override
    public String toString() {
        return "Persona " + getNombre() + ", apellido:" + getApellido() +
                ", edad:" + getEdad() + ", direccion:" + getDireccion() +
                ", comuna:" + getComuna() + ", numero:" + getNumero() + ", region:" + getRegion();
    }

}
