package app;

import data.GestorDatos;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //Inicializa lista vacia de registrables
    public static List<Registrable> registrables = new ArrayList<>();

    public static void main(String[] args) {
        //Carga los datos
        GestorDatos gestor = new GestorDatos();
        registrables = gestor.cargarRegistrables();

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        mostrarMenu();

        while (opcion != 5){
            System.out.println("Ingrese una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    mostrarResultados();
                    mostrarMenu();
                    break;
                case 2:
                    String nombre;
                    String apellido;
                    int edad;
                    String dir;
                    String comuna;
                    int numero;
                    String region;
                    String rut;
                    String tarjeta;
                    int id;
                    System.out.println("Ingrese el nombre: ");
                    nombre = scanner.nextLine();
                    System.out.println("Ingrese el apellido: ");
                    apellido = scanner.nextLine();
                    System.out.println("Ingrese la edad: ");
                    edad = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese la direccion: ");
                    dir = scanner.nextLine();
                    System.out.println("Ingrese la comuna: ");
                    comuna = scanner.nextLine();
                    System.out.println("Ingrese el numero: ");
                    numero = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese la region: ");
                    region = scanner.nextLine();
                    System.out.println("Ingrese el rut: ");
                    rut = scanner.nextLine();
                    while (!validarRut(rut)) {
                        System.out.println("Rut invalido. Ingrese el rut nuevamente sin puntos y con guion: ");
                        rut = scanner.nextLine();
                    }
                    System.out.println("Ingrese la tarjeta: ");
                    tarjeta = scanner.nextLine();
                    System.out.println("Ingrese el id: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    agregarCliente(nombre, apellido, edad, dir, comuna, numero, region, rut, tarjeta, id);
                    mostrarMenu();
                    break;
                case 3:
                    int productId;
                    String productName;
                    double precio;
                    int stock;
                    System.out.println("Ingre el id: ");
                    productId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese el nombre: ");
                    productName = scanner.nextLine();
                    System.out.println("Ingrese el precio: ");
                    precio = scanner.nextInt();
                    scanner.nextLine();
                    while (precio <= 0){
                        System.out.println("Precio invalido. Ingrese el precio nuevamente: ");
                        precio = scanner.nextInt();
                        scanner.nextLine();
                    }
                    System.out.println("Ingrese el stock: ");
                    stock = scanner.nextInt();
                    scanner.nextLine();
                    agregarProducto(productId, productName, precio, stock);
                    mostrarMenu();
                    break;
                case 4:
                    String objeto;
                    System.out.println("Ingrese el tipo de objeto a buscar: Cliente, Producto u Orden");
                    objeto = scanner.nextLine();
                    objeto = objeto.toLowerCase();
                    while(!objeto.equals("cliente") && !objeto.equals("producto") && !objeto.equals("orden")){
                        System.out.println("Tipo de objeto invalido. Ingrese el tipo de objeto nuevamente: ");
                        objeto = scanner.nextLine();
                        objeto = objeto.toLowerCase();
                    }
                    buscarPorTipo(objeto);
                    mostrarMenu();
                    break;
                case 5:
                    System.out.println("Gracias por usar el programa");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        }

    }
    //Muestra el menu
    public static void mostrarMenu(){
        System.out.println("\n");
        System.out.println("Menu");
        System.out.println("1. Mostrar resultados");
        System.out.println("2. Agregar Cliente");
        System.out.println("3. Agregar Producto");
        System.out.println("4. Buscar por tipo");
        System.out.println("5. Salir");
    }

    //Recorre las listas de clientes, productos y ordenes de compra. filtra por tipo de objeto.
    public static void mostrarResultados(){
        System.out.println("LISTA DE CLIENTES");
        for (Registrable registrable : registrables) {
            if(registrable instanceof Cliente){
                Cliente cliente = (Cliente) registrable;
                cliente.mostrarDatos();
                System.out.println("----------------");
            }
        }
        System.out.println("#################");
        System.out.println("LISTA DE PRODUCTOS");
        for (Registrable registrable : registrables) {
            if(registrable instanceof Producto){
                Producto producto = (Producto) registrable;
                producto.mostrarDatos();
                System.out.println("----------------");
            }
        }
        System.out.println("#################");
        System.out.println("LISTA DE ORDENES");
        for (Registrable registrable : registrables) {
            if(registrable instanceof Orden){
                Orden orden = (Orden) registrable;
                orden.mostrarDatos();
                System.out.println("----------------");
            }
        }
    }

    //Agregar cliente
    public static void agregarCliente(String nombre, String apellido, int edad, String dir, String comuna, int numero, String region, String rut, String tarjeta, int id){
        Persona persona = new Persona(nombre, apellido, edad, dir, comuna, numero, region);
        Cliente cliente = new Cliente(persona, rut, tarjeta, id);
        registrables.add(cliente);

    }

    //Agregar producto
    public static void agregarProducto(int id, String nombre, double precio, int stock){
        Producto producto = new Producto(id, nombre, precio, stock);
        registrables.add(producto);
    }

    //Busca por tipo de objeto
    public static void buscarPorTipo(String tipo) {
        switch (tipo){
            case "cliente":
                for(Registrable registrable : registrables){
                    if(registrable instanceof Cliente){
                        Cliente cliente = (Cliente) registrable;
                        cliente.mostrarDatos();
                        System.out.println("----------------");
                    }
                }
                break;
            case "producto":
                for(Registrable registrable : registrables){
                    if(registrable instanceof Producto){
                        Producto producto = (Producto) registrable;
                        producto.mostrarDatos();
                        System.out.println("----------------");
                    }
                }
                break;
            case "orden":
                for(Registrable registrable : registrables){
                    if(registrable instanceof Orden){
                        Orden orden = (Orden) registrable;
                        orden.mostrarDatos();
                        System.out.println("----------------");
                    }
                }
                break;
        }
    }


    //Valida el rut
    public static boolean validarRut(String rut) {
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
}
