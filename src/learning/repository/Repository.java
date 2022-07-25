package learning.repository;

import java.util.ArrayList;
import java.util.List;

public class Repository<T> {
    record Person (String firstName, String lastName, int age) {}
    List<T> records = new ArrayList<>();

    List<T> findAll() {
        return records;
    }

    T save(T arg) {
        records.add(arg);
        return arg;
    }

    public static void main(String[] args) {
        Repository<String> strRecords = new Repository<>();
        String d1 = strRecords.save("Praise");
        System.out.println(strRecords.findAll());

        Repository<Person> persons = new Repository<>();
        Person p1 = persons.save(new Person("Faith", "Omogbemeh", 20));
        System.out.println(persons.findAll());
    }
}
