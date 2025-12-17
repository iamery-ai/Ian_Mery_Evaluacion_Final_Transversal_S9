package model;

import java.util.List;

public class Producto implements Registrable {
    private int id;
    private String nombre;
    private double precio;
    private int stock;

    public Producto(int id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public void registrar(List<Object> datos) {
        datos.add(this);
        System.out.println("Producto ID: " + this.id);
        System.out.println("Registrada en Sistema!");
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Id: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: " + precio);
        System.out.println("Stock: " + stock);
    }

    @Override
    public String toString() {
        return "Id Producto: " + id + ", Nombre: " + nombre + ", Precio: " + precio + ", Stock: " + stock;
    }
}
