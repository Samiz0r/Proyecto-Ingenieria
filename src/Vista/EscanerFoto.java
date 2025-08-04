package Vista;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class EscanerFoto extends JFrame {
    JPanel panel;
    JLabel labelImagen;
    JButton botonSubirFoto;
    JButton botonVerificar;
    JButton botonVolver;
    JFileChooser fileChooser;
    File imagenSeleccionada;

    public EscanerFoto() {
        setTitle("Escanear y Verificar Foto");
        setSize(400, 400);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        agregarPanel();
    }

    private void agregarPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);

        JLabel titulo = new JLabel("Suba su foto para verificar identidad");
        titulo.setBounds(0, 20, 400, 30);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(titulo);

        labelImagen = new JLabel();
        labelImagen.setBounds(100, 60, 200, 200);
        labelImagen.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        labelImagen.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(labelImagen);

        botonSubirFoto = new JButton("Subir Foto");
        botonSubirFoto.setBounds(120, 270, 150, 30);
        botonSubirFoto.setActionCommand("SUBIR_FOTO");
        botonSubirFoto.setBackground(Color.BLACK);
        botonSubirFoto.setForeground(Color.WHITE);
        panel.add(botonSubirFoto);

        botonVerificar = new JButton("Verificar");
        botonVerificar.setBounds(120, 310, 150, 30);
        botonVerificar.setActionCommand("VERIFICAR_FOTO");
        botonVerificar.setBackground(Color.BLACK);
        botonVerificar.setForeground(Color.WHITE);
        panel.add(botonVerificar);

        ImageIcon iconoVolver = new ImageIcon("recursos/volveratras.png");
        Image imagenEscalada = iconoVolver.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        botonVolver = new JButton(new ImageIcon(imagenEscalada));
        botonVolver.setBounds(10, 10, 32, 32);
        botonVolver.setActionCommand("VOLVER_DASHBOARD");
        botonVolver.setBackground(Color.BLACK);
        botonVolver.setBorderPainted(false);
        botonVolver.setFocusPainted(false);
        botonVolver.setContentAreaFilled(false);
        panel.add(botonVolver);
    }

    public void mostrarImagen(File imagen) {
        if (imagen != null && imagen.exists()) {
            ImageIcon icono = new ImageIcon(imagen.getAbsolutePath());
            Image img = icono.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            labelImagen.setIcon(new ImageIcon(img));
        } else {
            labelImagen.setIcon(null);
        }
    }

    public void setControlador(java.awt.event.ActionListener controlador) {
        botonSubirFoto.addActionListener(controlador);
        botonVerificar.addActionListener(controlador);
        botonVolver.addActionListener(controlador);
    }
}
