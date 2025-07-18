package Vista;

import java.awt.event.ActionListener;

import java.awt.*;
import javax.swing.*;

public class InicioSesion extends JFrame {

    JPanel panel;
    JTextField cajaTextoCorreo;
    JTextField cajaTextoContrasena;
    JButton botonContinuar;
    JButton botonRegistrarse;

    public InicioSesion(){
        setTitle("Inicio Sesion");
        setSize(500, 600);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        agregarPanel();
    }

    public void agregarPanel() {
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
        subTitulo.setText("Inicia Sesión");
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
 

        agregarCorreo();
        agregarContrasena();

        agregarBotonContinuar();
        agregarSeparador();
        agregarBotonRegistrarse();

    }   


    public void agregarCorreo(){
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

    public void agregarContrasena(){
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

    private void agregarBotonContinuar(){
        botonContinuar = new JButton("Continuar");
        botonContinuar.setBounds(75,230,350,30); // mismo ancho que las cajas de texto
        botonContinuar.setActionCommand("CONTINUAR");
        botonContinuar.setBackground(Color.BLACK); // fondo negro
        botonContinuar.setForeground(Color.WHITE); // letras blancas
        panel.add(botonContinuar);
    }

    private void agregarSeparador(){
        JSeparator separador = new JSeparator();
        separador.setBounds(75,270,350,2); // mismo ancho que las cajas de texto, centrado
        separador.setBackground(new Color(220,220,220)); // gris muy claro
        separador.setForeground(new Color(220,220,220)); // gris muy claro
        panel.add(separador);
    }

    private void agregarBotonRegistrarse(){
        botonRegistrarse = new JButton("<html>¿Aún no tienes una cuenta?<br><div style='text-align:center;'>Regístrate</div></html>");
        botonRegistrarse.setBounds(75,285,350,40); // ajusto la posición para dejar espacio al separador
        botonRegistrarse.setActionCommand("REGISTRARSE");
        botonRegistrarse.setBackground(new Color(220,220,220)); // gris claro
        botonRegistrarse.setForeground(Color.BLACK); // letras negras
        botonRegistrarse.setFont(new Font("Arial", Font.PLAIN, 13));
        botonRegistrarse.setVerticalAlignment(SwingConstants.CENTER);
        botonRegistrarse.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(botonRegistrarse);
    }

     public void setControlador(ActionListener controlador) {
        // Set the controller for the buttons
        botonContinuar.addActionListener(controlador);
        botonRegistrarse.addActionListener(controlador);
    }
    
}   
