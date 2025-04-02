package streams;

import model.Product;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ProductByPriceASC {

    public static void main(String[] args) {
    List<Product> products = Arrays.asList( new Product("1", "Books", 100.0),
            new Product("2", "Electronics", 200.0),
            new Product("3", "Books", 300.0),
            new Product("4", "Books", 200.0),
            new Product("5", null, 300.0));

        var id = products.stream()
                .filter(book -> "Books".equals(book.getCategory()))
                .sorted(Comparator.comparing(Product::getPrice))
                .map(Product::getId)
                .findFirst()
                .orElse(Optional.empty().toString());
        System.out.println(id);

    }
}
