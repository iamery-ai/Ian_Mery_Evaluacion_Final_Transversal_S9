package data;

import model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class GestorDatos {
    public static List<Registrable> cargarRegistrables() {
        //Inicializa la lista de registrables
        List<Registrable> registrables = new ArrayList<>();
        //Abrir el archivo
        try {
            BufferedReader buffer = new BufferedReader(new FileReader("resources/clientes.txt"));
            String linea;
            //Leer el archivo
            while ((linea = buffer.readLine()) != null) {
                String[] datos = linea.split(";");
                Persona persona = new Persona(datos[0], datos[1], Integer.parseInt(datos[2]), datos[3], datos[4], Integer.parseInt(datos[5]), datos[6]);
                Cliente cliente = new Cliente(persona, datos[7], datos[8], Integer.parseInt(datos[9]));
                registrables.add(cliente);
            }
            buffer.close();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        try {
            BufferedReader buffer = new BufferedReader(new FileReader("resources/ordenes.txt"));
            String linea;
            //Leer el archivo
            while ((linea = buffer.readLine()) != null) {
                String[] datos = linea.split(";");
                Persona persona = new Persona(datos[1], datos[2], Integer.parseInt(datos[3]), datos[4], datos[5], Integer.parseInt(datos[6]), datos[7]);
                Cliente cliente = new Cliente(persona, datos[8], datos[9], Integer.parseInt(datos[10]));
                Producto producto = new Producto(Integer.parseInt(datos[11]),datos[12],Integer.parseInt(datos[13]),Integer.parseInt(datos[14]));
                Orden orden = new Orden(Integer.parseInt(datos[0]), cliente, producto, Integer.parseInt(datos[15]), Integer.parseInt(datos[16]));
                registrables.add(orden);
            }
            buffer.close();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        try {
            BufferedReader buffer = new BufferedReader(new FileReader("resources/productos.txt"));
            String linea;
            //Leer el archivo
            while ((linea = buffer.readLine()) != null) {
                String[] datos = linea.split(";");
                Producto producto = new Producto(Integer.parseInt(datos[0]),datos[1],Integer.parseInt(datos[2]),Integer.parseInt(datos[3]));
                registrables.add(producto);
            }
            buffer.close();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        return registrables;
    }

}
