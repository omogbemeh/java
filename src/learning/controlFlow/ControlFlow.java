package learning.controlFlow;

import java.util.Random;
import java.util.Scanner;

public class ControlFlow {
    public static void main(String[] args) {
        int test = 5;
        switch (test) {
            case 3:
                System.out.println("This is 3 speaking");
                break;
            case 5:
                System.out.println("This is 5 speaking");
                break;
            default:
                System.out.println("No one's talking");
                break;
        }
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

}
