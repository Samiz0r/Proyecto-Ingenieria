package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.Dashboard;

public class DashboardController implements ActionListener {
    
    private Dashboard vistaDashboard;

    public DashboardController() {
        
        vistaDashboard = new Dashboard();
        vistaDashboard.setVisible(true);
        vistaDashboard.setControlador((ActionListener)this);   
    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "VER_MONEDERO":
                vistaDashboard.setVisible(false);
                new VerMonederoController();
                break;

            case "CONSULTAR_MENU":
                vistaDashboard.setVisible(false);
                //new RegistrarseController();
                break;
            
            case "REALIZAR_RESERVA":
                vistaDashboard.setVisible(false); 
                //new ReservarController();
                break;
            
            case "CANCELAR_RESERVAS":
                vistaDashboard.setVisible(false);
                //new CancelarReservasController();
                break;

            case "SELECCIONAR_TURNO_COMIDA":
                vistaDashboard.setVisible(false);
                //new SeleccionarTurnoController();
                break;

            case "REGISTRO_CONSUMO":
                vistaDashboard.setVisible(false);
                //new RegistroConsumoController();
                break;

            default:
                break;
        }
    }



}
