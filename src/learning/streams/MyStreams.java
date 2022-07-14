package learning.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
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
        try {
            Files.lines(Path.of("/Users/praise/IdeaProjects/Java/src/learning/streams/test.txt"))
                    .forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//                .forEach();
    }
}
