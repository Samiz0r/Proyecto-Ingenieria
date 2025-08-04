package Vista;

import javax.swing.*;
import java.awt.*;

public class SeleccionarTurnoComida extends JFrame {
    JPanel panel;
    JComboBox<String> comboTurno;
    JButton botonReserva;
    JButton botonVolver;

    public SeleccionarTurnoComida() {
        setTitle("Seleccionar Turno de Comida");
        setSize(400, 250);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        agregarPanel();
    }

    private void agregarPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);

        JLabel titulo = new JLabel("Seleccione su turno de comida");
        titulo.setBounds(0, 20, 400, 30);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(titulo);

        comboTurno = new JComboBox<>(new String[]{"Desayuno", "Almuerzo"});
        comboTurno.setBounds(100, 70, 200, 30);
        panel.add(comboTurno);

        // Botón Realizar Reserva
        botonReserva = new JButton("Realizar Reserva");
        int anchoBoton = 150;
        int altoBoton = 35;
        int xBoton = (400 - anchoBoton) / 2;
        botonReserva.setBounds(xBoton, 120, anchoBoton, altoBoton);
        botonReserva.setActionCommand("REALIZAR_RESERVA");
        botonReserva.setBackground(Color.BLACK);
        botonReserva.setForeground(Color.WHITE);
        panel.add(botonReserva);

        // Botón Volver con imagen en la esquina superior izquierda
        ImageIcon iconoOriginal = new ImageIcon("recursos/volveratras.png");
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        ImageIcon iconoVolver = new ImageIcon(imagenEscalada);
        botonVolver = new JButton(iconoVolver);
        botonVolver.setBounds(10, 10, 40, 40);
        botonVolver.setActionCommand("VOLVER_CONSULTA_MENU");
        botonVolver.setBackground(Color.BLACK);
        botonVolver.setBorderPainted(false);
        botonVolver.setFocusPainted(false);
        botonVolver.setContentAreaFilled(false);
        panel.add(botonVolver);
    }

    public String getTurnoSeleccionado() {
        return (String) comboTurno.getSelectedItem();
    }

    public void setControlador(java.awt.event.ActionListener controlador) {
        botonReserva.addActionListener(controlador);
        botonVolver.addActionListener(controlador);
    }
}
