package inheritance;

class BaseService {
    public int data = 20;
    public void display(BaseService service) {
        System.out.println("In Base");
    }
}

class ChildService extends BaseService {
    public int data = 10;

    ChildService(int data){
        this.data = data;
    }

    public void display(ChildService service) {
        System.out.println("In Child");
    }

}
public class InheritanceExample {
    public static void main(String[] args) {
        BaseService base = new ChildService(50);
        System.out.println(base.data); // 10
        base.display(new ChildService(50)); // In base

        ChildService child = new ChildService(50);
        System.out.println(child.data); // 10
        child.display(new BaseService()); // in base
        child.display(new ChildService(50));

        String s1 = "Test";
        String s2 = "Test";
        String s3 = new String("Test").intern();
        String s4 = new String("Test");
        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // true
        System.out.println(s1 == s4); // false
    }
}