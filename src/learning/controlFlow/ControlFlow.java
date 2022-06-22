package learning.controlFlow;

import java.util.Random;
import java.util.Scanner;

public class ControlFlow {
    public static void main(String[] args) {
        ControlFlow.guessingGame();
    }

    public static void guessingGame() {
        Random randNum = new Random();
        int num = randNum.nextInt(100) + 1;
        int count = 5;
        System.out.println("** Guess the number between 0 and 100, you have 3 tries to get it right. **");
        System.out.print("Enter your guess: ");
        Scanner sc = new Scanner(System.in);
        int userInput = sc.nextInt();
        if (userInput == num) {
            System.out.println("You guessed correct!");
            return;
        }
        while (userInput != num && count > 0) {
            if (count == 1) System.out.println("** You have one guess left **");

            if (userInput > num) System.out.print("Too high, guess lower: ");
            else System.out.print("Too Low, guess higher: ");

            Scanner sc2 = new Scanner(System.in);
            userInput = sc2.nextInt();
            count--;
        }

        if (userInput == num) {
            System.out.println("You guessed correctly!");
            return;
        }

        System.out.printf("You've used all your guesses, the corect guess is %d", num);
        return;
    }
}
