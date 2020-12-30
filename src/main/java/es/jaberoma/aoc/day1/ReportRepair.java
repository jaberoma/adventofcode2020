package es.jaberoma.aoc.day1;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

public class ReportRepair {

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
