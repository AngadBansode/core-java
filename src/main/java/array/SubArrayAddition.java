package array;

// arr_1 = [0, 4, -1, 0, 5 ]
// arr_2 = [0, 4, 5, 0, -1 ]
/*Do the addition of sub-array from both array and check addition
should be same if same then print the indexes of those elements.
ex - arr1 - 0,4 | -1, 0, 3 == 4
ex -  arr2 - 0, 4 | 5 0 -1 == 4
index - 1*/

public class SubArrayAddition {

    public static void main(String[] args) {
        int A[] = {0, 4, -1, 0, 3};
        int B[] = {0, -2, 5, 0, 3};

        int index = findIndexOfSubArrayAdditionSame(A, B);
        System.out.println(index - 1);
    }

    private static int findIndexOfSubArrayAdditionSame(int[] A, int[] B) {
        int j = 2;
        int addCnt = 0;
        int arrA_1 = 0;
        int arrB_1 = 0;
        int arrA_2 = 0;
        int arrB_2 = 0;

        if (j < A.length - 1)
            for (int i = 0; i < j; i++) {
                for (int m = 0; m < j - 1; m++) {
                    arrA_1 = arrA_1 + A[m];
                    arrB_1 = arrB_1 + B[m];
                }
                if (arrA_1 == arrB_1) {
                    for (int k = j; k < A.length; k++) {
                        arrA_2 = arrA_2 + A[k];
                        arrB_2 = arrB_2 + B[k];
                    }
                    if (arrA_1 == arrB_2)
                        addCnt++;
                    else {
                        i = -1;
                        j = j + 1;
                        arrA_1 = 0;
                        arrA_2 = 0;
                        arrB_2 = 0;
                        arrB_1 = 0;
                    }
                } else {
                    i = -1;
                    j = j + 1;
                    arrA_1 = 0;
                    arrA_2 = 0;
                    arrB_2 = 0;
                    arrB_1 = 0;
                }
            }
        return addCnt;
    }

}
