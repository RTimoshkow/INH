package ru.netology.product;

public class Smartphone extends Product {
    protected String manufacturer;

    public Smartphone(int id, String name, int cost, String manufacturer) {
        super(id, name, cost);
        this.manufacturer = manufacturer;
    }

    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        return this.manufacturer.equalsIgnoreCase(search);
    }
}
