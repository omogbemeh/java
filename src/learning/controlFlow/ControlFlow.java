package learning.controlFlow;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControlFlow {
    public static void main(String[] args) {
//      ControlFlow.guessingGame();
//        printDaysOfTheWeekUsingRegularForLoop2();
//        printAllDaysOfTheWeekUsingWhileLoop2();
//        printAllDaysOfTheWeekUsingDoWhileLoop();
//        printAllDaysOfTheWeekUsingDoWhileLoop2();
        exercise4Solution();
//        findMatchesInAnAddress();
//        addAllLettersOfDaysOfTheWeek();
//        String city = capitalizeWords("first city");
//        System.out.printf("'%s'", city);
    }


    public static void guessingGame() {
        Random randNum = new Random();
        int num = randNum.nextInt(10) + 1;
        int count = 2;
        System.out.println("** Guess the number between 1 and 10, you have 3 tries to get it right. **");
        System.out.print("Enter your guess: ");
        Scanner sc = new Scanner(System.in);
        int userInput = sc.nextInt();

        while (userInput != num && count > 0) {
            if (count == 1) System.out.println("** You have one guess left **");

            if (userInput > num) System.out.print("Too high, guess lower: ");
            else System.out.print("Too Low, guess higher: ");

            Scanner sc2 = new Scanner(System.in);
            userInput = sc2.nextInt();
            count--;
        }

        if (userInput == num) {
            System.out.printf("** You guessed \"%d\" correctly ! **", num);
            return;
        }

        System.out.printf("You've used all your guesses, the correct guess is %d", num);
        return;
    }

/////////////    Solution to Exercises
public static void findMatchesInAnAddress() {
    String address = """ 
                12345 First Street, First City, AA 90210
                22222 Second Street, Second City, BB 22222
                33333 Third Street, Third City, CC 33333
                44444 Fourth Street, Fourth City, DD 44444
                55555 Fifth Street, Fifth City, EE 55555
                66666 Sixth Street, Sixth City, FF 66666
                77777 Seventh Street, Seventh City, GG 77777
                88888 Eighth Street, Eighth City, HH 88888
                99999 Ninth Street, Ninth City, II 99999
                00000 Tenth Street, Tenth City, JJ 00000
                """.strip();
    String regex = "(?<streetNum>\\d{5})\\s*(?<streetName>\\w+\\s*\\w+),\\s*(?<cityName>\\w+\\s*\\w+),\\s*(?<province>[A-Z]{2})\\s*(?<zipCode>\\d{5})";
    Pattern pat = Pattern.compile(regex);
    Matcher mat = pat.matcher(address);
    String template = """
            ********************
            Street Number: %s
            Street Name: %s
            City: %s
            Province: %s
            Zip Code: %s
            ********************
            """;
    while (mat.find()) {
        System.out.printf(template, mat.group("streetNum"), mat.group("streetName"), mat.group("cityName"), mat.group("province"), mat.group("zipCode"));
    }
}
    public static void printDaysOfTheWeekUsingRegularForLoop() {
        String[] daysOfTheWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        for (int i = 0; i < daysOfTheWeek.length; i++) System.out.printf("day: %s%n", daysOfTheWeek[i]);
    }
    public static void printDaysOfWeekUsingEnhancedForLoop() {
        String[] daysOfTheWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        for (String day : daysOfTheWeek) {
            System.out.printf("day: %s%n", day);
        }
    }

//    Capitalizes every other line.
    public static void printDaysOfTheWeekUsingRegularForLoop2() {
        String[] daysOfTheWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        for (int i = 0; i < daysOfTheWeek.length; i++) {
            if (i % 2 != 0) System.out.printf("day: %s%n", daysOfTheWeek[i].toUpperCase());
            else System.out.printf("day: %s%n", daysOfTheWeek[i]);
        };
    }

    public static void printAllDaysOfTheWeekUsingWhileLoop() {
        String[] daysOfTheWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int count = daysOfTheWeek.length;
        while (count > 0) {
            System.out.printf("day: %s%n", daysOfTheWeek[7 - count]);
            count--;
        }
    }public static void printAllDaysOfTheWeekUsingWhileLoop2() {
        String[] daysOfTheWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int count = daysOfTheWeek.length;
        while (count > 0) {
            int day = 7 - count;
            System.out.printf("day: %s%n", day % 2 == 0 ? daysOfTheWeek[day] : daysOfTheWeek[day].toUpperCase());
            count--;
        }
    }

    public static void printAllDaysOfTheWeekUsingDoWhileLoop() {
        String[] daysOfTheWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int COUNT = 7;
        int count = daysOfTheWeek.length;
        do {
            System.out.printf("days: %s%n", daysOfTheWeek[COUNT - count]);
            count--;
        } while (count > 0);
    }

    public static void printAllDaysOfTheWeekUsingDoWhileLoop2() {
        String[] daysOfTheWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int COUNT = 7;
        int count = daysOfTheWeek.length;
        do {
            int day = COUNT - count;
            System.out.printf("days: %s%n", day % 2 == 0 ? daysOfTheWeek[day] : daysOfTheWeek[day].toUpperCase());
            count--;
        } while (count > 0);
    }

    private static String capitalizeWords(String word) {
        String[] words = word.split(" ");
        StringBuilder finalStr = new StringBuilder();
        for (String str : words) {
            finalStr.append(str.substring(0,1).toUpperCase()).append(str.substring(1).toLowerCase()).append(" ");
        }
        return finalStr.toString().strip();
    }
    public static void exercise4Solution() {
        String[] daysOfTheWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        String[] foodEatenOnEachDay = {"pot roast", "spaghetti", "tacos", "chicken", "meatloaf", "hamburgers", "pizza"};

        for (int i = 0; i < daysOfTheWeek.length; i++) {
            System.out.printf("We eat %s on %s%n", capitalizeWords(foodEatenOnEachDay[i]), daysOfTheWeek[i]);
        }
    }

    public static void  exercise5Solution() {
        String[] daysOfTheWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        String[] foodEatenOnEachDay = {"roast", "spaghetti", "tacos", "chicken", "meatloaf", "hamburgers", "pizza"};

    }

    public static void addAllLettersOfDaysOfTheWeek() {
        String[] daysOfTheWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int sum = 0;
        for (String day : daysOfTheWeek) sum += day.length();
        System.out.println(sum);
    }

}
