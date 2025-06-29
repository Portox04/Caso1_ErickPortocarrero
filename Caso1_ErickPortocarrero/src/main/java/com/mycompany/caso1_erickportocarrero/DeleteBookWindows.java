/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caso1_erickportocarrero;

import javax.swing.JFrame;

/**
 *
 * @author porto
 */

import java.awt.*;
import javax.swing.*;

public class DeleteBookWindows extends JFrame {
    private JTextField txtCodigo;
    private Inventory inventario;
    
    public DeleteBookWindows(JFrame owner, Inventory inventario) {
        super("Eliminar Libros");

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        

        txtCodigo = new JTextField(15);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Codigo del libro que desea elimiar"), gbc);
        gbc.gridx = 1;
        add(txtCodigo, gbc);

        JPanel buttonPanel = new JPanel();
        JButton btnBorrar = new JButton("Borrar");
        JButton btnCancelar = new JButton("Cancelar");

        btnBorrar.addActionListener(e -> {
            try {
                String codigo = txtCodigo.getText();

                if (!inventario.searchBook(codigo)) {
                    throw new Exception("El codigo del libro no encontrado con el codigo: " + codigo);
                }

                inventario.deleteBook(codigo);
                JOptionPane.showMessageDialog(this, "Libro eliminado correctamente.");

                dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnCancelar.addActionListener(e -> {
            dispose();
        });
        buttonPanel.add(btnCancelar);
        buttonPanel.add(btnBorrar);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(buttonPanel, gbc);
        pack();

        

        setLocationRelativeTo(owner);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
}
