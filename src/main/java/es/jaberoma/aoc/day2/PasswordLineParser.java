package es.jaberoma.aoc.day2;

public class PasswordLineParser {

    public static PasswordDetail parse(String line) {
        String[] inputParts = line.split(" ");
        String[] rangeParts = inputParts[0].split("-");
        Integer targetLetterPosition1 = Integer.valueOf(rangeParts[0]);
        Integer targetLetterPosition2 = Integer.valueOf(rangeParts[1]);
        Character letter = inputParts[1].charAt(0);
        String password = inputParts[2];
        return new PasswordDetail(targetLetterPosition1, targetLetterPosition2, letter, password);
    }

}
