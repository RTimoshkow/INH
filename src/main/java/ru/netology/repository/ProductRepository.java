package ru.netology.repository;

import ru.netology.exception.AlreadyExistsException;
import ru.netology.exception.NotFoundException;
import ru.netology.product.Product;

import static com.sun.tools.javac.jvm.ByteCodes.ret;

public class ProductRepository {
    Product[] products = new Product[0];

    public void save(Product product) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        if (product.getId() == product.getId()) {
            throw new AlreadyExistsException("Элемент с таким id уже существует");
        }
        System.arraycopy(products, 0, tmp, 0, products.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = product;
        products = tmp;
    }

    public Product[] getAllSavedProducts() {
        return products;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        int length = products.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
        }
        products = tmp;
    }
}
