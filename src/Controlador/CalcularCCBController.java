package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.CalcularCCB;

public class CalcularCCBController implements ActionListener {

    private CalcularCCB vistaCalcularCCB;
    private String correoAdmin;

    public CalcularCCBController(String correoAdmin) {
        this.correoAdmin = correoAdmin;
        vistaCalcularCCB = new CalcularCCB();
        vistaCalcularCCB.setVisible(true);
        vistaCalcularCCB.setControlador((ActionListener)this);
        
        // Leer el último CCB guardado y mostrarlo
        String ultimaLinea = null;
        try {
            java.io.File file = new java.io.File("Data/dataCCB.txt");
            if (file.exists()) {
                java.util.Scanner scanner = new java.util.Scanner(file);
                while (scanner.hasNextLine()) {
                    ultimaLinea = scanner.nextLine();
                }
                scanner.close();
                if (ultimaLinea != null) {
                    String[] datos = ultimaLinea.split(";");
                    if (datos.length >= 6) {
                        try {
                            double ultimoCCB = Double.parseDouble(datos[5]);
                            String ultimaFecha = datos[0];
                            vistaCalcularCCB.actualizarCCBEnPantalla(ultimoCCB, ultimaFecha);
                        } catch (NumberFormatException ex) {
                            vistaCalcularCCB.actualizarCCBEnPantalla(0.0, "-");
                        }
                    } else {
                        vistaCalcularCCB.actualizarCCBEnPantalla(0.0, "-");
                    }
                } else {
                    vistaCalcularCCB.actualizarCCBEnPantalla(0.0, "-");
                }
            } else {
                vistaCalcularCCB.actualizarCCBEnPantalla(0.0, "-");
            }
        } catch (Exception ex) {
            vistaCalcularCCB.actualizarCCBEnPantalla(0.0, "-");
        }
    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "CALCULAR":
                String periodo = vistaCalcularCCB.getCajaPeriodo().getText();
                String cfStr = vistaCalcularCCB.getCajaCostosFijos().getText();
                String cvStr = vistaCalcularCCB.getCajaCostosVariados().getText();
                String nbStr = vistaCalcularCCB.getCajaNBandejas().getText();
                String mermaStr = vistaCalcularCCB.getCajaMerma().getText();
                try {
                    double cf = Double.parseDouble(cfStr);
                    double cv = Double.parseDouble(cvStr);
                    int nb = Integer.parseInt(nbStr);
                    double merma = Double.parseDouble(mermaStr) / 100.0; // convertir a decimal
                    double ccb = vistaCalcularCCB.calcularCCB(cf, cv, nb, merma);
                    Modelo.Administradores admin = new Modelo.Administradores();
                    if (admin.guardarCCB(periodo, cf, cv, nb, merma, ccb)) {
                        vistaCalcularCCB.actualizarCCBEnPantalla(ccb, periodo);
                        vistaCalcularCCB.limpiarCampos();
                        javax.swing.JOptionPane.showMessageDialog(vistaCalcularCCB, "CCB calculado y guardado correctamente");
                    } else {
                        javax.swing.JOptionPane.showMessageDialog(vistaCalcularCCB, "Error al guardar el CCB.");
                    }
                } catch (Exception ex) {
                    javax.swing.JOptionPane.showMessageDialog(vistaCalcularCCB, "Datos inválidos. Verifique los campos.");
                }
                break;

            case "VOLVER":
                vistaCalcularCCB.setVisible(false);
                new DashboardAdminController(correoAdmin);
                break;
            default:
                break;
        }
    }
    
}
