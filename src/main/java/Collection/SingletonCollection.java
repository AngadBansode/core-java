package Collection;

import java.util.Collections;
import java.util.Set;

// Collections.singleton() - return immutable singleton set
public class SingletonCollection {

    public static void main(String[] args) {
        var singletonSet = Collections.singleton(1);
        try {
            singletonSet.add(12);
        } catch (Exception e) {
            System.out.println("trying to modify immutable set: " + e.getLocalizedMessage());
        }
    }
}
