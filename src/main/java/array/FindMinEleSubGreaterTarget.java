package array;

/*Array--
        unsorted array
        int arr [] = {12 ,2,11,45,65, 4, 10};
        find the min elemts (sub-array) whose sum is greater than given no
        int given = 90;
        return count of elements
        output -- 2*/
public class FindMinEleSubGreaterTarget {

    public static void main(String[] args) {
        int arr[] = {23, 9, 17, 70, 5, 78, 7, 30, 30, 70};
//        int arr [] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
        int target = 90;
        int countElement = findTheMinEle(arr, target);
        System.out.println(countElement);
    }

    private static int findTheMinEle(int[] arr, int target) {
        int sum = 0;
        int cnt = -1;
        int temp = 0;
        int finalCnt = 0;
        boolean firstCheck = true;
        for (int i = 0; i < arr.length; i++) {
            cnt++;
            if (arr[i] >= target) {
                return 1;
            } else {
                sum = sum + arr[i];
                if (sum >= target) {
                    sum = 0;
                    if (firstCheck) {
                        firstCheck = false;
                        finalCnt = cnt;
                    }
                    finalCnt = Math.min(finalCnt, cnt);
                    cnt = -1;

                }
            }
//            finalCnt = Math.min(cnt, i);
        }
        int actualCnt = 0;
        for (int j = finalCnt; j > 0; j--) {
            actualCnt++;
            temp = temp + arr[j];
            if (temp >= target) {
                return actualCnt;
            }
        }
        return actualCnt;
    }
}
