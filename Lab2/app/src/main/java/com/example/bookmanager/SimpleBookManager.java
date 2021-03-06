package com.example.bookmanager;

import android.util.Log;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class SimpleBookManager implements IBookManager {
    private ArrayList<Book> books;

    private static final SimpleBookManager manager = new SimpleBookManager();


    private SimpleBookManager() {
        books = new ArrayList<>();
    }

    private void addRandomBooks () {
        createBook("Martin, Robert C.","Clean Code" ,299,"9780132350884" ,"TDA416");
        createBook("Andrew A Andrew", "Mobile Computing", 349, "123 45 6789", "CIU196");
        createBook("Gratte, Ingvar", "Programming C/C++", 399, "91-634-2002-3", "TDA452");
        createBook("Johnsson, Oscar", "Databases", 299, "9213521321", "TDA231");
        createBook("Eva, Kuve", "Linear Algebra", 649, "231289632", "MTA215");
    }
    public int count() {
        return books.size();
    }

    public Book getBook(int index) {
        return books.get(index);
    }

    public Book createBook() {
        return createBook("", "", 0, "","");
    }


    public Book createBook(String author, String title, int price, String isbn, String course) {
        Log.d("debugjohan", String.valueOf(price));
        Book newBook = new Book(author, title, price, isbn, course);
        Log.d("debugjohan","getprice = " + String.valueOf(newBook.getPrice()));

        books.add(newBook);
        return newBook;
    }

    public ArrayList<Book> getAllBooks() {
        return books;
    }

    public void setAllBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void moveBook(int from, int to) {
        Book bookFrom = books.get(from);
        Book bookTo = books.get(to);
        books.set(to, bookFrom);
        books.set(from, bookTo);
    }

    public int getMinPrice() {
        if (books.size() == 0) {
            return 0;
        }
        int minPrice = Integer.MAX_VALUE;
        for(Book book: books) {
            int thisPrice = book.getPrice();
            if(thisPrice >= 0) {

                if (thisPrice < minPrice) {
                    minPrice = thisPrice;
                }
            }
        }
        return minPrice;
    }

    public int getMaxPrice() {
        if (books == null || books.size() == 0) {
            return 0;
        }
        if (books.size() == 0) {
            return 0;
        }
        int maxPrice = 0;
        for(Book book : books) {
            if(book.getPrice() > maxPrice) {
                maxPrice = book.getPrice();
            }
        }
        return maxPrice;
    }

    public float getMeanPrice() {
        if (books == null || books.size() == 0) {
            return 0;
        }
        int total = 0;
        int nonSpecifiedBooksCount = 0;
        for(Book book : books) {

            int thisPrice = book.getPrice();
            if(thisPrice >= 0) {
                total += thisPrice;
            } else
                nonSpecifiedBooksCount++;
        }
        if(total == 0) {
            return 0;
        }
        return total / (books.size() - nonSpecifiedBooksCount);
    }

    public int getTotalCost() {
        if (books.size() == 0) {
            return 0;
        }
        int total = 0;
        for(Book book : books) {
            int thisPrice = book.getPrice();
            if(thisPrice >= 0) {
                total += thisPrice;
            }
        }
        return total;
    }

    public static SimpleBookManager getBookManager() {
        return manager;
    }

    @Override
    public void saveChanges() {
      //  SharedPreferences sharedPreferences = getSharedPreferences
    }
}
