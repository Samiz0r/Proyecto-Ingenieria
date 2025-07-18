package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.Registrarse;

public class RegistrarseController implements ActionListener {

    private Registrarse vistaRegistrarse;

    public RegistrarseController (){

        vistaRegistrarse = new Registrarse();
        vistaRegistrarse.setVisible(true);
        vistaRegistrarse.setControlador((ActionListener)this);
    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "CONTINUAR":
                vistaRegistrarse.setVisible(false);
                new ControladorPrincipal();
                break;

            case "CONTINUAR_ADMIN":
                vistaRegistrarse.setVisible(false);
                new ControladorPrincipal();
                break;
            
            case "INICIO_SESION":
                vistaRegistrarse.setVisible(false);
                new ControladorPrincipal();
                break;
            default:
                break;
        }
    }
    
}
