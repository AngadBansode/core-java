package rmi.string;

public class StringLength {
    public static void main(String[] args) {
        String str = "abcd";
        int length = 0;
        try {
            while (true) {
                str.charAt(++length);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Length of the string: " + (length));
        }
    }
}
