package ru.netology.product;

public class Book extends Product {
    protected String author;

    public Book(int id, String name, int cost, String author) {
        super(id, name, cost);
        this.author = author;
    }

    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        return this.author.equalsIgnoreCase(search);
    }
}
