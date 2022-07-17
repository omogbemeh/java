package learning.streams;

import learning.collections.cars.Car;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class MyStreams {

    private static String finalStr = "";

    public static void main(String[] args) {
//      readFile();
        printCars();
    }

    public static void addStr(String r) {
        if (finalStr.length() < 1) {
            finalStr += r;
        } else finalStr += "-" + r;
    }

    public static void readFile() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();

        try {
            long startTime = System.currentTimeMillis();
            long sum = Files.lines(Path.of("/Users/praise/Downloads/Hr5m.csv"))
                    .parallel()
                    .skip(1)
                    .map(Employee::createEmployee)
                    .mapToLong(Employee::getSalary)
                    .sum();
            long endTime = System.currentTimeMillis();

            System.out.printf("The total sum is %s%n", nf.format(sum));
            System.out.printf("The operation took %d milliseconds", endTime - startTime);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void printCars() {
        Car car1 = new Car("audi", "s5", new BigDecimal("35000"), LocalDate.of(2017, Month.JUNE, 1));
        Car car2 = new Car("audi", "rs5", new BigDecimal("70000"), LocalDate.of(2017, Month.JUNE, 1));
        Car car3 = new Car("mercedes", "c43", new BigDecimal("38000"), LocalDate.of(2017, Month.APRIL, 1));
        Car car4 = new Car("mercedes", "c63", new BigDecimal("55000"), LocalDate.of(2017, Month.MAY, 2));

        List<Car> cars = Arrays.asList(car1, car2, car3, car4);

//        OptionalDouble average = cars.stream();


//        OptionalDouble totalPriceOfCars = OptionalDouble.of(average.orElse(0.0));

//        System.out.println(totalPriceOfCars.getAsDouble());

//        Stream.of(car1, car2, car3, car4);

    }
}
