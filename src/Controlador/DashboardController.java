package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.Dashboard;

public class DashboardController implements ActionListener {
    
    private Dashboard vistaDashboard;
    private String correoUsuario;
    private String nombreUsuario;

    public DashboardController(String correoUsuario) {
        this.correoUsuario = correoUsuario;
        Modelo.Usuarios usuarios = new Modelo.Usuarios();
        this.nombreUsuario = usuarios.getNombreCompleto(correoUsuario);
        vistaDashboard = new Dashboard();
        vistaDashboard.setNombreUsuario(nombreUsuario);
        vistaDashboard.setVisible(true);
        vistaDashboard.setControlador((ActionListener)this);   
    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "ESCANER":
                vistaDashboard.setVisible(false);
                Modelo.Usuarios usuarios = new Modelo.Usuarios();
                String cedula = usuarios.getCedula(correoUsuario);
                new EscanerFotoController(cedula);
                break;
            case "VER_MONEDERO":
                vistaDashboard.setVisible(false);
                new VerMonederoController(correoUsuario);
                break;

            case "CONSULTAR_MENU":
                vistaDashboard.setVisible(false);
                new ConsultarMenuController(correoUsuario);
                break;
            
            
            case "CANCELAR_RESERVAS":
                vistaDashboard.setVisible(false);
                //new CancelarReservasController();
                break;

            case "SELECCIONAR_TURNO_COMIDA":
                vistaDashboard.setVisible(false);
                new SeleccionarTurnoComidaController(correoUsuario);
                break;

            case "CERRAR_SESION":
                vistaDashboard.setVisible(false);
                new ControladorPrincipal();
                break;

            default:
                break;
        }
    }



}
