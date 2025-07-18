package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Vista.Registrarse;
import Modelo.Usuarios;

public class RegistrarseController implements ActionListener {

    private Registrarse vistaRegistrarse;
    private Usuarios usuarios;

    public RegistrarseController (){

        vistaRegistrarse = new Registrarse();
        vistaRegistrarse.setVisible(true);
        vistaRegistrarse.setControlador((ActionListener)this);

        usuarios = new Usuarios();
    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "CONTINUAR": {
                String correo = vistaRegistrarse.getCorreo();
                String contrasena = vistaRegistrarse.getContrasena();
                String nombre = vistaRegistrarse.getNombreCompleto();
                String cedula = vistaRegistrarse.getCedula();
                if (
                    correo.isEmpty() || correo.equals(" Correo electrónico") ||
                    contrasena.isEmpty() || contrasena.equals(" Contraseña") ||
                    nombre.isEmpty() || nombre.equals(" Nombre Completo") ||
                    cedula.isEmpty() || cedula.equals(" Cedula")
                ) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                vistaRegistrarse.setVisible(false);
                if(
                    usuarios.agregarUsuario(
                        correo,
                        contrasena,
                        nombre,
                        Integer.parseInt(cedula)
                    )
                ){
                    JOptionPane.showMessageDialog(null, "Usuario registrado con éxito ", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Error al registrar el Usuario", "Error", JOptionPane.ERROR_MESSAGE);
                }
                new ControladorPrincipal();
                break;
            }
            case "CONTINUAR_ADMIN": {
                String correo = vistaRegistrarse.getCorreo();
                String contrasena = vistaRegistrarse.getContrasena();
                String nombre = vistaRegistrarse.getNombreCompleto();
                String cedula = vistaRegistrarse.getCedula();
                if (
                    correo.isEmpty() || correo.equals(" Correo electrónico") ||
                    contrasena.isEmpty() || contrasena.equals(" Contraseña") ||
                    nombre.isEmpty() || nombre.equals(" Nombre Completo") ||
                    cedula.isEmpty() || cedula.equals(" Cedula")
                ) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                vistaRegistrarse.setVisible(false);
                Modelo.Administradores administradores = new Modelo.Administradores();
                if(
                    administradores.agregarAdministrador(
                        correo,
                        contrasena,
                        nombre,
                        Integer.parseInt(cedula)
                    )
                ){
                    JOptionPane.showMessageDialog(null, "Administrador registrado con éxito ", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Error al registrar el Administrador", "Error", JOptionPane.ERROR_MESSAGE);
                }
                new ControladorPrincipal();
                break;
            }
            
            case "INICIO_SESION":
                vistaRegistrarse.setVisible(false);
                new ControladorPrincipal();
                break;
            default:
                break;
        }
    }
    
}
