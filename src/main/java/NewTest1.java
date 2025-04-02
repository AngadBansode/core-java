// find the min no in sorted rotated array
  // [ 5 6 1 2 3 4 ] -- d  = 2
 /*
       l =0 , h = 5;
       m = 3;
       arr1 - [5 6 1]
       arr2 - [2 3 4]
        l = 0;
        h = 2
        m = 1;
        arr1 = [5]
        arr2 = [6,1] - unsorted
        l =


    public static void main(String[] args) {
        int [] arr = {5,6,1,2,3,4}; // if(arr[mid-1] > arr[mid] && if(arr[mid+1] < arr[mid]))
        int left = 0;
        int right = arr.length-1;

        while(left < right){
            int mid = (left + right ) / 2;

            if(arr[mid] > arr[arr.length-1]){
                 left++;
            } else if (arr[mid] < arr[arr.length-1]) {

            }
            }
        }

    }
}
 */

