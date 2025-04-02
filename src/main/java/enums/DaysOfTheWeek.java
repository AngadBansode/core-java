package enums;

import java.util.Arrays;

public enum DaysOfTheWeek {
    SUNDAY(0,12),
    MONDAY(1, 15),
    TUESDAY(2, 20),
    THURSDAY(3, 25),
    FRIDAY(4, 30),
    SATURDAY(5, 35);

   final int dayNumber;
    final int dayValue;

    DaysOfTheWeek(int dayNumber, int dayValue ) {
        this.dayNumber = dayNumber;
        this.dayValue = dayValue;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class EnumDemo{
    public static void main(String[] args) {

        var monday = DaysOfTheWeek.MONDAY.dayValue  ;


        System.out.println(monday);
        System.out.println(Arrays.toString(DaysOfTheWeek.values()))  ;
    }
}
