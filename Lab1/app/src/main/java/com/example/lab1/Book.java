package com.example.lab1;

public class Book {

    private String author;
    private String title;
    private int price;
    private String isbn;
    private String course;

    public Book(String author, String title, int price, String isbn, String course) {
        this.author = author;
        this.title = title;
        this.price = price;
        this.isbn = isbn;
        this.course = course;
    }

    public Book() {
        this.author = "";
        this.title = "";
        this.price = 0;
        this.isbn = "";
        this.course = "";
    }

    /** Getters */

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getCourse() {
        return course;
    }

    /** Setters */

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setCourse(String course) {
        this.course = course;
    }


}
