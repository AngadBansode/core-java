package code;

public class BinaryGap {
    public static void main(String[] args) {

        System.out.println(maxGap(32));
    }

    public static int maxGap(int in) {
        String bin = "";
        while (in > 0) {
            bin += "" + (in % 2);
            in = in / 2;
        }
        System.out.println(bin);
        int out = Integer.MIN_VALUE;
        int temp = 0;
        for (int i = 1; i < bin.length(); i++) {
            if (bin.charAt(i) == '0') {
                temp += 1;
            } else {
                out = Math.max(temp, out);
                temp = 0;
            }
        }

        return out;


    }
}
