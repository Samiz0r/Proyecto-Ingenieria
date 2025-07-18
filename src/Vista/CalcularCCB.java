package Vista;

import java.awt.event.ActionListener;

import java.awt.*;
import javax.swing.*;

public class CalcularCCB extends JFrame {

    JPanel panel;
    JTextField cajaPeriodo;
    JTextField cajaCostosFijos;
    JTextField cajaCostosVariados;
    JTextField cajaNBandejas;
    JTextField cajaMerma;
    

    JButton botonCalcular;
    JButton botonVolver;
    
    public CalcularCCB() {
        setTitle("Calcular CCB");
        setSize(500, 600);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        agregarPanel();
    }

    private void agregarPanel(){

        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        
        // Título
        
        JLabel titulo = new JLabel("Calcular CCB");
        titulo.setBounds(0, 40, 500, 20);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(titulo);

        // Subtítulo

        JLabel subTitulo = new JLabel("Ingrese los datos necesarios para calcular el CCB");
        subTitulo.setBounds(0, 90, 500, 20); // centrado horizontalmente
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

        agregarEtiquetas();
        agregarTextField();
        colocarBotones();
    }

    private void agregarEtiquetas() {
        
        JLabel periodo = new JLabel("Periodo (MM/AAAA):");
        periodo.setBounds(50, 140, 100, 30);
        panel.add(periodo);

        JLabel costosFijos = new JLabel("Costos Fijos:");
        costosFijos.setBounds(50, 200, 100, 30);
        panel.add(costosFijos);

        JLabel costosVariables = new JLabel("Costos Variables:");
        costosVariables.setBounds(50, 260, 100, 30);
        panel.add(costosVariables);

        JLabel bandejas = new JLabel("N° Bandejas:");
        bandejas.setBounds(50, 320, 100, 30);
        panel.add(bandejas);

        JLabel merma = new JLabel("% Merma:");
        merma.setBounds(50, 380, 150, 30);
        panel.add(merma);

    }
    
    private void agregarTextField() {
        cajaPeriodo = new JTextField();
        cajaPeriodo.setBounds(250, 140, 200, 30);
        panel.add(cajaPeriodo);

        cajaCostosFijos = new JTextField();
        cajaCostosFijos.setBounds(250, 200, 200, 30);
        panel.add(cajaCostosFijos);

        cajaCostosVariados = new JTextField();
        cajaCostosVariados.setBounds(250, 260, 200, 30);
        panel.add(cajaCostosVariados);

        cajaNBandejas = new JTextField();   
        cajaNBandejas.setBounds(250, 320, 200, 30);
        panel.add(cajaNBandejas);

        cajaMerma = new JTextField();
        cajaMerma.setBounds(250, 380, 200, 30);
        panel.add(cajaMerma);

    }

    private void colocarBotones() {
        botonCalcular = new JButton("Calcular");
        botonCalcular.setBounds(165, 460, 170, 30); // centrado horizontalmente (500-170)/2=165
        botonCalcular.setForeground(Color.WHITE); // letras blancas
        botonCalcular.setBackground(Color.BLACK); // fondo negro 
        botonCalcular.setActionCommand("CALCULAR");
        panel.add(botonCalcular);

        // Botón de volver con icono en la esquina superior izquierda
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
    }

    public void setControlador(ActionListener controlador) {
        // Set the controller for the button
        botonCalcular.addActionListener(controlador);
        botonVolver.addActionListener(controlador);
    }
    
    // Métodos para calcular CCB 
    public double calcularCostoCCB(double precioPorComida, int numeroDeComidas) {
        return precioPorComida * numeroDeComidas;
    }

}
