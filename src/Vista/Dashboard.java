package Vista;

import java.awt.event.ActionListener;

import java.awt.*;
import javax.swing.*;


public class Dashboard extends JFrame {

    JPanel panel;
    JButton botonVerMonedero;
    JButton botonConsultarMenu;
    JButton botonrRealizarReserva;
    JButton botonCancelarReservas;
    JButton botonSeleccionarTurnoComida;
    JButton botonRegistroConsumo;

    public Dashboard() {
        setTitle("Menú Comensal");
        setSize(500, 600);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        agregarPanel();
    }

    private void agregarPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        
        //Titulo
        JLabel titulo = new JLabel();
        titulo.setText("¡Bienvenidos!"); // texto que se muestra en la etiqueta");
        titulo.setBounds(0,40,500,20); // centrado horizontalmente
        titulo.setHorizontalAlignment(SwingConstants.CENTER); // establecer en el centro de la etiqueta el texto
        titulo.setForeground(Color.BLACK); // color de la letra
        titulo.setFont(new Font("Arial", Font.BOLD, 20)); // cambia el tamaño y tipo de fuente
        panel.add(titulo);

        //Subtitulo

        JLabel subTitulo = new JLabel();
        subTitulo.setText("Seleccione la opción de su preferencia");
        subTitulo.setBounds(0,95,500,20); // centrado horizontalmente
        subTitulo.setHorizontalAlignment(SwingConstants.CENTER); // establecer en el centro de la etiqueta el texto
        subTitulo.setForeground(Color.BLACK); // color de la letra
        subTitulo.setFont(new Font("Arial", Font.BOLD, 17)); // cambia el tamaño y tipo de fuente
        panel.add(subTitulo);

        // Agregar botones
        agregarBotonVerMonedero();
        agregarBotonConsultarMenu();
        agregarBotonRealizarReserva();
        agregarBotonCancelarReservas();
        agregarBotonSeleccionarTurnoComida();
        agregarBotonRegistroConsumo();        
    }

   

    private void agregarBotonVerMonedero(){
        botonVerMonedero = new JButton("Ver Monedero");
        botonVerMonedero.setBounds(75,150,350,30); // mismo ancho que las cajas de texto
        botonVerMonedero.setActionCommand("VER_MONEDERO");
        botonVerMonedero.setBackground(Color.BLACK);
        botonVerMonedero.setForeground(Color.WHITE); // fondo
        panel.add(botonVerMonedero);
    }

    private void agregarBotonConsultarMenu(){
        botonConsultarMenu = new JButton("Consultar Menú");
        botonConsultarMenu.setBounds(75,210,350,30); // mismo ancho que las cajas de texto
        botonConsultarMenu.setActionCommand("CONSULTAR_MENU");
        botonConsultarMenu.setBackground(Color.BLACK); // fondo negro
        botonConsultarMenu.setForeground(Color.WHITE); // letras blancas
        panel.add(botonConsultarMenu);
    }

    private void agregarBotonRealizarReserva(){
        botonrRealizarReserva = new JButton("Realizar Reserva");
        botonrRealizarReserva.setBounds(75,270,350,30); // mismo ancho que las cajas de texto
        botonrRealizarReserva.setActionCommand("REALIZAR_RESERVA");
        botonrRealizarReserva.setBackground(Color.BLACK);
        botonrRealizarReserva.setForeground(Color.WHITE); // letras blancas
        panel.add(botonrRealizarReserva);
    }

    private void agregarBotonCancelarReservas(){
        botonCancelarReservas = new JButton("Cancelar Reservas");
        botonCancelarReservas.setBounds(75,330,350,30); // mismo ancho que las cajas de texto
        botonCancelarReservas.setActionCommand("CANCELAR_RESERVAS");
        botonCancelarReservas.setBackground(Color.BLACK);
        botonCancelarReservas.setForeground(Color.WHITE); // letras blancas
        panel.add(botonCancelarReservas);
    }

    private void agregarBotonSeleccionarTurnoComida(){
        botonSeleccionarTurnoComida = new JButton("Seleccionar Turno de Comida");
        botonSeleccionarTurnoComida.setBounds(75,390,350,30); // mismo ancho que las cajas de texto
        botonSeleccionarTurnoComida.setActionCommand("SELECCIONAR_TURNO_COMIDA");
        botonSeleccionarTurnoComida.setBackground(Color.BLACK);
        botonSeleccionarTurnoComida.setForeground(Color.WHITE); // letras blancas
        panel.add(botonSeleccionarTurnoComida);
    }

    private void agregarBotonRegistroConsumo(){
        botonRegistroConsumo = new JButton("Registro de Consumo");
        botonRegistroConsumo.setBounds(75,450,350,30); // mismo ancho que las cajas de texto
        botonRegistroConsumo.setActionCommand("REGISTRO_CONSUMO");
        botonRegistroConsumo.setBackground(Color.BLACK);
        botonRegistroConsumo.setForeground(Color.WHITE); // letras blancas
        panel.add(botonRegistroConsumo);
    }

    public void setControlador(ActionListener controlador) {
        // Set the controller for the buttons
        botonVerMonedero.addActionListener(controlador);
        botonConsultarMenu.addActionListener(controlador);
        botonrRealizarReserva.addActionListener(controlador);
        botonCancelarReservas.addActionListener(controlador);
        botonSeleccionarTurnoComida.addActionListener(controlador);
        botonRegistroConsumo.addActionListener(controlador);
    }
    
}
