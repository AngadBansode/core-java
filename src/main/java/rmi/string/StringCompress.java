package rmi.string;

public class StringCompress {

    public static void main(String[] args) {

        String str = "aaabbcccddd"; // a3bbc3d
        compressString(str);
    }

    private static void compressString(String str) {
        int cnt = 1;
        StringBuilder resultString = new StringBuilder();
        for (int i = 0; i < str.length() - 1; i++) {

            if (str.charAt(i) == str.charAt(i + 1)) {
                cnt++;
            } else {
                if (cnt >= 3)
                    resultString.append(str.charAt(i)).append(cnt);
                else {
                    resultString.append(String.valueOf(str.charAt(i)).repeat(cnt));
                }
                cnt = 1;
            }
        }
        if (cnt > 2)
            resultString.append(str.charAt(str.length() - 1)).append(cnt);
        else
            resultString.append(String.valueOf(str.charAt(str.length() - 1)).repeat(cnt));
        System.out.println(resultString);
    }
}
