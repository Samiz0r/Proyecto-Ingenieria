package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.ConsultarMenu;

public class ConsultarMenuController implements ActionListener {
    private ConsultarMenu vistaConsultarMenu;
    private String correoUsuario;

    public ConsultarMenuController(String correoUsuario) {
        this.correoUsuario = correoUsuario;
        vistaConsultarMenu = new ConsultarMenu();
        vistaConsultarMenu.setVisible(true);
        vistaConsultarMenu.setControlador(this);
    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        switch (comando) {
            case "VOLVER_MENU":
                vistaConsultarMenu.setVisible(false);
                new DashboardController(correoUsuario);
                break;
            case "SELECCIONAR_TURNO_COMIDA":
                vistaConsultarMenu.setVisible(false);
                new SeleccionarTurnoComidaController(correoUsuario);
                break;
            default:
                break;
        }
    }
}
