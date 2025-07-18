package Vista;

import java.awt.*;
import javax.swing.*;

public class CalcularCCB extends JFrame {

    JPanel panel;
    
    public CalcularCCB() {
        setTitle("Calcular CCB");
        setSize(500, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
    }

    // Métodos para calcular CCB (Costo de Comedor Básico) pueden ser añadidos aquí
    // Por ejemplo, un método que calcule el costo basado en ciertos parámetros
    public double calcularCosto(double precioPorComida, int numeroDeComidas) {
        return precioPorComida * numeroDeComidas;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalcularCCB calcularCCB = new CalcularCCB();
            calcularCCB.setVisible(true);
        });
    }
}
