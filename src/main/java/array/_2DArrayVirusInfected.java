package array;

/*write the program to check how many mintues will take to infect the whole system
0 means empty sell, 1 means non virus, 2 means virus infected
input will be m*n array in java*/

public class _2DArrayVirusInfected {

    public static void main(String[] args) {
        int[][] arr = {
                {2, 2, 1},
                {2, 2, 1},
                {2, 2, 1}
        };
        checkSystemInfectedInMinutes(arr);
    }

    private static void checkSystemInfectedInMinutes(int[][] arr) {
        // 0 - empty sell
        // 1- non virus
        //2 - virus infected
        int virusCount = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 2) {
                    virusCount++;
                }

            }
        }
        System.out.println(virusCount);
    }
}
