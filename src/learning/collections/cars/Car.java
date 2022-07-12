package learning.collections.cars;

import java.util.*;

public class Car {

    private static final List<Car> cars = new ArrayList<>();
    private final String make;
    private final String model;

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public static void main(String[] args) {
//        printCarSet();
//        assignOwner();
       createAndPrint5Cars();
        sortCarsByModel();
    }

    public static void createAndPrint5Cars() {
        Car car1 = new Car("toyota", "camry");
        Car car2 = new Car("mercedes-benz", "c-class");
        Car car3 = new Car("audi", "s4");
        Car car4 = new Car("ferrari", "enzo");
        Car car5 = new Car("lamborghini", "aventador");

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);

    }

    public static void printCarSet() {
        Car car1 = new Car("toyota", "camry");
        Car car2 = new Car("mercedes-benz", "c-class");
        Car car3 = new Car("audi", "s4");
        Car car4 = new Car("ferrari", "enzo");
        Car car5 = new Car("lamborghini", "aventador");
        Car car6 = new Car("lamborghini", "aventador");

        Set<Car> cars = new HashSet<>();

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        cars.add(car6);

        for (Car car : cars) {
            System.out.println(car);
        }
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
