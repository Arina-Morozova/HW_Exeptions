import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    Product product1 = new Product(1, "Носки", 80);
    Product product2 = new Product(2, "Куртка", 2000);
    Product product3 = new Product(3, "Книга", 250);
    Product product4 = new Product(4, "Яблоки", 50);

    @Test
    public void shouldRemoveIfExist() {
        ShopRepository repo = new ShopRepository();

        Product[] expected = { product1, product2, product4 };
        Product[] actual = repo.removeById(3);

        Assertions.assertArrayEquals(expected, actual);
    }
}
