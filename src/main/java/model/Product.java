package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product implements Comparable<Product>{

    private String id;

    private String category;

    private double price;


    @Override
    public int compareTo(Product o) {
        return (int) (this.price - o.getPrice());
    }
}
