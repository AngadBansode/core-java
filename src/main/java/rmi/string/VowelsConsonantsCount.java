package rmi.string;
// count of vowels and consonants in a string
public class VowelsConsonantsCount {

    public static void main(String[] args) {

        String input = "Abhishek";
        int inputLength = input.length();
        String vowels = "AEIOUaeiou";

       var vowelsCount= input.chars()
                .filter(c -> vowels.indexOf(c) != -1)
                .count();

        System.out.println("Vowels Count: " + vowelsCount);
        System.out.println("Consonants Len: " + (inputLength-vowelsCount));


    }

}
