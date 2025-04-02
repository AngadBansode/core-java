package streams;

public class PredicateImpl implements PredicateDemo<String>{

    @Override
  public boolean test(String val){
      return true;
  }

    public static void main(String[] args) {
        PredicateImpl impl  = new PredicateImpl();
        System.out.println(impl.test(null));
    }

}
