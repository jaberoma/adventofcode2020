package es.jaberoma.aoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AocFileReader {

    public static List<String> read(String filename) throws IOException {
        try (InputStream inputData = AocFileReader.class.getClassLoader().getResourceAsStream(filename)) {
            return new BufferedReader(new InputStreamReader(Objects.requireNonNull(inputData), StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.toList());
        }
    }

}
