package Modelo;

import java.util.Scanner;
import java.io.*;

public class Usuarios {
    private String listadoDataUsuarios;
    
    public Usuarios() {
        this.listadoDataUsuarios = "Data/dataUsuarios.txt";
        
        File file = new File(listadoDataUsuarios);
        if (!file.exists()) {
            try {
                // Asegurarse que los directorios existen
                file.getParentFile().mkdirs();
                file.createNewFile();
                System.out.println("Archivo creado en: " + file.getAbsolutePath());
            } catch (IOException e) {
                System.err.println("Error al crear archivo: " + e.getMessage());
            }
        }
    }

    public boolean agregarUsuario(String correo, String contrasena, String nombreCompleto, int cedula) {
        
        // Validar los datos del usuario
        try {
            FileWriter writer = new FileWriter(listadoDataUsuarios, true);
            if (validarDatosUsuario(correo, contrasena)) {
                // Aquí se agregarían los datos del libro a la base de datos o estructura de almacenamiento
                writer.write(correo + ";" + contrasena + ";" + nombreCompleto + ";" + cedula + "\n");
                writer.close();
                System.out.println("Usuario registrado: " + nombreCompleto);
                return true;
            } else {
                System.out.println("Datos del usuario inválidos.");
            }
            
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean validarDatosUsuario(String correo, String contrasena) {
        String contenido;
        try(Scanner scanner = new Scanner(new File(listadoDataUsuarios))) {
            while(scanner.hasNextLine()) {
                contenido = scanner.nextLine();
                String[] datosUsuario = contenido.split(";");
                if(datosUsuario[1].equals(correo) && datosUsuario[2].equals(contrasena)) {
                    return false; // correo y contraseña ya existe
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
        }
        return true;
    }

    
    public boolean autenticarUsuario(String correo, String contrasena) {
        String contenido;
        try (Scanner scanner = new Scanner(new File(listadoDataUsuarios))) {
            while (scanner.hasNextLine()) {
                contenido = scanner.nextLine();
                String[] datosUsuario = contenido.split(";");
                if (datosUsuario.length >= 2 && datosUsuario[0].equals(correo) && datosUsuario[1].equals(contrasena)) {
                    return true; // Usuario y contraseña correctos
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
        }
        return false; // No coincide
    }

}
