package Vista;

import java.awt.*;
import javax.swing.*;


public class DashboardAdmin extends JFrame {

    JPanel panel;
    JButton botonCalcularCCB;
    JButton botonGestionarInsumos; 
    JButton botonGestionarMenu;
    JButton botonEstablecerTurnos;
    JButton botonCalcularConsumo;
    JButton botonGenerarReporte;
    JButton botonIngresoTarifa;

    public DashboardAdmin() {
        setTitle("Menú de Administrador");
        setSize(500, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        agregarPanel();
    }

    private void agregarPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        
        // Título
        
        JLabel titulo = new JLabel("¡Bienvenido Administrador!");
        titulo.setBounds(0, 40, 500, 20);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(titulo);
        
        agregarSubtitulo();
        agregarBotonCalcularCCB();
        agregarBotonGestionarInsumos();
        agregarBotonGestionarMenu();
        agregarBotonEstablecerTurnos();
        agregarBotonCalcularConsumo();
        agregarBotonGenerarReporte();
        agregarBotonIngresoTarifa();
    }
    
    private void agregarSubtitulo(){
        JLabel subTitulo = new JLabel();
        subTitulo.setText("Seleccione la opción de su preferencia");
        subTitulo.setBounds(0,95,500,20); // centrado horizontalmente
        subTitulo.setHorizontalAlignment(SwingConstants.CENTER); // establecer en el centro de la etiqueta el texto
        subTitulo.setForeground(Color.BLACK); // color de la letra
        subTitulo.setFont(new Font("Arial", Font.BOLD, 17)); // cambia el tamaño y tipo de fuente
        panel.add(subTitulo);
    }

    private void agregarBotonCalcularCCB(){
        botonCalcularCCB = new JButton("Calcular CCB");
        botonCalcularCCB.setBounds(75,450,350,30); // mismo ancho que las cajas de texto
        botonCalcularCCB.setActionCommand("CALCULAR_CCB");
        botonCalcularCCB.setBackground(Color.BLACK);
        botonCalcularCCB.setForeground(Color.WHITE); // fondo
        panel.add(botonCalcularCCB);
    }

    private void agregarBotonGestionarInsumos(){
        botonGestionarInsumos = new JButton("Gestionar Insumos");
        botonGestionarInsumos.setBounds(75,150,350,30); // mismo ancho que las cajas de texto
        botonGestionarInsumos.setActionCommand("GESTIONAR_INSUMOS");
        botonGestionarInsumos.setBackground(Color.BLACK);
        botonGestionarInsumos.setForeground(Color.WHITE); // fondo
        panel.add(botonGestionarInsumos);
    }

    private void agregarBotonGestionarMenu(){
        botonGestionarMenu = new JButton("Gestionar Menú");
        botonGestionarMenu.setBounds(75,210,350,30); // mismo ancho que las cajas de texto
        botonGestionarMenu.setActionCommand("GESTIONAR_MENU");
        botonGestionarMenu.setBackground(Color.BLACK);
        botonGestionarMenu.setForeground(Color.WHITE); // fondo
        panel.add(botonGestionarMenu);
    }

    private void agregarBotonEstablecerTurnos(){
        botonEstablecerTurnos = new JButton("Establecer Turnos");
        botonEstablecerTurnos.setBounds(75,270,350,30); // mismo ancho que las cajas de texto
        botonEstablecerTurnos.setActionCommand("ESTABLECER_TURNOS");
        botonEstablecerTurnos.setBackground(Color.BLACK);
        botonEstablecerTurnos.setForeground(Color.WHITE); // fondo
        panel.add(botonEstablecerTurnos);
    }

    private void agregarBotonCalcularConsumo(){
        botonCalcularConsumo = new JButton("Calcular Consumo");
        botonCalcularConsumo.setBounds(75,330,350,30); // mismo ancho que las cajas de texto
        botonCalcularConsumo.setActionCommand("CALCULAR_CONSUMO");
        botonCalcularConsumo.setBackground(Color.BLACK);
        botonCalcularConsumo.setForeground(Color.WHITE); // fondo
        panel.add(botonCalcularConsumo);
    }

    private void agregarBotonGenerarReporte(){
        botonGenerarReporte = new JButton("Generar Reporte");
        botonGenerarReporte.setBounds(75,390,350,30); // mismo ancho que las cajas de texto
        botonGenerarReporte.setActionCommand("GENERAR_REPORTE");
        botonGenerarReporte.setBackground(Color.BLACK);
        botonGenerarReporte.setForeground(Color.WHITE); // fondo
        panel.add(botonGenerarReporte);
    }

    private void agregarBotonIngresoTarifa() {
        botonIngresoTarifa = new JButton("Ingreso de Tarifa");
        botonIngresoTarifa.setBounds(75, 510, 350, 30);
        botonIngresoTarifa.addActionListener(e -> dispose());
        botonIngresoTarifa.setBackground(Color.BLACK);
        botonIngresoTarifa.setForeground(Color.WHITE); // letras blancas
        panel.add(botonIngresoTarifa);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DashboardAdmin dashboardAdmin = new DashboardAdmin();
            dashboardAdmin.setVisible(true);
        });
    }
}
