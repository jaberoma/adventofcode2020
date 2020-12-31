package es.jaberoma.aoc.day4;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FieldsValidator {

    private static final Map<String, PassportFieldValidator> FIELDS_VALIDATOR = Stream.of(
            new AbstractMap.SimpleEntry<String, PassportFieldValidator>("byr", FieldsValidator::validateByr),
            new AbstractMap.SimpleEntry<String, PassportFieldValidator>("iyr", FieldsValidator::validateIyr),
            new AbstractMap.SimpleEntry<String, PassportFieldValidator>("eyr", FieldsValidator::validateEyr),
            new AbstractMap.SimpleEntry<String, PassportFieldValidator>("hgt", FieldsValidator::validateHgt),
            new AbstractMap.SimpleEntry<String, PassportFieldValidator>("pid", FieldsValidator::validatePid),
            new AbstractMap.SimpleEntry<String, PassportFieldValidator>("hcl", FieldsValidator::validateHcl),
            new AbstractMap.SimpleEntry<String, PassportFieldValidator>("ecl", FieldsValidator::validateEcl),
            new AbstractMap.SimpleEntry<String, PassportFieldValidator>("cid", value -> true)
    )
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    private static final List<String> ECL_ALLOWED_VALUES = Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth");

    public static boolean validate(String field) {
        String[] keyValuePair = field.split(":");
        PassportFieldValidator validator = FIELDS_VALIDATOR.get(keyValuePair[0]);
        if (validator == null) {
            throw new UnsupportedOperationException("Not recognized key: " + keyValuePair[0]);
        }
        return validator.validate(keyValuePair[1]);
    }

    private static boolean validateByr(String value) {
        return number(value, 4, 1920, 2002);
    }

    private static boolean validateIyr(String value) {
        return number(value, 4, 2010, 2020);
    }

    private static boolean validateEyr(String value) {
        return number(value, 4, 2020, 2030);
    }

    private static boolean validateHgt(String value) {
        String numberPart = value.substring(0, value.length() - 2);
        if (value.endsWith("cm")) {
            return number(numberPart, 3, 150, 193);
        } else if (value.endsWith("in")) {
            return number(numberPart, 59, 76);
        } else {
            return false;
        }
    }

    private static boolean validatePid(String value) {
        return number(value, 9).isPresent();
    }

    private static boolean validateHcl(String value) {
        Matcher matcher = Pattern.compile("^#([a-f0-9]{6})$").matcher(value);
        return matcher.matches();
    }

    private static boolean validateEcl(String value) {
        return ECL_ALLOWED_VALUES.contains(value);
    }

    private static Optional<Long> number(String value) {
        if (value == null || value.trim().equals("")) {
            return Optional.empty();
        }

        try {
            return Optional.of(Long.parseLong(value));
        } catch (NumberFormatException nfe) {
            return Optional.empty();
        }
    }

    private static Optional<Long> number(String value, int size) {
        Optional<Long> number = number(value);
        return (number.isPresent() && value.trim().length() == size ? number : Optional.empty());
    }

    private static boolean number(String value, int min, int max) {
        Optional<Long> number = number(value);
        return number.map(longValue -> longValue >= min && longValue <= max).orElse(false);
    }

    private static boolean number(String value, int size, int min, int max) {
        Optional<Long> number = number(value, size);
        return number.map(longValue -> longValue >= min && longValue <= max).orElse(false);
    }
}
