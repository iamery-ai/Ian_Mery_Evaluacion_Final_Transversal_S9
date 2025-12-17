package model;

import java.util.List;

public class Orden implements Registrable {
    private int id;
    private Cliente cliente;
    private Producto producto;
    private int cantidad;
    private double total;


    public Orden(int id, Cliente cliente, Producto producto, int cantidad, double total) {
        this.id = id;
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }


    public double getTotal() {
        return total;
    }

    @Override
    public void registrar(List<Object> datos) {
        datos.add(this);
        System.out.println("Orden de compra ID: "+ this.id);
        System.out.println("Registrada en Sistema!");
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Id: " + id);
        System.out.println("Cliente: " + cliente);
        System.out.println("Producto: " + producto);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Total: " + total);
    }

    @Override
    public String toString() {
        return "Id Orden de Compra: " + id + ", Cliente: " + cliente + ", Producto: " + producto + ", Cantidad: " + cantidad + ", Total=" + total;
    }
}
