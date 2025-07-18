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
            case "CONTINUAR":
                
                vistaInicioSesion.setVisible(false);
                new DashboardController();
                break;

            case "REGISTRARSE":

                vistaInicioSesion.setVisible(false);
                new RegistrarseController();
                break;

            default:
                break;
        }
    }

    
}
