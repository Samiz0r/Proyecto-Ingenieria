package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import Vista.EscanerFoto;

public class EscanerFotoController implements ActionListener {
    private EscanerFoto vistaEscanerFoto;
    private String cedulaUsuario;
    private File imagenSeleccionada;

    public EscanerFotoController(String cedulaUsuario) {
        this.cedulaUsuario = cedulaUsuario;
        vistaEscanerFoto = new EscanerFoto();
        vistaEscanerFoto.setVisible(true);
        vistaEscanerFoto.setControlador(this);
    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        switch (comando) {
            case "SUBIR_FOTO":
                JFileChooser fileChooser = new JFileChooser();
                int resultado = fileChooser.showOpenDialog(vistaEscanerFoto);
                if (resultado == JFileChooser.APPROVE_OPTION) {
                    imagenSeleccionada = fileChooser.getSelectedFile();
                    vistaEscanerFoto.mostrarImagen(imagenSeleccionada);
                }
                break;
            case "VERIFICAR_FOTO":
                if (imagenSeleccionada == null) {
                    JOptionPane.showMessageDialog(vistaEscanerFoto, "Primero debe subir una foto.");
                    return;
                }
                // Cambiar la ruta para que apunte a la carpeta correcta dentro de Recursos
                File carpetaBD = new File("Recursos/BDSecretaria");
                File[] archivos = carpetaBD.listFiles();
                boolean encontrada = false;
                if (archivos != null) {
                    for (File archivo : archivos) {
                        String nombreSinExtension = archivo.getName().split("\\.")[0];
                        if (nombreSinExtension.equals(cedulaUsuario)) {
                            encontrada = true;
                            // Comparación de píxeles entre la imagen subida y la de la BD
                            File imagenBD = archivo;
                            boolean sonIguales = compararImagenesPorPixeles(imagenSeleccionada, imagenBD);
                            if (sonIguales) {
                                // Validación de saldo y reserva
                                double saldo = obtenerSaldoUsuario(cedulaUsuario);
                                double ccb = obtenerCCBUsuario(cedulaUsuario);
                                boolean hizoReserva = verificarReserva(cedulaUsuario);
                                double descuento = ccb * 0.3;
                                if (saldo >= descuento && hizoReserva) {
                                    Modelo.Usuarios usuarios = new Modelo.Usuarios();
                                    usuarios.actualizarSaldoPorCedula(cedulaUsuario, saldo - descuento);
                                    JOptionPane.showMessageDialog(vistaEscanerFoto, "Ingreso al comedor exitoso");
                                    vistaEscanerFoto.setVisible(false);
                                    new DashboardController(obtenerCorreoPorCedula(cedulaUsuario));
                                } else if (!hizoReserva) {
                                    JOptionPane.showMessageDialog(vistaEscanerFoto, "No se encontró reserva para el usuario.");
                                } else {
                                    JOptionPane.showMessageDialog(vistaEscanerFoto, "Saldo insuficiente para cubrir el 30% del CCB.");
                                }
                            } else {
                                JOptionPane.showMessageDialog(vistaEscanerFoto, "Las imágenes no coinciden. Validación fallida.");
                            }
                            break;
                        }
                    }
                }
                if (!encontrada) {
                    JOptionPane.showMessageDialog(vistaEscanerFoto, "No se encontró imagen en BD para la cédula: " + cedulaUsuario);
                }
                break;
            case "VOLVER_DASHBOARD":
                vistaEscanerFoto.setVisible(false);
                new DashboardController(obtenerCorreoPorCedula(cedulaUsuario));
                break;
    
            default:
                break;
        }
        
    }

    // Método auxiliar para obtener el correo por cédula
    private String obtenerCorreoPorCedula(String cedula) {
        try (java.util.Scanner scanner = new java.util.Scanner(new java.io.File("Data/dataUsuarios.txt"))) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] datos = linea.split(";");
                if (datos.length >= 5 && datos[3].equals(cedula)) {
                    return datos[0];
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    // Método para comparar dos imágenes por píxeles
    private boolean compararImagenesPorPixeles(File img1, File img2) {
        try {
            java.awt.image.BufferedImage bi1 = javax.imageio.ImageIO.read(img1);
            java.awt.image.BufferedImage bi2 = javax.imageio.ImageIO.read(img2);
            if (bi1.getWidth() != bi2.getWidth() || bi1.getHeight() != bi2.getHeight()) {
                return false;
            }
            for (int x = 0; x < bi1.getWidth(); x++) {
                for (int y = 0; y < bi1.getHeight(); y++) {
                    if (bi1.getRGB(x, y) != bi2.getRGB(x, y)) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Métodos auxiliares para saldo, ccb y reserva
    private double obtenerSaldoUsuario(String cedula) {
        try (java.util.Scanner scanner = new java.util.Scanner(new java.io.File("Data/dataUsuarios.txt"))) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] datos = linea.split(";");
                if (datos.length >= 5 && datos[3].equals(cedula)) {
                    return Double.parseDouble(datos[4]); // Suponiendo que el saldo está en la posición 4
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    private double obtenerCCBUsuario(String cedula) {
        try (java.util.Scanner scanner = new java.util.Scanner(new java.io.File("Data/dataCCB.txt"))) {
            String linea, ultimo = null;
            while (scanner.hasNextLine()) {
                linea = scanner.nextLine();
                if (!linea.trim().isEmpty()) {
                    ultimo = linea;
                }
            }
            if (ultimo != null) {
                String[] datos = ultimo.split(";");
                if (datos.length >= 6) {
                    return Double.parseDouble(datos[5]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    private boolean verificarReserva(String cedula) {
        try (java.util.Scanner scanner = new java.util.Scanner(new java.io.File("Data/dataReservas.txt"))) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] datos = linea.split(";");
                if (datos.length >= 2 && datos[0].equals(cedula)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
