/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caso1_erickportocarrero;

import java.util.ArrayList;

/**
 *
 * @author porto
 */
public class Inventory {
    private ArrayList<Book> library = new ArrayList<>();
    
    public void addBook(Book book) throws BooksException{
        if(searchBook(book.getCode())){
            throw new BooksException("El codigo ya existe");
        }
        else library.add(book);
    }
    
    public void deleteBook(String book){
        library.removeIf(v -> v.getCode().equals(book));
    }
    
    public boolean searchBook(String book){
        for (Book bo : library) {
            if (String.valueOf(bo.getCode()).equals(book)) {
                return true;
            }
        }
        return false;
    }
    
    public Book searchBookByCode(String code){
        for (Book bo : library) {
            if (String.valueOf(bo.getCode()).equals(code)) {
                return bo;
            }
        }
        return null;
    }
    
    public ArrayList<Book> getBooks(){
        return library;
    }
    
    public void setBook(ArrayList<Book> newBooks){
        library.clear();
        this.library = newBooks;
    }
    

}
