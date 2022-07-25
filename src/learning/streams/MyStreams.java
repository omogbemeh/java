package learning.streams;

import learning.collections.cars.Car;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyStreams {

    public static void main(String[] args) {
//      readFile();
//        readCarsCsv();
        findAverage();
    }

    private static String finalStr = "";

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
        Car car6 = new Car("zudi", "s5", new BigDecimal("35000"), LocalDate.of(2017, Month.JUNE, 1));
        Car car2 = new Car("audi", "rs5", new BigDecimal("70000"), LocalDate.of(2017, Month.JUNE, 1));
        Car car3 = new Car("mercedes", "c43", new BigDecimal("38000"), LocalDate.of(2017, Month.APRIL, 1));
        Car car4 = new Car("mercedes", "c63", new BigDecimal("55000"), LocalDate.of(2017, Month.MAY, 2));

        List<Car> cars = Arrays.asList(car1, car2, car3, car4, car6);

        cars.stream()
                .sorted(Comparator.comparing(Car::getMake).thenComparing(Car::getModel).thenComparing(Car::getYear))
                .forEach(System.out::println);

//        OptionalDouble average = cars.stream();

//        OptionalDouble totalPriceOfCars = OptionalDouble.of(average.orElse(0.0));

//        System.out.println(totalPriceOfCars.getAsDouble());

//        Stream.of(car1, car2, car3, car4);

    }


    public static void readCarsCsv() {
        NumberFormat df = DecimalFormat.getCurrencyInstance();

        try {
            Map<String, BigDecimal> carsToSum = Files.lines(Path.of("/Users/praise/Desktop/carsCsv.csv"))
                    .skip(1)
                    .map(s -> s.split(","))
                    .map(s -> {
                        try {
                            return new Car(s[0], s[1], new BigDecimal(df.parse(s[3]).toString()), LocalDate.of(Integer.parseInt(s[2]), Month.APRIL, 1));
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .collect(Collectors.groupingBy(Car::getMake, Collectors.reducing(BigDecimal.ZERO, Car::getPrice, BigDecimal::add)));

            System.out.println(carsToSum);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void findAverage() {
        NumberFormat df = DecimalFormat.getCurrencyInstance();
        try {
            Map<String, String> averagePrice = Files.lines(Path.of("/Users/praise/Desktop/carsCsv.csv"))
                    .skip(1)
                    .map(s -> s.split(","))
                    .map(s -> {
                        try {
                            return new Car(s[0], s[1], new BigDecimal(df.parse(s[3]).toString()), LocalDate.of(Integer.parseInt(s[2]), Month.APRIL, 1));
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .collect(Collectors.groupingBy(Car::getMake,
                            Collectors.teeing(
                                    Collectors.reducing(BigDecimal.ZERO, Car::getPrice, BigDecimal::add),
                                    Collectors.counting(),
                                    (sum, count) -> df.format(sum.divide(new BigDecimal(count)).longValue()))));

            System.out.println(averagePrice);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
