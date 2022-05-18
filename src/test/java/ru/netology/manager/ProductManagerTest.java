package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netologu.product.Book;
import ru.netologu.product.Product;
import ru.netologu.product.Smartphone;
import ru.netologu.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager product = new ProductManager(repository);

    private Book book1 = new Book(1, "book1", 100, "book11");
    private Book book2 = new Book(2, "book2", 150, "book22");
    private Smartphone smartphone1 = new Smartphone(3, "smartphone1", 500, "smartphone11");
    private Smartphone smartphone2 = new Smartphone(4, "smartphone2", 100, "smartphone22");

    @Test
    public void shouldProductSearch() {
        product.add(book1);
        product.add(book2);

        Product[] actual = product.searchBy( "book1" );
        Product[] expectad = new Product[]{book1};

        assertArrayEquals(actual, expectad);
    }
}