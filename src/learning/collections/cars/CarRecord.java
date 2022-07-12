package learning.collections.cars;

import java.util.HashSet;

public record CarRecord(String make, String model) {
    public static void main(String[] args) {
        createAllModels();
    }

    public static void createAllModels() {
        CarRecord cr1 = new CarRecord("tesla", "s");
        CarRecord cr2 = new CarRecord("tesla", "3");
        CarRecord cr3 = new CarRecord("tesla", "x");
        CarRecord cr4 = new CarRecord("tesla", "y");

        HashSet<CarRecord> carRecords = new HashSet<>();
        carRecords.add(cr1);
        carRecords.add(cr2);
        carRecords.add(cr3);
        carRecords.add(cr4);

        for (CarRecord cr : carRecords) System.out.println(cr);
    }

    @Override
    public String toString() {
        return "CarRecord{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
