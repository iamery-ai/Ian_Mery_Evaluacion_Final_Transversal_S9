package model;

import java.util.List;

public class Cliente extends Persona implements Registrable {
    private String tarjeta;
    private int id;
    private String rut;

    public Cliente(Persona persona, String rut, String tarjeta, int id) {
        super(persona.getNombre(), persona.getApellido(), persona.getEdad(), persona.getDireccion(), persona.getComuna(), persona.getNumero(), persona.getRegion());
        this.tarjeta = tarjeta;
        this.id = id;

        if (!validarRut(rut)) {
            throw new IllegalArgumentException("RUT inválido: " + rut);
        }
        this.rut = rut;

    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        if (!validarRut(rut)) {
            throw new IllegalArgumentException("RUT inválido: " + rut);
        }
        this.rut = rut;
    }

    //Valida el rut
    public boolean validarRut(String rut) {
        if (rut == null) { return false; }

        try {
            if (rut.length() < 8 || rut.length() > 10) {
                return false;
            }

            if (rut.charAt(rut.length() - 2) != '-') {
                return false;
            }

            char dv = rut.charAt(rut.length() - 1);
            boolean dvValido = (dv >= '1' && dv <= '9') || dv == 'k' || dv == 'K';

            if (!dvValido) {
                return false;
            }

            String cuerpo = rut.substring(0, rut.length() - 2);
            if (!cuerpo.matches("\\d+")) {
                return false;
            }

            return true;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void registrar(List<Object> datos) {
        datos.add(this);
        System.out.println("Cliente ID: " + this.id);
        System.out.println("Registrada en Sistema!");
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Apellido: " + getApellido());
        System.out.println("Edad: " + getEdad());
        System.out.println("Direccion: " + getDireccion() + ", comuna: " + getComuna() +
                ", numero: " + getNumero() + ", region: " + getRegion());
        System.out.println("Rut: " + getRut());
        System.out.println("Tarjeta: " + getTarjeta());
        System.out.println("Id: " + getId());
    }

    @Override
    public String toString() {
        return getNombre() + ", Apellido: " + getApellido() +
                ", Edad: " + getEdad() + ", Direccion:  " + getDireccion() +
                ", Comuna: " + getComuna() + ", Numero:" + getNumero() +
                ", Region: " + getRegion() + ", Rut: " + rut + ", Tarjeta: " + tarjeta + ", Id: " + id;
    }
}
