package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.SeleccionarTurnoComida;

public class SeleccionarTurnoComidaController implements ActionListener {
    private SeleccionarTurnoComida vistaSeleccionarTurno;
    private String correoUsuario;

    public SeleccionarTurnoComidaController(String correoUsuario) {
        this.correoUsuario = correoUsuario;
        vistaSeleccionarTurno = new SeleccionarTurnoComida();
        vistaSeleccionarTurno.setVisible(true);
        vistaSeleccionarTurno.setControlador(this);
    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        switch (comando) {
            case "REALIZAR_RESERVA":
                String turno = vistaSeleccionarTurno.getTurnoSeleccionado();
                String cedula = obtenerCedulaPorCorreo(correoUsuario);
                guardarReserva(cedula, turno);
                javax.swing.JOptionPane.showMessageDialog(vistaSeleccionarTurno, "Reserva realizada para el turno: " + turno);
                break;
            case "VOLVER_CONSULTA_MENU":
                vistaSeleccionarTurno.setVisible(false);
                new DashboardController(correoUsuario);
                break;
            default:
                break;
        }
    }

    // Método para obtener la cédula por correo
    private String obtenerCedulaPorCorreo(String correo) {
        try (java.util.Scanner scanner = new java.util.Scanner(new java.io.File("Data/dataUsuarios.txt"))) {
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

    // Método para guardar la reserva en dataReservas.txt
    private void guardarReserva(String cedula, String turno) {
        try (java.io.FileWriter writer = new java.io.FileWriter("Data/dataReservas.txt", true)) {
            writer.write(cedula + ";" + turno + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
