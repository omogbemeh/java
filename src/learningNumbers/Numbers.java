package learningNumbers;

import java.util.Random;

public class Numbers {
    public static void main(String[] args) {
        System.out.println(calcCentrifugalForce(3.0, 0.2, 0.8));
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
}
