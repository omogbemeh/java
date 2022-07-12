package learning.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class MyCollection {

    public static void main(String[] args) {
        List<Object> employees = new ArrayList<>();
        extracted(employees);
    }

    private static void extracted(List<Object> employees) {
        employees.removeIf(Objects::isNull);
    }

}
