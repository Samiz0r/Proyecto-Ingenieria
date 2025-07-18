package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.VerMonedero;

public class VerMonederoController implements ActionListener{

    private VerMonedero vistaVerMonedero;
    
    public VerMonederoController(){

        vistaVerMonedero = new VerMonedero();
        vistaVerMonedero.setVisible(true);
        vistaVerMonedero.setControlador((ActionListener)this);

    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "VOLVER":
                vistaVerMonedero.setVisible(false);
                new DashboardController();
                break;

            case "RECARGAR":
                vistaVerMonedero.setVisible(false);
                //new ControladorPrincipal();
                break;
            default:
                break;
        }
    }
    
}
