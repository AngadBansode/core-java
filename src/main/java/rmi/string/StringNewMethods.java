package rmi.string;

import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

public class StringNewMethods {

    public static void main(String[] args) {

        //1. describeConstable
        String str = "hello";
        System.out.println(str.describeConstable().orElse("No value")); // Output: "hello"

        String str2 = StringUtils.EMPTY;
        System.out.println(str2.describeConstable().orElse("No value")); // Output: "hello"

       // 3.
        String str3 = null;
        System.out.println(Optional.ofNullable(str3).orElse("No value"));
        // Output: "No value"

    }
}
