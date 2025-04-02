package array;

/*print the consecutive elements having addition is equal to given
* int  a[] = {12,4,7,2,1,3,8,1,5,34,56,20,-7};
        int  N = 13;
      OP --   7,2,1,3
      *       20,-7
* */
public class ConsecutiveEleAdditionToTarget {

    public static void main(String[] args) {

        int  a[] = {12,4,7,2,1,3,8,1,5,34,56,20,10,-17};
        int  N = 13;

        //4 7 2
        //8 5 = 13
        //7 2 1 3 = 13

        int start = 0;
        int sum = 0;
        int stop = 0;

        String str = "";

        for(int i = start; i < a.length; i++){

            if(start == (a.length-1))
                break;

            sum+=a[i]; // {12,1,7,2,1,3,8,1,5,34,56,20,10,-17};
                          // 12 + 1   = 13
            str = str + " " + a[i];//  12 1

            if(sum == N){ // N - 13
                System.out.println(str); // 12 1
            }
            // 12 == 12
            if(i == a.length-1 || sum==N){
                start++; // 1
                i = start;
                sum = 0;
                str = "";
            }
        }

    }
}


