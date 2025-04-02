package Collection;

import java.util.Collections;
import java.util.List;

//Collectio.disJoint(collection1,colllection2)
//check common ele or not , if no common ele - true else false
public class DisJointDemo {

    public static void main(String[] args) {
        List l1  = List.of(1,2,3,4,5);
        List l2  = List.of(6,7,8,9,10,1);

        System.out.println(Collections.disjoint(l1,l2));
    }
}
