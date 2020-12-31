package es.jaberoma.aoc.day4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PassportValidator {

    private static final List<String> REQUIRED_FIELDS = Arrays.asList(
            "byr",
            "iyr",
            "eyr",
            "hgt",
            "hcl",
            "ecl",
            "pid"
    );

    public static boolean validate(String passport) {
        List<String> validPassportKeys = Arrays.stream(passport.split(" "))
                .filter(FieldsValidator::validate)
                .map(passportItem -> passportItem.split(":")[0])
                .collect(Collectors.toList());
        return validPassportKeys.containsAll(REQUIRED_FIELDS);
    }

    public static long validate(List<String> passports) {
        return passports
                .stream()
                .filter(PassportValidator::validate)
                .count();
    }

}
