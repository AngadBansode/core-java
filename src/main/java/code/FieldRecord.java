package code;

import java.util.List;

public class FieldRecord {
    List<String> strings;
    List<String> strings1;
    public FieldRecord(List<String> strings, List<String> strings1) {
        this.strings = strings;
        this.strings1 = strings1;
    }

    @Override
    public String toString() {
        System.out.println("1"+strings);
        System.out.println("2"+strings1);

        return null;
    }
}

