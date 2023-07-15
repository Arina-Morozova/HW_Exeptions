package org.example.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    Product product1 = new Product(1, "Носки", 80);
    Product product2 = new Product(2, "Куртка", 2000);
    Product product3 = new Product(3, "Книга", 250);
    Product product4 = new Product(4, "Яблоки", 50);
    Product product5 = new Product(2, "Ботинки", 5000);

    @Test
    public void shouldRemoveIfExist() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.removeById(3);

        Product[] expected = { product1, product2, product4 };
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveIfNotExist() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(5);
        });
    }

    @Test
    public void shouldAddIfNotRepeatId() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);

        Product[] expected = { product1, product2, product3, product4 };
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddIfRepeatId() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.add(product5);
        });
    }
}
