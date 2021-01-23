package es.jaberoma.aoc.day6;

import es.jaberoma.aoc.AocFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GroupReader extends AocFileReader {

    public static List<List<String>> readGroups(String filename) throws IOException {
        List<String> fileContents = read(filename);
        List<List<String>> groups = new LinkedList<>();
        var groupReference = new Object() {
            List<String> group = new ArrayList<>();
        };
        fileContents.forEach(line -> {
            if (line.trim().equals("")) {
                groups.add(groupReference.group);
                groupReference.group = new ArrayList<>();
            } else {
                groupReference.group.add(line);
            }
        });
        groups.add(groupReference.group);
        return groups;
    }
}
