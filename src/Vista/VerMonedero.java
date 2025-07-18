package Vista;

import java.awt.event.ActionListener;

import java.awt.*;
import javax.swing.*;

public class VerMonedero extends JFrame {

    JPanel panel;
    JLabel labelSaldo;
    JButton botonVolver;
    JButton botonRecargar;

    public VerMonedero() {
        setTitle("Ver Monedero");
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
        JLabel titulo = new JLabel("Mi Monedero");
        titulo.setBounds(0, 40, 500, 20);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(titulo);

        // Saldo
        labelSaldo = new JLabel("<html>Saldo Disponible:<br><span style='font-size:36px;'>$0.00</span></html>");
        labelSaldo.setBounds(0, 110, 500, 80); // aumento la altura para que no se corte
        labelSaldo.setHorizontalAlignment(SwingConstants.CENTER);
        labelSaldo.setFont(new Font("Arial", Font.BOLD, 28)); // título grande
        panel.add(labelSaldo);

        // Botón de volver
        botonVolver = new JButton("Volver");    
        botonVolver.setBounds(80, 500, 120, 30);
        botonVolver.setActionCommand("VOLVER");
        botonVolver.setBackground(Color.BLACK);
        botonVolver.setForeground(Color.WHITE); // letras blancas
        panel.add(botonVolver);

        // Botón de recargar saldo
        botonRecargar = new JButton("Recargar saldo");
        botonRecargar.setBounds(250, 500, 170, 30); // más ancho y ajustado a la derecha
        botonRecargar.setActionCommand("RECARGAR");
        botonRecargar.setBackground(Color.BLACK); // negro
        botonRecargar.setForeground(Color.WHITE);
        panel.add(botonRecargar);
    }  

    public void setControlador(ActionListener controlador) {
        // Set the controller for the button
        botonVolver.addActionListener(controlador);
        botonRecargar.addActionListener(controlador);
    }
    
    
    public void actualizarSaldo(double saldo) {
        labelSaldo.setText("<html>Saldo Disponible:<br><span style='font-size:36px;'>$" + String.format("%.2f", saldo) + "</span></html>");
    }
}
