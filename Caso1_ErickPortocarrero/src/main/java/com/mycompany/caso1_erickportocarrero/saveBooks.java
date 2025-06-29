/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caso1_erickportocarrero;

/**
 *
 * @author porto
 */
import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class saveBooks {

    public static void guardarEnArchivo(ArrayList<Book> library) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.bin"))) {
            oos.writeObject(library);
            JOptionPane.showMessageDialog(null, "Archivo guardado con exito");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Book> cargarDesdeArchivo() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.bin"))) {
            ArrayList<Book> cargados = (ArrayList<Book>) ois.readObject();
            JOptionPane.showMessageDialog(null, "Archivo cargado con exito");
            return cargados;
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar el archivo. Se usará inventario vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }
}
