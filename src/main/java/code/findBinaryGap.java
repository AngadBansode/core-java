package code;

public class findBinaryGap {
    static int no = 529;

    public static void main(String[] args) {


        String binary = convertBinary(no);
        System.out.println(binary);
        System.out.println(binaryGap(binary));
    }

    private static int binaryGap(String binary) {
        int cnt = 0;
        int out = Integer.MIN_VALUE;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
            } else {
                out = Math.max(cnt, out);
            }

            return out;
        }
        return out;
    }

    private static String convertBinary(int number) {
        StringBuilder remainder = new StringBuilder();
        while (number > 0) {
            remainder.insert(0, (number % 2));
            number /= 2;
        }
        return remainder.toString();
    }
}
