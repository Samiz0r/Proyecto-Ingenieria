package Vista;

import java.awt.event.ActionListener;

import java.awt.*;
import javax.swing.*;

public class Dashboard extends JFrame {    

    JPanel panel;
    JButton botonVerMonedero;
    JButton botonConsultarMenu;
    JButton botonCancelarReservas;
    JButton botonSeleccionarTurnoComida;
    JButton botonCerrarSesion;
    JButton botonEscaner;
    private String nombreUsuario;

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
        titulo.setText("¡Bienvenido!"); // texto que se muestra en la etiqueta");
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

        // Pie de página
        JLabel piePagina = new JLabel("2025 UCV");
        piePagina.setBounds(0, 530, 500, 30); // centrado en la parte inferior
        piePagina.setHorizontalAlignment(SwingConstants.CENTER);
        piePagina.setForeground(Color.GRAY);
        piePagina.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(piePagina);

        // Agregar botones
        agregarBotonVerMonedero();
        agregarBotonConsultarMenu();
        agregarBotonCancelarReservas();
        agregarBotonSeleccionarTurnoComida(); 
        agregarBotonCerrarSesion();
        agregarBotonEscaner();
    }

    private void agregarBotonVerMonedero(){
        botonVerMonedero = new JButton("Ver Monedero");
        botonVerMonedero.setBounds(75,150,350,30); // Primer botón
        botonVerMonedero.setActionCommand("VER_MONEDERO");
        botonVerMonedero.setBackground(Color.BLACK);
        botonVerMonedero.setForeground(Color.WHITE);
        panel.add(botonVerMonedero);
    }

    private void agregarBotonConsultarMenu(){
        botonConsultarMenu = new JButton("Consultar Menú");
        botonConsultarMenu.setBounds(75,230,350,30); // +80px de separación
        botonConsultarMenu.setActionCommand("CONSULTAR_MENU");
        botonConsultarMenu.setBackground(Color.BLACK);
        botonConsultarMenu.setForeground(Color.WHITE);
        panel.add(botonConsultarMenu);
    }

    private void agregarBotonCancelarReservas(){
        botonCancelarReservas = new JButton("Cancelar Reservas");
        botonCancelarReservas.setBounds(75,310,350,30); // +80px de separación
        botonCancelarReservas.setActionCommand("CANCELAR_RESERVAS");
        botonCancelarReservas.setBackground(Color.BLACK);
        botonCancelarReservas.setForeground(Color.WHITE);
        panel.add(botonCancelarReservas);
    }

    private void agregarBotonSeleccionarTurnoComida(){
        botonSeleccionarTurnoComida = new JButton("Seleccionar Turno de Comida");
        botonSeleccionarTurnoComida.setBounds(75,390,350,30); // +80px de separación
        botonSeleccionarTurnoComida.setActionCommand("SELECCIONAR_TURNO_COMIDA");
        botonSeleccionarTurnoComida.setBackground(Color.BLACK);
        botonSeleccionarTurnoComida.setForeground(Color.WHITE);
        panel.add(botonSeleccionarTurnoComida);
    }

    private void agregarBotonCerrarSesion(){
        ImageIcon iconoOriginal = new ImageIcon("recursos/salir.png");
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
        ImageIcon iconoSalir = new ImageIcon(imagenEscalada);
        botonCerrarSesion = new JButton(iconoSalir);
        botonCerrarSesion.setBounds(445, 10, 26, 26); 
        botonCerrarSesion.setActionCommand("CERRAR_SESION");
        botonCerrarSesion.setBackground(Color.BLACK);
        botonCerrarSesion.setBorderPainted(false);
        botonCerrarSesion.setFocusPainted(false);
        botonCerrarSesion.setContentAreaFilled(false);
        panel.add(botonCerrarSesion);
    }

    private void agregarBotonEscaner() {
        // Botón Escaner con imagen en la esquina superior izquierda
        ImageIcon iconoEscanerOriginal = new ImageIcon("recursos/escaner.png");
        Image imagenEscaladaEscaner = iconoEscanerOriginal.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        ImageIcon iconoEscaner = new ImageIcon(imagenEscaladaEscaner);
        botonEscaner = new JButton(iconoEscaner);
        botonEscaner.setBounds(10, 10, 32, 32);
        botonEscaner.setActionCommand("ESCANER");
        botonEscaner.setBackground(Color.BLACK);
        botonEscaner.setBorderPainted(false);
        botonEscaner.setFocusPainted(false);
        botonEscaner.setContentAreaFilled(false);
        panel.add(botonEscaner);
    }

    public void setControlador(ActionListener controlador) {
        // Set the controller for the buttons
        botonEscaner.addActionListener(controlador);
        botonVerMonedero.addActionListener(controlador);
        botonConsultarMenu.addActionListener(controlador);
        botonCancelarReservas.addActionListener(controlador);
        botonSeleccionarTurnoComida.addActionListener(controlador); 
        botonCerrarSesion.addActionListener(controlador);
    }
    
    public void setNombreUsuario(String nombre) {
        this.nombreUsuario = nombre;
        actualizarTitulo();
    }

    private void actualizarTitulo() {
        JLabel titulo = (JLabel) panel.getComponent(0); // El primer componente es el título
        if (nombreUsuario != null && !nombreUsuario.isEmpty()) {
            titulo.setText("¡Bienvenido, " + nombreUsuario + "!");
        } else {
            titulo.setText("¡Bienvenido!");
        }
    }
}
