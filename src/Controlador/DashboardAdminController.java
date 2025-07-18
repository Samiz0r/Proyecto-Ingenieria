package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.DashboardAdmin;

public class DashboardAdminController implements ActionListener {
    
    private DashboardAdmin vistaDashboardAdmin;

    public DashboardAdminController() {
        
        vistaDashboardAdmin = new DashboardAdmin();
        vistaDashboardAdmin.setVisible(true);
        vistaDashboardAdmin.setControlador((ActionListener)this);   
    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "CALCULAR_CCB":
                vistaDashboardAdmin.setVisible(false);
                new CalcularCCBController();
                break;

            case "GESTIONAR_INSUMOS":
                vistaDashboardAdmin.setVisible(false);
                //new GestionarInsumosController();
                break;

            case "GESTIONAR_MENU":
                vistaDashboardAdmin.setVisible(false);
                //new GestionarMenuController();
                break;

            case "ESTABLECER_TURNOS":
                vistaDashboardAdmin.setVisible(false);
                //new EstablecerTurnosController();
                break;

            case "CALCULAR_CONSUMO":
                vistaDashboardAdmin.setVisible(false);
                //new CalcularConsumoController();
                break;

            case "GENERAR_REPORTE":
                vistaDashboardAdmin.setVisible(false);
                //new GenerarReporteController();
                break;

            case "INGRESO_TARIFA":
                vistaDashboardAdmin.setVisible(false);
                //new IngresoTarifaController();
                break;

            default:
                break;
        }
    }

}
