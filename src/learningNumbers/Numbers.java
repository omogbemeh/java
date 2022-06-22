package learningNumbers;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) throws ParseException {
//        System.out.println(calcCentrifugalForce(3.0, 0.2, 0.8));
//        System.out.println(calcCompoundInterest("10000", ".08", "10", "1000"));
//        decimalFormatter();
//        System.out.printf("%,(.2f%n", 9989878787600.00);
//        String amountInCAD = convertStringToCurrency("356.678");
//        System.out.println(amountInCAD);
        BigDecimal answer = divideTwoNumbers("$12,345.83", "32.19");
        System.out.println(answer);
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
}
