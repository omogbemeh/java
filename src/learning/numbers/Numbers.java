package learning.numbers;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Random;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) throws ParseException {
        addRandomNumbers();
    }

    /**
     * This method calculates the area of a circle
     * It uses Area = PI * radius^2.
     * @param radius
     * @return
     */
    public static float calcAreaOfCircle(float radius) {
        return (float) Math.round((Math.pow(radius, 2) * Math.PI));
    };

    /**
     * Calculates centripetal force.
     * @param time measured in seconds
     * @param mass measured in kg
     * @param radius measured in meters
     * @return
     */
    public static double calcCentrifugalForce(double time, double mass, double radius) {
        double pathVelocity = calcPathVelocity(radius, time);
        double centripetalAcceleration = calcCentripetalAcceleration(pathVelocity, radius);
        return mass * centripetalAcceleration;
    }

    public static double calcPathVelocity(double radius, double time) {
        return (2 * Math.PI * radius) / time;
    }

    public static double calcCentripetalAcceleration(double pathVelocity, double radius) {
        return (Math.pow(pathVelocity, 2)) / radius;
    }

    /**
     * Calculates compound interest using P(1 + r)^y + c[ ((1 + r)^y- 1)/r]
     * @param p principal or initial capital
     * @param r interest rate
     * @param con annual contribution
     * @param y number of years.
     * @return
     */
    public static String calcCompoundInterest(String p, String r, String y, String con) {
        BigDecimal principal = new BigDecimal(p);
        BigDecimal rate = new BigDecimal(r);
        BigDecimal contribution = new BigDecimal(con);
        BigDecimal year = new BigDecimal(y);
        BigDecimal common = (rate.add(BigDecimal.ONE)).pow(year.intValue());
        BigDecimal firstPart = principal.multiply(common);
        BigDecimal secondPart = (common.subtract(BigDecimal.ONE)).divide(rate);
        BigDecimal finalSecondPart = contribution.multiply(secondPart);
        BigDecimal amount = firstPart.add(finalSecondPart).round(new MathContext(5, RoundingMode.HALF_UP));
        return moneyFormatter(amount);
    }

    public static String moneyFormatter (BigDecimal amount) {
        NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();
        return moneyFormatter.format(amount);
    }

    public static void decimalFormatter () {
        DecimalFormat df = new DecimalFormat("$#,###.00");
        DecimalFormat pf = new DecimalFormat("#%");
        System.out.println(df.format(3452313.27382738732));
        System.out.println(pf.format(.08));
    }

    public static void calculateFutureAge() {
        System.out.print("Enter your age: ");
        Scanner sc = new Scanner(System.in);
        String ageString = sc.nextLine();
        int ageIn5Years = Integer.parseInt(ageString);
        System.out.printf("You will be %d in 5 years", ageIn5Years + 5);
    }

    /**
     * This function takes a string and converts it to CAD.
     * @param str the amount as a String
     * @return the amount in CAD as a string
     */
    public static String convertStringToCurrency (String str) {
        double amountAsInt = Double.parseDouble(str);
        NumberFormat amountInCAD = NumberFormat.getCurrencyInstance();
        return amountInCAD.format(amountAsInt);
    }


    public static int addRandomNumbers() {
        Random rand = new Random();
        int numb = rand.nextInt(10);
        System.out.println(numb);
        return 2;
    }

    /**
     * Takes 2 numbers and divides them
     * @param num1 The number to be divided as a String
     * @param num2 The divisor
     */
    public static BigDecimal divideTwoNumbers(String num1, String num2) throws ParseException {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        String currency = nf.parse(num1).toString();
        BigDecimal number1 = new BigDecimal(currency);
        BigDecimal number2 = new BigDecimal(num2);
        return number1.divide(number2, new MathContext(5));
    }

    /**
     * Solution to question 8 in the numbers section of exercise.
     */
    public static void formatNumbers() {
        System.out.printf("$%,.2f%n", 123456.783);
        System.out.printf("%(,.3f%n", -9876.32532);
        System.out.printf("%f%n", 23.19283928394829182);
        System.out.printf("%010d%n", 123456);
        System.out.printf("%,.1f%n", -9876.35532);
    }

    /**
     * Solution to question 9 in the numbers section of exercise.
     */
    public static void formatNumbersAndStoreInString() {
        String str1 = String.format("$%,.2f", 123456.783);
        String str2 = String.format("%(,.3f", -9876.32532);
        String str3 = String.format("%f", 23.19283928394829182);
        String str4 = String.format("%010d", 123456);
        String str5 = String.format("%,.1f", -9876.35532);
    }

    /**
     * Solution to question 10 in the numbers section of exercise.
     */
    public static void formatNumbersWithDecimalFormat() {
        String str1 = new DecimalFormat("$#,###.##").format(123456.783);
        String str2 = new DecimalFormat("#,###.###;(#,###.##)").format(-9876.32532);
        String str3 = new DecimalFormat("0000000000").format(123456);
        String str4 = new DecimalFormat("#,###.#").format(-9876.35532);
    }

    /**
     * Solution to question 11 in the numbers section of exercise.
     */
    public static int addInts (String str1, String str2) {
        int num1 = Integer.parseInt(str1);
        int num2 = Integer.parseInt(str2);
        return num1 + num2;
    }
}
