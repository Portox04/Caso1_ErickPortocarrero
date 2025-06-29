/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caso1_erickportocarrero;

/**
 *
 * @author porto
 */
import java.awt.*;
import javax.swing.*;

public class ModifyBookWindows extends JFrame {

    private JTextField txtTitle;
    private JTextField txtAuthor;
    private JTextField txtPublisher;
    private JTextField txtPrice;
    private JTextField txtAmount;
    private JTextField txtCode;
    private JTextField txtSearch;
    private Inventory inventario;

    public ModifyBookWindows(JFrame owner, Inventory inventario) {
        super("Modificar Libros");

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtSearch = new JTextField(15);
        txtCode = new JTextField(15);
        txtTitle = new JTextField(15);
        txtAuthor = new JTextField(15);
        txtPublisher = new JTextField(15);
        txtAmount = new JTextField(15);
        txtPrice = new JTextField(15);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Codigo: "), gbc);
        gbc.gridx = 1;
        add(txtSearch, gbc);

        JPanel button1Panel = new JPanel();
        JButton btnSearch = new JButton("Buscar");
        button1Panel.add(btnSearch);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(button1Panel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Titulo: "), gbc);
        gbc.gridx = 1;
        add(txtTitle, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Autor: "), gbc);
        gbc.gridx = 1;
        add(txtAuthor, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Editorial: "), gbc);
        gbc.gridx = 1;
        add(txtPublisher, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(new JLabel("Precio: "), gbc);
        gbc.gridx = 1;
        add(txtPrice, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        add(new JLabel("Cantidad: "), gbc);
        gbc.gridx = 1;
        add(txtAmount, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        add(new JLabel("Codigo: "), gbc);
        gbc.gridx = 1;
        add(txtCode, gbc);

        JPanel buttonPanel = new JPanel();
        JButton btnGuardar = new JButton("Guardar");
        JButton btnCancelar = new JButton("Cancelar");

        btnSearch.addActionListener(e -> {
            try {
                if (txtSearch.getText().isEmpty()) {
                    throw new Exception("Debe ingresar un código.");
                }
                Book bookFound = inventario.searchBookByCode(txtSearch.getText());

                if (bookFound == null) {
                    throw new Exception("Libro no encontrado");
                }
                // Mostrar datos en campos
                txtTitle.setText(bookFound.getTitle());
                txtAuthor.setText(bookFound.getAuthor());
                txtPublisher.setText(bookFound.getPublisher());
                txtPrice.setText(String.valueOf(bookFound.getPrice()));
                txtAmount.setText(String.valueOf(bookFound.getAmount()));
                txtCode.setText(bookFound.getCode());
                txtSearch.setEditable(false);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        });

        btnGuardar.addActionListener(e -> {
            try {
                Book bookFound = inventario.searchBookByCode(txtSearch.getText());
                if (bookFound == null) {
                    throw new Exception("No se puede modificar un libro que no existe.");
                }

                bookFound.setTitle(txtTitle.getText());
                bookFound.setAuthor(txtAuthor.getText());
                bookFound.setPublisher(txtPublisher.getText());
                bookFound.setAmount(Integer.parseInt(txtAmount.getText()));
                bookFound.setPrice(Double.parseDouble(txtPrice.getText()));
                

                JOptionPane.showMessageDialog(this, "Libro modificado correctamente.");
                dispose();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese números válidos en precio y cantidad.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnCancelar.addActionListener(e -> {
            dispose();
        });
        buttonPanel.add(btnCancelar);
        buttonPanel.add(btnGuardar);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        add(buttonPanel, gbc);
        pack();

        setLocationRelativeTo(owner);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
