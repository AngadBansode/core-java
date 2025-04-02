package reflection;

public class Cat {

    private final String name;
    private final int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    private void catSound() {
        System.out.println("Meow");
    }

    private static void privateStaticMethod(String name) {
        System.out.println("privateStaticMethod: " + name);
    }

}
