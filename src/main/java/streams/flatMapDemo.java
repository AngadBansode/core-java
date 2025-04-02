package streams;

import code.UserRecord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// find whose mobileno is 9545
public class flatMapDemo {
    public static void main(String[] args) {

        List<User> userRecord = new ArrayList<>();
        userRecord.add(new User("Sachin", Arrays.asList(123, 456, 9545)));
        userRecord.add(new User("Raj", Arrays.asList(123, 456, 954225)));


        var integerList = userRecord.stream()
                .filter(user -> {
                    var integerStream = user.mobileNumbers().stream().filter(match -> match == 9545);
                    return integerStream.findAny().isPresent();
                }).map(User::name).findFirst();


//        integerList.ifPresent(System.out::println);

        var integerLongMap = userRecord.stream().flatMap(nos -> nos.mobileNumbers().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(integerLongMap);

    }


}
