package model;

import java.util.List;

public class Direccion implements Registrable {
    private String direccion;
    private String comuna;
    private int numero;
    private String region;

    public Direccion(String direccion, String comuna, int numero, String region) {
        this.direccion = direccion;
        this.comuna = comuna;
        this.numero = numero;
        this.region = region;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }


    @Override
    public void registrar(List<Object> datos) {
        datos.add(this);
        System.out.println("Direccion registrada en Sistema!");
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Calle: "+ direccion);
        System.out.println("Comuna: "+ comuna);
        System.out.println("Numero: "+ numero);
        System.out.println("Region: "+ region);
    }

    @Override
    public String toString() {
        return "Calle" + direccion + ", comuna: " + comuna + ", numero: " + numero + ", region: " + region ;
    }
}
