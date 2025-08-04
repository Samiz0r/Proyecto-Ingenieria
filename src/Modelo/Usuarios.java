package Modelo;

import java.util.Scanner;
import java.io.*;

public class Usuarios {
    public String getCedula(String correo) {
        try (Scanner scanner = new Scanner(new File(listadoDataUsuarios))) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] datos = linea.split(";");
                if (datos.length >= 4 && datos[0].equals(correo)) {
                    return datos[3];
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    // Obtener el saldo de un usuario por correo
    public double getSaldoUsuario(String correo) {
        try (Scanner scanner = new Scanner(new File(listadoDataUsuarios))) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] datos = linea.split(";");
                if (datos.length >= 5 && datos[0].equals(correo)) {
                    return Double.parseDouble(datos[4]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    // Actualizar el saldo de un usuario por cédula (único método de actualización)
    public boolean actualizarSaldoPorCedula(String cedula, double nuevoSaldo) {
        File file = new File(listadoDataUsuarios);
        StringBuilder sb = new StringBuilder();
        boolean actualizado = false;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] datos = linea.split(";");
                if (datos.length >= 5 && datos[3].equals(cedula)) {
                    datos[4] = String.valueOf(nuevoSaldo);
                    linea = String.join(";", datos);
                    actualizado = true;
                }
                sb.append(linea).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        // Escribir el archivo actualizado
        try (FileWriter writer = new FileWriter(file, false)) {
            writer.write(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return actualizado;
    }
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

    public String getNombreCompleto(String correo) {
        try (Scanner scanner = new Scanner(new File(listadoDataUsuarios))) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] datos = linea.split(";");
                if (datos.length >= 3 && datos[0].equals(correo)) {
                    return datos[2];
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
