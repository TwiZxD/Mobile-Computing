package com.example.bookmanager;

import java.util.ArrayList;

public interface IBookManager {
    int count();
    Book getBook(int index);
    Book createBook();
    ArrayList<Book> getAllBooks();
    void removeBook(Book book);
    void moveBook (int from, int to);
    int getMinPrice();
    int getMaxPrice();
    float getMeanPrice();
    int getTotalCost();
    void saveChanges();
}
