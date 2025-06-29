/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caso1_erickportocarrero;

/**
 *
 * @author porto
 */
import javax.swing.*;
import java.awt.*;

public class PrincipalWindows extends JFrame {

    private final Inventory inventario;
    private final JTextArea logArea;
    
    public PrincipalWindows(){
        super("Libreria");
        
        inventario = new Inventory();
        logArea = new JTextArea(10,40);
        logArea.setEditable(false);
        
        setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel();
        JButton btnAgregarLibro= new JButton("Agregar Libros");
        JButton btnBorrarLibro = new JButton("Borrar Libros");
        JButton btnMostrarLibro = new JButton("Mostrar Libros");
        JButton btnModificarLibro = new JButton("Modificar Libros");
        
        JPanel dataPanel = new JPanel();
        JButton btnCargarArchivo = new JButton("Cargar Archivo");
        JButton btnGuardarArchivo = new JButton("Guardar Archivo");
        
        controlPanel.add(btnAgregarLibro);
        controlPanel.add(btnBorrarLibro);
        controlPanel.add(btnMostrarLibro);
        controlPanel.add(btnModificarLibro);
        
        dataPanel.add(btnCargarArchivo);
        dataPanel.add(btnGuardarArchivo);
        
        JScrollPane scrollPane = new JScrollPane(logArea);
        
        add(controlPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(dataPanel, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,600);
        setVisible(true);
        
        btnAgregarLibro.addActionListener(e->addBook());
        btnBorrarLibro.addActionListener(e->deleteBook());
        btnModificarLibro.addActionListener(e->modifyBook());
        btnMostrarLibro.addActionListener(e->showBooks());
        btnGuardarArchivo.addActionListener(e->saveData());
        btnCargarArchivo.addActionListener(e->loadData());
    }
    
    private void addBook() {
        AddBookWindows vAddBo = new AddBookWindows(this, inventario);
        vAddBo.setVisible(true);       
    }
    
    private void deleteBook() {
        DeleteBookWindows vDelBo = new DeleteBookWindows(this, inventario);
        vDelBo.setVisible(true);
    }
    
    private void modifyBook() {
        ModifyBookWindows vModfBo = new ModifyBookWindows(this, inventario);
        vModfBo.setVisible(true);
    }
    
    
    private void showBooks() {
        logArea.append("\n==Libros en la libreria==\n");
        for (Book book : inventario.getBooks()) {
            logArea.append(book.getTitle()+ " - " + book.getPublisher()+ " - " + book.getAuthor()+ " - " + book.getAmount() + " - "+ book.getCode() + " -  $"+book.getPrice());
        }
        logArea.append("=========================\n\n");
    }
    
    private void saveData(){
        saveBooks.guardarEnArchivo(inventario.getBooks());
        
    }
    
    private void loadData(){
        inventario.setBook(saveBooks.cargarDesdeArchivo());
    }
    
}
