package learning.OOPexercises;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OOP {
    public static void main(String[] args) {
//        TheDaysOfTheWeek.printDaysCapitalized();
//        TheDaysOfTheWeek.printDaysCapitalized2();
//        TheDaysOfTheWeek.printTenRandomDays();
//        printDaysAndFood();
//        System.out.println(findReverseAlphabetOrdinalPosition(1));
//        System.out.println(compareStrings("2->6"));
        System.out.println(getChessPieceCoordinate("g5"));
    }

    public static void printDaysAndFood() {
        String[] foodArr = {"pot roast", "spaghetti", "tacos", "chicken", "meatloaf", "hamburgers", "pizza"};
        for (int i = 0; i < TheDaysOfTheWeek.daysArr.length; i++) {
            System.out.printf("We eat %s on %s%n", foodArr[i], TheDaysOfTheWeek.daysArr[i]);
        }
    }

    public static int findAlphabetOrdinalPosition(char c) {
        int a = 'a';
        if (c < 'a' || c > 'z') return -1;
        return (c - a) + 1;
    }

    public static String findReverseAlphabetOrdinalPosition(int num) {
        if (num < 1 || num > 26) return " ";
        char res = (char) ('a' + num - 1);
        return Character.toString(res);
    }

    public static boolean compareStrings(String str) {
        String[] numsArr = str.split("->");
        int num1 = Integer.parseInt(numsArr[0]);
        int num2 = Integer.parseInt(numsArr[1]);
        return num1 > num2;
    }

    public static String getChessPieceCoordinate(String notation) {
        String[][] board = new String[8][8];
        Pattern pat = Pattern.compile("(?<letter>[a-h])(?<number>[1-8])");
        Matcher mat = pat.matcher(notation);
        if (mat.find()) {
            String lett = mat.group("letter");
            String num = mat.group("number");
            int idx1 = lett.charAt(0) - 'a';
            int idx2 = 8 - Integer.parseInt(num);
            return (idx1 + "," + idx2);
        }
        return "Invalid input";
    }
}
