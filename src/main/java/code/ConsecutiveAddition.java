package code;

public class ConsecutiveAddition {

    public static void main(String[] args) {
        int a[] = {11,7,2,1,3,35,8,1,4,5,9};
        int N = 13;

        //4 7 2
        //8 5 = 13
        //7 2 1 3 = 13

        int start = 0;
        int sum = 0;
        int stop = 0;

        String str = "";

        for (int i = start; i < a.length; i++) {

            if (start == (a.length - 1))
                break;

            sum += a[i];
            str = str + " " + a[i];

            if (sum == N) {
                System.out.println(str);
            }

            if (i == a.length - 1 || sum == N) {
                start++;
                i = start;
                sum = 0;
                str = "";
            }
        }

    }

}
