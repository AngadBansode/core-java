package java17;

public class RecordsInSideMethod {

    public static void main(String[] args) {
        printPoint(10, 20);
    }

    public static void printPoint(int x, int y) {
        // Define a record inside the method
        record Point(int x, int y) {
        }

        // Create an instance of the record
        Point point = new Point(x, y);

        // Use the record
        System.out.println("Point coordinates: " + point.x() + ", " + point.y());
    }
}
