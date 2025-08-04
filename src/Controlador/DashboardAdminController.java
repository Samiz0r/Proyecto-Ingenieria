package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.DashboardAdmin;

public class DashboardAdminController implements ActionListener {
    
    private DashboardAdmin vistaDashboardAdmin;
    private String correoAdmin;
    private String nombreAdmin;

    public DashboardAdminController(String correoAdmin) {
        this.correoAdmin = correoAdmin;
        Modelo.Administradores administradores = new Modelo.Administradores();
        this.nombreAdmin = administradores.getNombreCompleto(correoAdmin);
        vistaDashboardAdmin = new DashboardAdmin();
        vistaDashboardAdmin.setNombreAdmin(nombreAdmin);
        vistaDashboardAdmin.setVisible(true);
        vistaDashboardAdmin.setControlador((ActionListener)this);   
    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "CALCULAR_CCB":
                vistaDashboardAdmin.setVisible(false);
                new CalcularCCBController(correoAdmin);
                break;

            case "GESTIONAR_INSUMOS":
                vistaDashboardAdmin.setVisible(false);
                //new GestionarInsumosController();
                break;

            case "GESTIONAR_MENU":
                vistaDashboardAdmin.setVisible(false);
                new GestionarMenuController(correoAdmin);
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

            case "CERRAR_SESION":
                vistaDashboardAdmin.setVisible(false);
                new ControladorPrincipal();
                break;

            default:
                break;
        }
    }

}
