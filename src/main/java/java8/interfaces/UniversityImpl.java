package java8.interfaces;

public class UniversityImpl implements University<String, String> {

    @Override
    public String getName(String s) {
        return s + " " + "University";
    }

    public static void main(String[] args) {
        University<String, String> university = new UniversityImpl();

        System.out.println(university.getName("Batu"));

    }
}
