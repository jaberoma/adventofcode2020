package es.jaberoma.aoc.day4;

import es.jaberoma.aoc.AocFileReader;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class PassportReader extends AocFileReader {

    public static List<String> readPassports(String filename) throws IOException {
        List<String> fileContents = read(filename);
        List<String> passports = new LinkedList<>();
        StringBuffer passport = new StringBuffer();
        fileContents.forEach(line -> {
            if (line.trim().equals("")) {
                passports.add(passport.toString());
                passport.setLength(0);
            } else {
                if (!passport.toString().equals("")) {
                    passport.append(" ");
                }
                passport.append(line.trim());
            }
        });
        passports.add(passport.toString());
        return passports;
    }
}
