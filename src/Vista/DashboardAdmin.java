package Vista;

import java.awt.event.ActionListener;

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
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        // Pie de página
        JLabel piePagina = new JLabel("2025 UCV");
        piePagina.setBounds(0, 530, 500, 30); // centrado en la parte inferior
        piePagina.setHorizontalAlignment(SwingConstants.CENTER);
        piePagina.setForeground(Color.GRAY);
        piePagina.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(piePagina);
        
        agregarSubtitulo();
        int y = 130; // posición inicial debajo del subtítulo
        int altura = 40; // altura de cada botón
        int espacio = 15; // espacio entre botones

        agregarBotonGestionarInsumos(y); y += altura + espacio;
        agregarBotonGestionarMenu(y); y += altura + espacio;
        agregarBotonEstablecerTurnos(y); y += altura + espacio;
        agregarBotonCalcularConsumo(y); y += altura + espacio;
        agregarBotonGenerarReporte(y); y += altura + espacio;
        agregarBotonCalcularCCB(y); y += altura + espacio;
        agregarBotonIngresoTarifa(y);
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

    private void agregarBotonCalcularCCB(int y){
        botonCalcularCCB = new JButton("Calcular CCB");
        botonCalcularCCB.setBounds(75, y, 350, 40);
        botonCalcularCCB.setActionCommand("CALCULAR_CCB");
        botonCalcularCCB.setBackground(Color.BLACK);
        botonCalcularCCB.setForeground(Color.WHITE);
        panel.add(botonCalcularCCB);
    }

    private void agregarBotonGestionarInsumos(int y){
        botonGestionarInsumos = new JButton("Gestionar Insumos");
        botonGestionarInsumos.setBounds(75, y, 350, 40);
        botonGestionarInsumos.setActionCommand("GESTIONAR_INSUMOS");
        botonGestionarInsumos.setBackground(Color.BLACK);
        botonGestionarInsumos.setForeground(Color.WHITE);
        panel.add(botonGestionarInsumos);
    }

    private void agregarBotonGestionarMenu(int y){
        botonGestionarMenu = new JButton("Gestionar Menú");
        botonGestionarMenu.setBounds(75, y, 350, 40);
        botonGestionarMenu.setActionCommand("GESTIONAR_MENU");
        botonGestionarMenu.setBackground(Color.BLACK);
        botonGestionarMenu.setForeground(Color.WHITE);
        panel.add(botonGestionarMenu);
    }

    private void agregarBotonEstablecerTurnos(int y){
        botonEstablecerTurnos = new JButton("Establecer Turnos");
        botonEstablecerTurnos.setBounds(75, y, 350, 40);
        botonEstablecerTurnos.setActionCommand("ESTABLECER_TURNOS");
        botonEstablecerTurnos.setBackground(Color.BLACK);
        botonEstablecerTurnos.setForeground(Color.WHITE);
        panel.add(botonEstablecerTurnos);
    }

    private void agregarBotonCalcularConsumo(int y){
        botonCalcularConsumo = new JButton("Calcular Consumo");
        botonCalcularConsumo.setBounds(75, y, 350, 40);
        botonCalcularConsumo.setActionCommand("CALCULAR_CONSUMO");
        botonCalcularConsumo.setBackground(Color.BLACK);
        botonCalcularConsumo.setForeground(Color.WHITE);
        panel.add(botonCalcularConsumo);
    }

    private void agregarBotonGenerarReporte(int y){
        botonGenerarReporte = new JButton("Generar Reporte");
        botonGenerarReporte.setBounds(75, y, 350, 40);
        botonGenerarReporte.setActionCommand("GENERAR_REPORTE");
        botonGenerarReporte.setBackground(Color.BLACK);
        botonGenerarReporte.setForeground(Color.WHITE);
        panel.add(botonGenerarReporte);
    }

    private void agregarBotonIngresoTarifa(int y) {
        botonIngresoTarifa = new JButton("Ingreso de Tarifa");
        botonIngresoTarifa.setBounds(75, y, 350, 40);
        botonIngresoTarifa.setBackground(Color.BLACK);
        botonIngresoTarifa.setForeground(Color.WHITE);
        panel.add(botonIngresoTarifa);
    }

    public void setControlador(ActionListener controlador) {
        // Set the controller for the buttons
        botonCalcularCCB.addActionListener(controlador);
        botonGestionarInsumos.addActionListener(controlador);
        botonGestionarMenu.addActionListener(controlador);
        botonEstablecerTurnos.addActionListener(controlador);
        botonCalcularConsumo.addActionListener(controlador);
        botonGenerarReporte.addActionListener(controlador);
        botonIngresoTarifa.addActionListener(controlador);
    }
    
}
