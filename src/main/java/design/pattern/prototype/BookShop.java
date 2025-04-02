package design.pattern.prototype;

import lombok.Data;

import java.util.*;

@Data
public class BookShop implements Cloneable {

    private String name;
    private List<Book> books = new ArrayList<>();

    public BookShop(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public BookShop() {

    }

    public List<Book> loadBooks() {

        for (int i = 0; i < 10; i++) {
            books.add(new Book(i, "Book" + i, "Author" + i));
        }
        return books;
    }

    @Override
    protected BookShop clone() throws CloneNotSupportedException {
        BookShop shop = new BookShop();
        for (Book b : this.getBooks()) {
            shop.getBooks().add(b);
        }
        return shop;
    }
}
