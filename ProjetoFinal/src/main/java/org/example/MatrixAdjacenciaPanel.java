package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MatrizAdjacenciaPanel extends JPanel {
    private final int[][] matriz;

    public MatrizAdjacenciaPanel(int[][] matriz) {
        this.matriz = matriz;
        setLayout(new BorderLayout());
        JTable tabela = new JTable(new DefaultTableModel(matriz.length, matriz.length) {
            @Override
            public Object getValueAt(int row, int column) {
                return matriz[row][column];
            }

            @Override
            public void setValueAt(Object value, int row, int column) {
                matriz[row][column] = (int) value;
            }
        });

        tabela.setCellSelectionEnabled(true);
        tabela.setRowHeight(30);

        // Custom Renderer para colorir as células
        tabela.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                int peso = (int) value;
                if (peso == 0) {
                    cell.setBackground(Color.WHITE);
                } else if (peso < 5) {
                    cell.setBackground(Color.GREEN);
                } else if (peso < 10) {
                    cell.setBackground(Color.YELLOW);
                } else {
                    cell.setBackground(Color.RED);
                }
                return cell;
            }
        });

        add(new JScrollPane(tabela), BorderLayout.CENTER);
    }

    public static void mostrarMatrizAdjacencia(int[][] matriz) {
        JFrame frame = new JFrame("Matriz de Adjacência");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(new MatrizAdjacenciaPanel(matriz));
        frame.setVisible(true);
    }
}
