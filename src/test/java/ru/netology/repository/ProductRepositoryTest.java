package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.exception.NotFoundException;
import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository repository = new ProductRepository();
    private Book book1 = new Book(1, "book1", 100, "book1");
    private Book book2 = new Book(2, "book2", 150, "book2");
    private Smartphone smartphone1 = new Smartphone(3, "smartphone1", 500, "smartphone1");
    private Smartphone smartphone2 = new Smartphone(4, "smartphone2", 100, "smartphone2");

    @Test
    public void shouldSaveProduct() {
        repository.save(book1);

        Product[] actual = repository.getAllSavedProducts();
        Product[] expected = new Product[]{book1};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldRemoveById() {
        repository.save(book1);
        repository.save(book2);
        repository.save(smartphone1);
        repository.save(smartphone2);

        int removeId = 10;
        repository.removeById(removeId);


        Product[] actual = repository.getAllSavedProducts();
        Product[] expected = new Product[]{book1, book2, smartphone2};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldExceptionalCases() {
        repository.save(book1);
        repository.save(book2);
        repository.save(smartphone1);
        repository.save(smartphone2);

        assertThrows(NotFoundException.class, ()->{
            repository.removeById(10);
        });
    }

}