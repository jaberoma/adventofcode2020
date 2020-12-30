package es.jaberoma.aoc.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReportRepair {

    public static List<Integer> readDay1InputData() throws IOException {
        try (InputStream inputData = ReportRepair.class.getClassLoader().getResourceAsStream("day1.input")) {
            return new BufferedReader(new InputStreamReader(Objects.requireNonNull(inputData), StandardCharsets.UTF_8))
                    .lines()
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        }
    }

    public static MatchingNumbers numbers(List<Integer> inputNumbers) {
        return find(() -> {
            for (int i = inputNumbers.size(); --i >= 0; ) {
                for (int j = inputNumbers.size(); --j >= 0; ) {
                    if (inputNumbers.get(i) + inputNumbers.get(j) == 2020) {
                        return new MatchingNumbers(inputNumbers.get(i), inputNumbers.get(j));
                    }
                }
            }
            return null;
        });
    }

    public static MatchingNumbers numbersJava8(List<Integer> inputNumbers) {
        return find(() -> inputNumbers.stream()
                .map(number ->
                        inputNumbers.stream()
                                .filter(anotherNumber -> number + anotherNumber == 2020)
                                .findAny()
                                .map(foundNumber -> new MatchingNumbers(number, foundNumber))
                )
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findAny()
                .get());
    }

    private static MatchingNumbers find(DataFinder dataFinder) {
        Instant start = Instant.now();
        MatchingNumbers matchingNumbers = dataFinder.find();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Day1ReportRepair.find elapsed time: " + timeElapsed);
        return matchingNumbers;
    }

}
