package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import Vista.InicioSesion;

public class ControladorPrincipal implements ActionListener {
    
    private InicioSesion vistaInicioSesion;

    public ControladorPrincipal() {
            vistaInicioSesion = new InicioSesion();
            vistaInicioSesion.setVisible(true);
            vistaInicioSesion.setControlador((ActionListener)this);
    } 

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "CONTINUAR": {
                String correo = vistaInicioSesion.getCorreo();
                String contrasena = vistaInicioSesion.getContrasena();
                Modelo.Usuarios usuarios = new Modelo.Usuarios();
                if (usuarios.autenticarUsuario(correo, contrasena)) {
                    vistaInicioSesion.setVisible(false);
                    new DashboardController();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, "Correo o contraseña incorrectos", "Error de inicio de sesión", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
                break;
            }
            case "CONTINUAR_ADMIN": {
                String correoAdmin = vistaInicioSesion.getCorreoAdmin();
                String contrasenaAdmin = vistaInicioSesion.getContrasenaAdmin();
                Modelo.Administradores administradores = new Modelo.Administradores();
                if (administradores.autenticarAdministrador(correoAdmin, contrasenaAdmin)) {
                    vistaInicioSesion.setVisible(false);
                    new DashboardAdminController();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, "Correo o contraseña de administrador incorrectos", "Error de inicio de sesión", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
                break;
            }
            case "REGISTRARSE":
                vistaInicioSesion.setVisible(false);
                new RegistrarseController();
                break;
            default:
                break;
        }
    }

    
}
