package Vista;

import java.awt.event.ActionListener;

import java.awt.*;
import javax.swing.*;


public class Registrarse extends JFrame {

    JPanel panel;
    JTextField cajaTextoCorreo;
    JTextField cajaTextoContrasena;
    JTextField cajaTextoNombreCompleto;
    JTextField cajaTextoCedula;

    JButton botonContinuar;
    JButton botonContinuarAdmin;
    JButton botonInicioSesion;
    
    
    public Registrarse() {
        setTitle("Registrarse");
        setSize(500, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        agregarPanel();       
    }

    private void agregarPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        
        //Titulo
        JLabel titulo = new JLabel();
        titulo.setText("Comedor Universitario"); // texto que se muestra en la etiqueta");
        titulo.setBounds(0,40,500,20); // centrado horizontalmente
        titulo.setHorizontalAlignment(SwingConstants.CENTER); // establecer en el centro de la etiqueta el texto
        titulo.setForeground(Color.BLACK); // color de la letra
        titulo.setFont(new Font("Arial", Font.BOLD, 20)); // cambia el tamaño y tipo de fuente
        panel.add(titulo);

        //Subtitulo

        JLabel subTitulo = new JLabel();
        subTitulo.setText("Crea una Cuenta");
        subTitulo.setBounds(0,75,500,20); // centrado horizontalmente
        subTitulo.setHorizontalAlignment(SwingConstants.CENTER); // establecer en el centro de la etiqueta el texto
        subTitulo.setForeground(Color.BLACK); // color de la letra
        subTitulo.setFont(new Font("Arial", Font.BOLD, 17)); // cambia el tamaño y tipo de fuente
        panel.add(subTitulo);

        //Subtitulo2

        JLabel subTitulo2 = new JLabel();
        subTitulo2.setText("Ingresa tus datos");
        subTitulo2.setBounds(0,95,500,20); // centrado horizontalmente
        subTitulo2.setHorizontalAlignment(SwingConstants.CENTER); // establecer en el centro de la etiqueta el texto
        subTitulo2.setForeground(Color.BLACK); // color de la letra
        subTitulo2.setFont(new Font("Arial", Font.PLAIN, 15)); // cambia el tamaño y tipo de fuente
        panel.add(subTitulo2);


        //Caja de texto
        agregarCorreo();
        agregarContrasena();
        agregarNombreCompleto();
        agregarCedula();

        //Botones
        agregarBotonContinuar();
        agregarBotonContinuarAdmin();
        agregarSeparador();
        agregarBotonInicioSesion();


    }


