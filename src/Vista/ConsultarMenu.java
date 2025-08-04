package Vista;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ConsultarMenu extends JFrame {
    JPanel panel;
    JLabel labelDesayuno;
    JLabel labelDescripcionDesayuno;
    JLabel labelAlmuerzo;
    JLabel labelDescripcionAlmuerzo;
    JLabel labelMonto;
    JLabel labelValorMonto;
    JButton botonVolver;

    public ConsultarMenu() {
        setTitle("Consultar Menú");
        setSize(500, 350);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        agregarPanel();
        cargarUltimoMenu();
    }

    private void agregarPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);

        JLabel titulo = new JLabel("Menú Actual");
        titulo.setBounds(0, 20, 500, 30);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(titulo);

        labelDesayuno = new JLabel("Desayuno: ");
        labelDesayuno.setBounds(50, 70, 400, 25);
        labelDesayuno.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(labelDesayuno);

        labelDescripcionDesayuno = new JLabel("Descripción: ");
        labelDescripcionDesayuno.setBounds(50, 100, 400, 25);
        panel.add(labelDescripcionDesayuno);

        labelAlmuerzo = new JLabel("Almuerzo: ");
        labelAlmuerzo.setBounds(50, 150, 400, 25);
        labelAlmuerzo.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(labelAlmuerzo);

        labelDescripcionAlmuerzo = new JLabel("Descripción: ");
        labelDescripcionAlmuerzo.setBounds(50, 180, 400, 25);
        panel.add(labelDescripcionAlmuerzo);

        // Monto a pagar y valor
        labelMonto = new JLabel("Monto a pagar:");
        labelMonto.setBounds(80, 205, 150, 30); // Bajado para evitar choque
        labelMonto.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(labelMonto);

        labelValorMonto = new JLabel("$");
        labelValorMonto.setBounds(240, 205, 150, 30); // Bajado para evitar choque
        labelValorMonto.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(labelValorMonto);

        ImageIcon iconoOriginal = new ImageIcon("recursos/volveratras.png");
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        ImageIcon iconoVolver = new ImageIcon(imagenEscalada);
        botonVolver = new JButton(iconoVolver);
        botonVolver.setBounds(10, 10, 40, 40); // esquina superior izquierda
        botonVolver.setActionCommand("VOLVER_MENU");
        botonVolver.setBackground(Color.BLACK);
        botonVolver.setBorderPainted(false);
        botonVolver.setFocusPainted(false);
        botonVolver.setContentAreaFilled(false);
        panel.add(botonVolver);

        JButton botonSeleccionarTurno = new JButton("Seleccionar Turno Comida");
        int anchoBoton = 200;
        int altoBoton = 35;
        int xBoton = (500 - anchoBoton) / 2;
        botonSeleccionarTurno.setBounds(xBoton, 250, anchoBoton, altoBoton); // Bajado para evitar choque
        botonSeleccionarTurno.setActionCommand("SELECCIONAR_TURNO_COMIDA");
        botonSeleccionarTurno.setBackground(Color.BLACK);
        botonSeleccionarTurno.setForeground(Color.WHITE);
        panel.add(botonSeleccionarTurno);
        this.botonSeleccionarTurno = botonSeleccionarTurno;
    }

    private void cargarUltimoMenu() {
        String ruta = "Data/dataMenus.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea, ultimo = null;
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    ultimo = linea;
                }
            }
            if (ultimo != null) {
                String[] partes = ultimo.split(";");
                if (partes.length == 4) {
                    labelDesayuno.setText("Desayuno: " + partes[0]);
                    labelDescripcionDesayuno.setText("Descripción: " + partes[1]);
                    labelAlmuerzo.setText("Almuerzo: " + partes[2]);
                    labelDescripcionAlmuerzo.setText("Descripción: " + partes[3]);
                }
            }
        } catch (Exception e) {
            labelDesayuno.setText("No hay menú disponible.");
            labelDescripcionDesayuno.setText("");
            labelAlmuerzo.setText("");
            labelDescripcionAlmuerzo.setText("");
        }
        // Mostrar el 30% del CCB
        double ccb = obtenerCCBUsuarioActual();
        double monto = ccb * 0.3;
        labelValorMonto.setText("$" + String.format("%.2f", monto));
    }

    // Método auxiliar para obtener el CCB actual (solo toma el último valor del campo 5)
    private double obtenerCCBUsuarioActual() {
        String ruta = "Data/dataCCB.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea, ultimo = null;
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    ultimo = linea;
                }
            }
            if (ultimo != null) {
                String[] partes = ultimo.split(";");
                if (partes.length >= 6) {
                    return Double.parseDouble(partes[5]);
                }
            }
        } catch (Exception e) {
            System.err.println("Error al leer el CCB actual: " + e.getMessage());
        }
        return 0.0;
    }

    private JButton botonSeleccionarTurno;

    public void setControlador(java.awt.event.ActionListener controlador) {
        botonVolver.addActionListener(controlador);
        botonSeleccionarTurno.addActionListener(controlador);
    }
}
