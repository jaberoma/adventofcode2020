package es.jaberoma.aoc;

import java.util.List;
import java.util.stream.IntStream;

public class TreeFinder {

    private static final int RIGHT_MOVEMENT = 3;
    private static final Character TREE = '#';

    public static long find(List<String> treeMap) {
        return IntStream.range(1, treeMap.size())
                .filter(row -> {
                    int mapLineLength = treeMap.get(row).length();
                    int rightPosition = RIGHT_MOVEMENT * row;
                    if (rightPosition >= mapLineLength) {
                        rightPosition %= mapLineLength;
                    }

                    return treeMap.get(row).charAt(rightPosition) == TREE;
                })
                .count();
    }
}