    private void agregarCorreo(){
        cajaTextoCorreo = new JTextField(" Correo electrónico");
        cajaTextoCorreo.setBounds(75,150,350,30);
        cajaTextoCorreo.setForeground(Color.GRAY);
        cajaTextoCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent e) {
                if (cajaTextoCorreo.getText().equals(" Correo electrónico")) {
                    cajaTextoCorreo.setText("");
                    cajaTextoCorreo.setForeground(Color.BLACK);
                }
            }
            public void focusLost(java.awt.event.FocusEvent e) {
                if (cajaTextoCorreo.getText().isEmpty()) {
                    cajaTextoCorreo.setText(" Correo electrónico");
                    cajaTextoCorreo.setForeground(Color.GRAY);
                }
            }
        });
        panel.add(cajaTextoCorreo);
    }

    private void agregarContrasena(){
        cajaTextoContrasena = new JTextField(" Contraseña");
        cajaTextoContrasena.setBounds(75,190,350,30);
        cajaTextoContrasena.setForeground(Color.GRAY);
        cajaTextoContrasena.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent e) {
                if (cajaTextoContrasena.getText().equals(" Contraseña")) {
                    cajaTextoContrasena.setText("");
                    cajaTextoContrasena.setForeground(Color.BLACK);
                }
            }
            public void focusLost(java.awt.event.FocusEvent e) {
                if (cajaTextoContrasena.getText().isEmpty()) {
                    cajaTextoContrasena.setText(" Contraseña");
                    cajaTextoContrasena.setForeground(Color.GRAY);
                }
            }
        });
        panel.add(cajaTextoContrasena);
    }

    private void agregarNombreCompleto(){
        cajaTextoNombreCompleto = new JTextField(" Nombre Completo");
        cajaTextoNombreCompleto.setBounds(75,230,350,30);
        cajaTextoNombreCompleto.setForeground(Color.GRAY);
        cajaTextoNombreCompleto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent e) {
                if (cajaTextoNombreCompleto.getText().equals(" Nombre Completo")) {
                    cajaTextoNombreCompleto.setText("");
                    cajaTextoNombreCompleto.setForeground(Color.BLACK);
                }
            }
            public void focusLost(java.awt.event.FocusEvent e) {
                if (cajaTextoNombreCompleto.getText().isEmpty()) {
                    cajaTextoNombreCompleto.setText(" Nombre Completo");
                    cajaTextoNombreCompleto.setForeground(Color.GRAY);
                }
            }
        });
        panel.add(cajaTextoNombreCompleto);
    }

    private void agregarCedula(){
        cajaTextoCedula = new JTextField(" Cedula");
        cajaTextoCedula.setBounds(75,270,350,30);
        cajaTextoCedula.setForeground(Color.GRAY);
        cajaTextoCedula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent e) {
                if (cajaTextoCedula.getText().equals("Cedula")) {
                    cajaTextoCedula.setText("");
                    cajaTextoCedula.setForeground(Color.BLACK);
                }
            }
            public void focusLost(java.awt.event.FocusEvent e) {
                if (cajaTextoCedula.getText().isEmpty()) {
                    cajaTextoCedula.setText("Cedula");
                    cajaTextoCedula.setForeground(Color.GRAY);
                }
            }
        });
        panel.add(cajaTextoCedula);
    }

    private void agregarBotonContinuar(){
        botonContinuar = new JButton("Continuar");
        botonContinuar.setBounds(75,310,350,30); // mismo ancho que las cajas de texto
        botonContinuar.setActionCommand("CONTINUAR");
        botonContinuar.setBackground(Color.BLACK); // fondo negro
        botonContinuar.setForeground(Color.WHITE); // letras blancas
        panel.add(botonContinuar);
    }

    private void agregarBotonContinuarAdmin(){
        botonContinuarAdmin = new JButton("Continuar como Administrador");
        botonContinuarAdmin.setBounds(75,350,350,30); // mismo ancho que las cajas de texto
        botonContinuarAdmin.setActionCommand("CONTINUAR_ADMIN");
        botonContinuarAdmin.setBackground(Color.BLACK); // fondo negro
        botonContinuarAdmin.setForeground(Color.WHITE); // letras blancas
        panel.add(botonContinuarAdmin);
    }

    private void agregarSeparador(){
        JSeparator separador = new JSeparator();
        separador.setBounds(75,390,350,2); // mismo ancho que las cajas de texto, centrado
        separador.setBackground(new Color(220,220,220)); // gris muy claro
        separador.setForeground(new Color(220,220,220)); // gris muy claro
        panel.add(separador);
    }

    private void agregarBotonInicioSesion(){
        botonInicioSesion = new JButton("<html>¿Tienes una cuenta?<br><div style='text-align:center;'>Inicia Sesion</div></html>");
        botonInicioSesion.setBounds(75,405,350,40); // ajusto la posición para dejar espacio al separador
        botonInicioSesion.setActionCommand("INICIO_SESION");
        botonInicioSesion.setBackground(new Color(220,220,220)); // gris claro
        botonInicioSesion.setForeground(Color.BLACK); // letras negras
        botonInicioSesion.setFont(new Font("Arial", Font.PLAIN, 13));
        botonInicioSesion.setVerticalAlignment(SwingConstants.CENTER);
        botonInicioSesion.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(botonInicioSesion);
    }

    public void setControlador(ActionListener controlador) {
        // Set the controller for the buttons
        botonContinuar.addActionListener(controlador);
        botonContinuarAdmin.addActionListener(controlador);
        botonInicioSesion.addActionListener(controlador);   
    }

}