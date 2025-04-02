package code;

public class Main {

    public static void main(String[] args) {
       /* UserRecord userRecord = new UserRecord("Angad", "Bansode");
        System.out.println(userRecord.firstName());
         int in = 529;
        String bin = "";
        while (in > 0) {
            bin += "" + (in % 2); // 1000100001
            in = in / 2; // 264 /2 = 132, 132/2 = 66 , 66/2 = 33 , 33/2 = 16, 16/2 = 8, 4, 2 1,
        }
        System.out.println("Binary:"+"\t" + bin );*/

        String str = "Welcome";
        System.out.println(checkString(str));


    }

    private static String checkString(String str) {
        return str.length() > 10 ? "10" :  str.length() < 10 ? "20" : "50";

    }
}
