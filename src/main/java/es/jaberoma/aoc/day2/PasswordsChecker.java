package es.jaberoma.aoc.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PasswordsChecker {

    public static List<String> readDay2InputData() throws IOException {
        try (InputStream inputData = PasswordsChecker.class.getClassLoader().getResourceAsStream("day2.input")) {
            return new BufferedReader(new InputStreamReader(Objects.requireNonNull(inputData), StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.toList());
        }
    }

    public static Long getNumberOfValidPasswords(List<String> passwordDefinitions) {
        return passwordDefinitions.stream()
                .map(PasswordDetail::new)
                .filter(PasswordDetail::isValid)
                .count();
    }
}
