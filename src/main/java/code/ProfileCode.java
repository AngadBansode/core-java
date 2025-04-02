package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfileCode {


        public static void main(String[] args)
        {
            String input = "PQR";
            List<String > result = new ArrayList<>();
            findAllCombinations ("",input,result);
            System.out.println(result);
        }

        private static void findAllCombinations(String prefix, String remaining, List<String> result) {
            int n = remaining.length();
            if (n==0)
            {
                result.add(prefix);
            }
            else
            {
                for  (int i =0; i <n; i++)
                {
                    findAllCombinations(prefix+ remaining.charAt(i), remaining.substring(0,i)+
                            remaining.substring(i+1),result);
                }
            }
        }
  // check number is even or odd
    public static String checkNumber(int number)
    {
        return number % 2 == 0 ? "Even" : "Odd";
    }

    // check number is prime or not
    public static String checkPrime(int number)
    {
        if (number <= 1)
        {
            return "Not Prime";
        }
        for (int i = 2; i < number; i++)
        {
            if (number % i == 0)
            {
                return "Not Prime";
            }
        }
        return "Prime";
    }

    // check number is palindrome or not
    public static String checkPalindrome(int number)
    {
        int r, sum = 0, temp;
        temp = number;
        while (number > 0)
        {
            r = number % 10;
            sum = (sum * 10) + r;
            number = number / 10;
        }
        return temp == sum ? "Palindrome" : "Not Palindrome";
    }

    // check number is Armstrong or not
    public static String checkArmstrong(int number)
    {
        int c = 0, a, temp;
        temp = number;
        while (number > 0)
        {
            a = number % 10;
            number = number / 10;
            c = c + (a * a * a);
        }
        return temp == c ? "Armstrong" : "Not Armstrong";
    }

    // check number is perfect or not
    public static String checkPerfect(int number)
    {
        int sum = 0;
        for (int i = 1; i < number; i++)
        {
            if (number % i == 0)
            {
                sum = sum + i;
            }
        }
        return sum == number ? "Perfect" : "Not Perfect";
    }

    // check number is positive or negative
    public static String checkPositive(int number)
    {
        return number > 0 ? "Positive" : "Negative";
    }

    // check number is zero or not
    public static String checkZero(int number)
    {
        return number == 0 ? "Zero" : "Not Zero";
    }

    // check number is divisible by 5 or not
    public static String checkDivisibleBy5(int number) {
        return number % 5 == 0 ? "Divisible by 5;" : "Not Divisible by 5";
    }
    //create map with some entries and print the map
    public static void createMap()
    {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        System.out.println(map);
        map.forEach((key, value) -> System.out.println(key + ":" + value));

    }

}
