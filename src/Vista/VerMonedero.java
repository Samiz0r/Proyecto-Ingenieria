package Vista;

import java.awt.event.ActionListener;

import java.awt.*;
import javax.swing.*;

public class VerMonedero extends JFrame {

    JPanel panel;
    JLabel labelSaldo;
    JButton botonVolver;
    JButton botonRecargar;
    private String correoUsuario;

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

        // Pie de página
        JLabel piePagina = new JLabel("2025 UCV");
        piePagina.setBounds(0, 530, 500, 30); // centrado en la parte inferior
        piePagina.setHorizontalAlignment(SwingConstants.CENTER);
        piePagina.setForeground(Color.GRAY);
        piePagina.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(piePagina);

        // Saldo
        labelSaldo = new JLabel("<html>Saldo Disponible:<br><span style='font-size:36px;'>$0.00</span></html>");
        labelSaldo.setBounds(0, 110, 500, 80); // aumento la altura para que no se corte
        labelSaldo.setHorizontalAlignment(SwingConstants.CENTER);
        labelSaldo.setFont(new Font("Arial", Font.BOLD, 28)); // título grande
        panel.add(labelSaldo);

        // Botón de volver con icono ajustado en la esquina superior izquierda
        ImageIcon iconoOriginal = new ImageIcon("recursos/volveratras.png");
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        ImageIcon iconoVolver = new ImageIcon(imagenEscalada);
        botonVolver = new JButton(iconoVolver);
        botonVolver.setBounds(10, 10, 40, 40); // esquina superior izquierda
        botonVolver.setActionCommand("VOLVER");
        botonVolver.setBackground(Color.BLACK);
        botonVolver.setBorderPainted(false); // sin borde
        botonVolver.setFocusPainted(false);  // sin borde de foco
        botonVolver.setContentAreaFilled(false); // fondo transparente
        panel.add(botonVolver);

        // Botón de recargar saldo
        botonRecargar = new JButton("Recargar saldo");
        botonRecargar.setBounds(165, 470, 170, 30); // centrado horizontalmente (500-170)/2=165
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

    public void setCorreo(String correo) {
        this.correoUsuario = correo;
    }

    public String getCorreo() {
        return correoUsuario;
    }
    
    
    public void actualizarSaldo(double saldo) {
        labelSaldo.setText("<html>Saldo Disponible:<br><span style='font-size:36px;'>$" + String.format("%.2f", saldo) + "</span></html>");
    }

    // Permite actualizar el saldo desde el controlador
    public void setSaldo(double saldo) {
        actualizarSaldo(saldo);
    }
}
