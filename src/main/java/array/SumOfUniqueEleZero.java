package array;

import java.util.Arrays;

/*Write a program, given an integer N (1 ≤ N ≤ 100), returns an array containing N unique integers that sum up to 0. The function can return any such array
        Example: Input: N = 4,  Output: [3, 8, -6,  -5]*/
public class SumOfUniqueEleZero {
    public static void main(String[] args) {

        int N =5;
        int[] result = generateArray(N);
        System.out.println(Arrays.toString(result));

    }

    public static int[] generateArray(int N){
        int[] array = new int[N];
        int sum = 0;
        for(int i = 0; i<N -1; i++){
            int randomNumber = ( int )(Math.random() * 100)+1;
            array[i] = randomNumber;
            sum+= randomNumber;
        }
        array[N -1] = -sum;
        return array;

    }
}