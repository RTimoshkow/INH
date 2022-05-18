package ru.netology.manager;

import ru.netologu.product.Product;
import ru.netologu.repository.ProductRepository;

public class ProductManager {
    protected ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.getAllSavedProducts()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }


    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
