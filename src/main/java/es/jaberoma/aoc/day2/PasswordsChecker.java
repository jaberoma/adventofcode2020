package es.jaberoma.aoc.day2;

import java.util.List;

public class PasswordsChecker {

    public static Long getNumberOfValidPasswords(List<String> passwordDefinitions) {
        return passwordDefinitions.stream()
                .map(PasswordLineParser::parse)
                .filter(PasswordDetail::isValid)
                .count();
    }
}
