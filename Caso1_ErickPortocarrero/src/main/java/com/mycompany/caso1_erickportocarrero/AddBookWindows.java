/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caso1_erickportocarrero;

import javax.swing.*;
import java.awt.*;


/**
 *
 * @author porto
 */
public class AddBookWindows extends JFrame {
    
    private JTextField txtTitle;
    private JTextField txtAuthor;
    private JTextField txtPublisher;
    private JTextField txtPrice;
    private JTextField txtAmount;
    private JTextField txtCode;
    
    private Inventory inventario;
    
    public AddBookWindows(JFrame owner, Inventory inventario){
        super("Agregar Libro");
        
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtTitle = new JTextField(20);
        txtAuthor = new JTextField(20);
        txtPublisher = new JTextField(20);
        txtPrice = new JTextField(20);
        txtAmount = new JTextField(20);
        txtCode = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Titulo: "), gbc);
        gbc.gridx = 1;
        add(txtTitle, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Autor: "), gbc);
        gbc.gridx = 1;
        add(txtAuthor, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Editorial: "), gbc);
        gbc.gridx = 1;
        add(txtPublisher, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Precio: "), gbc);
        gbc.gridx = 1;
        add(txtPrice, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Cantidad: "), gbc);
        gbc.gridx = 1;
        add(txtAmount, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(new JLabel("Codigo: "), gbc);
        gbc.gridx = 1;
        add(txtCode, gbc);

        JPanel buttonPanel = new JPanel();
        JButton btnGuardar = new JButton("Guardar");
        JButton btnCancelar = new JButton("Cancelar");
        
        btnGuardar.addActionListener(e -> {
            try {
                String titulo = txtTitle.getText();
                String autor = txtAuthor.getText();
                String editorial = txtPublisher.getText();
                double precio = Double.parseDouble(txtPrice.getText());
                int cantidad = Integer.parseInt(txtAmount.getText());
                String codigo = txtCode.getText();
                
                Book nuevo = new Book(titulo, autor, editorial, precio, cantidad, codigo);
                inventario.addBook(nuevo);
                JOptionPane.showMessageDialog(this, "Libro agregado correctamente.");
                
                dispose();
                
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor digitar numeros en los campos que lo requieren", "ERROR", JOptionPane.ERROR_MESSAGE);
            } catch (BooksException ex){
                
            }
        });
        
        btnCancelar.addActionListener(e -> {
            dispose();
        });
        buttonPanel.add(btnCancelar);
        buttonPanel.add(btnGuardar);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        add(buttonPanel, gbc);
        pack();

        setLocationRelativeTo(owner);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }
    
    
}
