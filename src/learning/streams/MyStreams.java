package learning.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.text.NumberFormat;
import java.util.stream.IntStream;

public class MyStreams {

    private static String finalStr = "";

    public static void main(String[] args) {
      readFile();
    }

    public static void addStr(String r) {
        if (finalStr.length() < 1) {
            finalStr += r;
        } else finalStr += "-" + r;
    }

    public static void readFile() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();

        try {
            long sum = Files.lines(Path.of("/Users/praise/Downloads/Hr5m.csv"))
                    .skip(1)
                    .map(Employee::createEmployee)
                    .mapToLong(Employee::getSalary)
                    .sum();

            System.out.printf("The total sum is %s", nf.format(sum));

//            Files.lines(Path.of("/Users/praise/Downloads/Hr5m.csv"))
//                    .limit(2)
//                    .forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//                .forEach();
    }
}
