package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.GestionarMenu;
import Modelo.Administradores;

public class GestionarMenuController implements ActionListener {
    private GestionarMenu vistaGestionarMenu;
    private String correoAdmin;

    public GestionarMenuController(String correoAdmin) {
        this.correoAdmin = correoAdmin;
        vistaGestionarMenu = new GestionarMenu();
        vistaGestionarMenu.setVisible(true);
        vistaGestionarMenu.setControlador(this);
    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        switch (comando) {
            case "GUARDAR_MENU":
                String nombreDesayuno = vistaGestionarMenu.getNombreDesayuno();
                String descripcionDesayuno = vistaGestionarMenu.getDescripcionDesayuno();
                String nombreAlmuerzo = vistaGestionarMenu.getNombreAlmuerzo();
                String descripcionAlmuerzo = vistaGestionarMenu.getDescripcionAlmuerzo();
                Administradores admin = new Administradores();
                if (admin.guardarMenus(nombreDesayuno, descripcionDesayuno, nombreAlmuerzo, descripcionAlmuerzo)) {
                    vistaGestionarMenu.limpiarCampos();
                    javax.swing.JOptionPane.showMessageDialog(vistaGestionarMenu, "Menús guardados correctamente.");
                } else {
                    javax.swing.JOptionPane.showMessageDialog(vistaGestionarMenu, "Error al guardar los menús.");
                }
                break;
            case "VOLVER_MENU":
                vistaGestionarMenu.setVisible(false);
                new DashboardAdminController(correoAdmin);
                break;
            default:
                break;
        }
    }
}
