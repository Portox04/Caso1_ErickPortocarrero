/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caso1_erickportocarrero;

import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author porto
 */
public final class Book implements Serializable, Discount{

    private static final long serialVersionUID = 1L;
    private String title;
    private String author;
    private String publisher;
    private double price;
    private int amount;
    private String code;

    public Book(String title, String author, String publisher, double price, int amount, String code) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.amount = amount;
        this.price = applyDiscount(price);
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = applyDiscount(price);;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Book{" + "title=" + title + ", author=" + author + ", publisher=" + publisher + ", price=" + price + ", amount=" + amount + ", code=" + code + '}';
    }

    public void mostrarLibro() {
        System.out.println("Libro");
        System.out.println("Titulo: " + getTitle());
        System.out.println("Autor: " + getAuthor());
        System.out.println("Editorial: " + getPublisher());
        System.out.println("Codigo: " + getCode());
        System.out.println("Precio: " + getPrice());
        System.out.println("Cantidad: " + getAmount());
    }
    
    public double applyDiscount(double price){
        if(amount>10){           
            JOptionPane.showMessageDialog(null, "Descuento aplicado por inventario");
            return price*0.9;
        }
        else {return price;}
    }

}
