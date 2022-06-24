package learning.controlFlow;

import java.util.Random;
import java.util.Scanner;

public class ControlFlow {
    public static void main(String[] args) {
//      ControlFlow.guessingGame();
//        printDaysOfTheWeekUsingRegularForLoop2();
        printAllDaysOfTheWeekUsingWhileLoop2();
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
    public static void printDaysOfTheWeekUsingRegularForLoop() {
        String[] daysOfTheWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        for (int i = 0; i < daysOfTheWeek.length; i++) System.out.printf("day: %s%n", daysOfTheWeek[i]);
    }
    public static void printDaysOfWeekUsingEnchancedForLoop() {
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
}
