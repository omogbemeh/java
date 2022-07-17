package learning.collections.cars;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class Car {

    private static final List<Car> cars = new ArrayList<>();
    private final String make;
    private final String model;
    private final BigDecimal price;
    private final LocalDate year;

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public Car(String make, String model, BigDecimal price, LocalDate year) {
        this.make = make;
        this.model = model;
        this.price = price;
        this.year = year;
    }

    public static void main(String[] models) {
        createAndPrint5Cars();

        List<String> undesirables = new ArrayList<>(List.of(models));

        Map<String, Car> modelsMap = new HashMap<>();

        for (Car car : cars) {
            modelsMap.put(car.getModel(), car);
        }

        System.out.printf("There are currently %d items in the modelsMap.%n", modelsMap.size());

        for (Map.Entry<String, Car> etr : modelsMap.entrySet()) {
            System.out.printf("   >> %s %s%n",etr.getKey(), etr.getValue().toString());
        }

        for (String str : undesirables) {
            modelsMap.remove(str);
        }

        System.out.printf("There are now %d items in the modelsMap.%n", modelsMap.size());

        for (Map.Entry<String, Car> etr : modelsMap.entrySet()) {
            System.out.printf("  >> %s %s%n",etr.getKey(), etr.getValue().toString());
        }

//        printCarSet();
//        assignOwner();
//        sortCarsByModel();
//        sortCarModelsInDesc();
    }

    public static void createAndPrint5Cars() {
        Car car1 = new Car("toyota", "camry", new BigDecimal("15000"), LocalDate.of(2009, Month.JANUARY, 1));
        Car car2 = new Car("mercedes-benz", "c-class", new BigDecimal("23000"), LocalDate.of(2016, Month.DECEMBER, 23));
        Car car3 = new Car("audi", "s4", new BigDecimal("17000"), LocalDate.of(2011, Month.FEBRUARY, 12));
        Car car4 = new Car("ferrari", "enzo", new BigDecimal("700000"), LocalDate.of(2002, Month.JANUARY, 2));
        Car car5 = new Car("lamborghini", "aventador", new BigDecimal("500000"), LocalDate.of(2018, Month.APRIL, 4));

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);

    }

    public BigDecimal getPrice() {
        return price;
    }

    public LocalDate getYear() {
        return year;
    }

    public static void printCarSet() {
//        Car car1 = new Car("toyota", "camry", price, year);
//        Car car2 = new Car("mercedes-benz", "c-class", price, year);
//        Car car3 = new Car("audi", "s4", price, year);
//        Car car4 = new Car("ferrari", "enzo", price, year);
//        Car car5 = new Car("lamborghini", "aventador", price, year);
//        Car car6 = new Car("lamborghini", "aventador", price, year);
//
//        Set<Car> cars = new HashSet<>();
//
//        cars.add(car1);
//        cars.add(car2);
//        cars.add(car3);
//        cars.add(car4);
//        cars.add(car5);
//        cars.add(car6);
//
//        for (Car car : cars) {
//            System.out.println(car);
//        }
    }

    public static void assignOwner() {
        HashMap<String, Car> ownersMap = new HashMap<>();
        ownersMap.put("Bob", cars.get(1));
        System.out.println(ownersMap);
    }

    public static void sortCarsByModel() {
        cars.sort(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.model.compareTo(o2.model);
            }
        });

        for (Car car : cars) System.out.println(car);
    }

    public static void sortCarModelsInDesc() {
        Collections.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o2.model.compareTo(o1.model);
            }
        });

        for (Car car : cars) System.out.println(car);
    }



    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return make.equals(car.make) && model.equals(car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, model);
    }
}
