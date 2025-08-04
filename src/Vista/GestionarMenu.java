package Vista;

import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class GestionarMenu extends JFrame {
    JPanel panel;
    JTextField cajaNombreDesayuno;
    JTextField cajaDescripcionDesayuno;
    JTextField cajaNombreAlmuerzo;
    JTextField cajaDescripcionAlmuerzo;
    JButton botonGuardar;
    JButton botonVolver;

    public GestionarMenu() {
        setTitle("Gestionar Menú");
        setSize(500, 500);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        agregarPanel();
    }

    private void agregarPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);

        JLabel titulo = new JLabel("Gestión de Menú");
        titulo.setBounds(0, 30, 500, 30);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(titulo);

        // Desayuno
        JLabel labelDesayuno = new JLabel("Desayuno");
        labelDesayuno.setBounds(50, 80, 100, 25);
        labelDesayuno.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(labelDesayuno);

        JLabel labelNombreDesayuno = new JLabel("Nombre:");
        labelNombreDesayuno.setBounds(50, 110, 80, 25);
        panel.add(labelNombreDesayuno);
        cajaNombreDesayuno = new JTextField();
        cajaNombreDesayuno.setBounds(140, 110, 300, 25);
        panel.add(cajaNombreDesayuno);

        JLabel labelDescripcionDesayuno = new JLabel("Descripción:");
        labelDescripcionDesayuno.setBounds(50, 140, 80, 25);
        panel.add(labelDescripcionDesayuno);
        cajaDescripcionDesayuno = new JTextField();
        cajaDescripcionDesayuno.setBounds(140, 140, 300, 25);
        panel.add(cajaDescripcionDesayuno);

        // Almuerzo
        JLabel labelAlmuerzo = new JLabel("Almuerzo");
        labelAlmuerzo.setBounds(50, 190, 100, 25);
        labelAlmuerzo.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(labelAlmuerzo);

        JLabel labelNombreAlmuerzo = new JLabel("Nombre:");
        labelNombreAlmuerzo.setBounds(50, 220, 80, 25);
        panel.add(labelNombreAlmuerzo);
        cajaNombreAlmuerzo = new JTextField();
        cajaNombreAlmuerzo.setBounds(140, 220, 300, 25);
        panel.add(cajaNombreAlmuerzo);

        JLabel labelDescripcionAlmuerzo = new JLabel("Descripción:");
        labelDescripcionAlmuerzo.setBounds(50, 250, 80, 25);
        panel.add(labelDescripcionAlmuerzo);
        cajaDescripcionAlmuerzo = new JTextField();
        cajaDescripcionAlmuerzo.setBounds(140, 250, 300, 25);
        panel.add(cajaDescripcionAlmuerzo);

        // Botón Guardar
        botonGuardar = new JButton("Guardar");
        int anchoBoton = 100;
        int altoBoton = 30;
        int xBoton = (panel.getWidth() - anchoBoton) / 2;
        if (xBoton <= 0) xBoton = 200; // fallback si panel.getWidth() es 0
        botonGuardar.setBounds(xBoton, 320, anchoBoton, altoBoton);
        botonGuardar.setActionCommand("GUARDAR_MENU");
        botonGuardar.setBackground(Color.BLACK);
        botonGuardar.setForeground(Color.WHITE);
        panel.add(botonGuardar);

        // Botón Volver con imagen en la esquina superior izquierda
        ImageIcon iconoOriginal = new ImageIcon("recursos/volveratras.png");
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        ImageIcon iconoVolver = new ImageIcon(imagenEscalada);
        botonVolver = new JButton(iconoVolver);
        botonVolver.setBounds(10, 10, 40, 40); // esquina superior izquierda
        botonVolver.setActionCommand("VOLVER_MENU");
        botonVolver.setBackground(Color.BLACK);
        botonVolver.setBorderPainted(false); // sin borde
        botonVolver.setFocusPainted(false);  // sin borde de foco
        botonVolver.setContentAreaFilled(false); // fondo transparente
        panel.add(botonVolver); 
    }

    public void setControlador(ActionListener controlador) {
        botonGuardar.addActionListener(controlador);
        botonVolver.addActionListener(controlador);
    }

    public String getNombreDesayuno() { return cajaNombreDesayuno.getText(); }
    public String getDescripcionDesayuno() { return cajaDescripcionDesayuno.getText(); }
    public String getNombreAlmuerzo() { return cajaNombreAlmuerzo.getText(); }
    public String getDescripcionAlmuerzo() { return cajaDescripcionAlmuerzo.getText(); }
    public void limpiarCampos() {
        cajaNombreDesayuno.setText("");
        cajaDescripcionDesayuno.setText("");
        cajaNombreAlmuerzo.setText("");
        cajaDescripcionAlmuerzo.setText("");
    }
}
