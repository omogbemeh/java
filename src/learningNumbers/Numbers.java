package learningNumbers;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Random;

public class Numbers {
    public static void main(String[] args) {
//        System.out.println(calcCentrifugalForce(3.0, 0.2, 0.8));
        System.out.println(calcCompoundInterest("10000", ".08", "10", "1000"));
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
    public static BigDecimal calcCompoundInterest(String p, String r, String y, String con) {
        BigDecimal principal = new BigDecimal(p);
        BigDecimal rate = new BigDecimal(r);
        BigDecimal contribution = new BigDecimal(con);
        BigDecimal year = new BigDecimal(y);
        BigDecimal common = (rate.add(BigDecimal.ONE)).pow(year.intValue());
        BigDecimal firstPart = principal.multiply(common);
        BigDecimal secondPart = (common.subtract(BigDecimal.ONE)).divide(rate);
        BigDecimal finalSecondPart = contribution.multiply(secondPart);
        return firstPart.add(finalSecondPart).round(new MathContext(5, RoundingMode.HALF_UP));
    }
}
