package rmi.string;

import java.util.Arrays;

public class StringSplitSpace {

    public static void main(String[] args) {

        String str = "a,b,c e,f,g i,j,k m,n,o p,q,r";
        //  op:/ "aeim bfjn cgko"
        System.out.println(Arrays.toString(str.split(" ")));
        // [a,b,c, e,f,g, i,j,k, m,n,o]
        StringBuilder result = new StringBuilder();

        String[] arr = str.split(" ");
        System.out.println("Size: " + arr.length);
        String firstEle = arr[0];
        System.out.println("First Ele: " + firstEle);
        System.out.println("First Ele char: " + firstEle.split(",")[2]);
//        int j = arr.length - 1;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j <= arr.length - 1; j++) {
                String[] splitArray = arr[j].split(",");
                if (i >= 0 && i < splitArray.length) {
                    result.append(splitArray[i]);
                } else {
                    // Handle the case where i is out of bounds
                    System.out.println("Index " + i + " is out of bounds for the split array.");
                }
            }

            System.out.println("Result: " + result);

        }
    }
}
