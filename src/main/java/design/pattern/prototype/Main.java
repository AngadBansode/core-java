package design.pattern.prototype;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        BookShop bs1 = new BookShop();
         bs1.setName("Sai BookShop");
         bs1.setBooks(bs1.loadBooks());


        BookShop bs2 = (BookShop) bs1.clone();
         bs2.setName("Vikas BookShop");

        bs1.getBooks().remove(2);
        System.out.println(bs1);
        System.out.println(bs2);


    }
}
