package Modelo;

import java.util.Scanner;
import java.io.*;

public class Administradores {
    private String listadoDataAdministradores;
    
    public Administradores() {
        this.listadoDataAdministradores = "Data/dataAdministradores.txt";
        File file = new File(listadoDataAdministradores);
        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
                System.out.println("Archivo creado en: " + file.getAbsolutePath());
            } catch (IOException e) {
                System.err.println("Error al crear archivo: " + e.getMessage());
            }
        }
    }

    public boolean agregarAdministrador(String correo, String contrasena, String nombreCompleto, int cedula) {
        try {
            FileWriter writer = new FileWriter(listadoDataAdministradores, true);
            if (validarDatosAdministrador(correo, contrasena)) {
                writer.write(correo + ";" + contrasena + ";" + nombreCompleto + ";" + cedula + "\n");
                writer.close();
                System.out.println("Administrador registrado: " + nombreCompleto);
                return true;
            } else {
                System.out.println("Datos del administrador inválidos.");
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean validarDatosAdministrador(String correo, String contrasena) {
        String contenido;
        try(Scanner scanner = new Scanner(new File(listadoDataAdministradores))) {
            while(scanner.hasNextLine()) {
                contenido = scanner.nextLine();
                String[] datosAdministrador = contenido.split(";");
                if(datosAdministrador.length >= 2 && datosAdministrador[0].equals(correo) && datosAdministrador[1].equals(contrasena)) {
                    return false; // correo y contraseña ya existe
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
        }
        return true;
    }

    public boolean autenticarAdministrador(String correo, String contrasena) {
        String contenido;
        try (Scanner scanner = new Scanner(new File(listadoDataAdministradores))) {
            while (scanner.hasNextLine()) {
                contenido = scanner.nextLine();
                String[] datosAdministrador = contenido.split(";");
                if (datosAdministrador.length >= 2 && datosAdministrador[0].equals(correo) && datosAdministrador[1].equals(contrasena)) {
                    return true; // Admin y contraseña correctos
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
        }
        return false; // No coincide
    }
}
