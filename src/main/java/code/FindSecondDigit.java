package code;

// find 2nd digit which is 1 from given array
public class FindSecondDigit {
    public static void main(String[] args) {

        int arr[] = {121, 4411, 213, 4411, 123, 110, 41139, 21331};

        for (int i = 0; i < arr.length; i++) {
            int secondNumber = 0;
            int n = arr[i];
            while (n > 10 ) {
                secondNumber = n % 10  ;
                n /= 10 ;
            }
            if (secondNumber == 1)
                System.out.println(arr[i]);
        }
    }
}
