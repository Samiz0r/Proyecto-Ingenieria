package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.CalcularCCB;

public class CalcularCCBController implements ActionListener {

    private CalcularCCB vistaCalcularCCB;

    public CalcularCCBController() {

        vistaCalcularCCB = new CalcularCCB();
        vistaCalcularCCB.setVisible(true);
        vistaCalcularCCB.setControlador((ActionListener)this);

    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "CALCULAR":
                 vistaCalcularCCB.setVisible(false);
                // Aquí se implementaría la lógica para calcular el CCB
                break;

            case "VOLVER":
                vistaCalcularCCB.setVisible(false);
                new DashboardAdminController();
                break;
            default:
                break;
        }
    }
    
}
