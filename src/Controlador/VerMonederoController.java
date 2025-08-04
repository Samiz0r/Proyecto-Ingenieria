package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.VerMonedero;

public class VerMonederoController implements ActionListener{

    private VerMonedero vistaVerMonedero;
    private double saldo;
    private String correo;
    private Modelo.Usuarios usuarios;
    
    public VerMonederoController(String correoUsuario){
        this.correo = correoUsuario;
        usuarios = new Modelo.Usuarios();
        saldo = usuarios.getSaldoUsuario(correo);
        vistaVerMonedero = new VerMonedero();
        vistaVerMonedero.setCorreo(correo);
        vistaVerMonedero.setVisible(true);
        vistaVerMonedero.setControlador((ActionListener)this);
        // Leer el saldo actualizado del archivo cada vez que se abre la vista
        saldo = usuarios.getSaldoUsuario(correo);
        vistaVerMonedero.setSaldo(saldo);
    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "VOLVER":
                vistaVerMonedero.setVisible(false);
                new DashboardController(correo);
                break;

            case "RECARGAR":
                // Solicitar monto a recargar
                String montoStr = javax.swing.JOptionPane.showInputDialog(vistaVerMonedero, "Ingrese el monto a recargar:");
                if (montoStr != null && !montoStr.isEmpty()) {
                    try {
                        double monto = Double.parseDouble(montoStr);
                        if (monto > 0) {
                            saldo += monto;
                            String cedula = usuarios.getCedula(correo);
                            if (usuarios.actualizarSaldoPorCedula(cedula, saldo)) {
                                vistaVerMonedero.setSaldo(saldo);
                                javax.swing.JOptionPane.showMessageDialog(vistaVerMonedero, "Saldo actualizado");
                            } else {
                                javax.swing.JOptionPane.showMessageDialog(vistaVerMonedero, "Error al actualizar saldo en la base de datos.");
                            }
                        } else {
                            javax.swing.JOptionPane.showMessageDialog(vistaVerMonedero, "El monto debe ser mayor a cero.");
                        }
                    } catch (NumberFormatException ex) {
                        javax.swing.JOptionPane.showMessageDialog(vistaVerMonedero, "Monto inválido.");
                    }
                }
                break;
            default:
                break;
        }
    }
    
}
