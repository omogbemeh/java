package learning.OOPexercises;

import java.util.Random;

public enum TheDaysOfTheWeek {
    SUNDAY("sunday"),
    MONDAY("monday"),
    TUESDAY("tuesday"),
    WEDNESDAY("wednesday"),
    THURSDAY("thursday"),
    FRIDAY("friday"),
    SATURDAY("saturday");

    private final String value;
    public static final TheDaysOfTheWeek[] daysArr = values();

    TheDaysOfTheWeek(String value) {
        this.value = value;
    }

    public static void printDaysCapitalized() {
        for (TheDaysOfTheWeek day : daysArr) {
            String firstLetterInCaps = day.value.substring(0, 1).toUpperCase();
            String remainingLetters = day.value.substring(1).toLowerCase();
            System.out.println(firstLetterInCaps + remainingLetters);
        }
    }

    public static void printDaysCapitalized2() {
        String dayStr;
        String firstHalf;
        String middleStr;
        String finalStr;

        for (TheDaysOfTheWeek day : daysArr) {
            dayStr = day.value;
            int middle = dayStr.length() / 2;
            firstHalf = dayStr.substring(0, middle).toLowerCase();
            middleStr = dayStr.substring(middle, middle + 1).toUpperCase();
            finalStr = dayStr.substring(middle + 1).toLowerCase();
            System.out.println(firstHalf + middleStr + finalStr);
        }
    }

    public static void printTenRandomDays() {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int randNum = rand.nextInt(values().length);
            System.out.println(values()[randNum]);
        }
    }
}
