package es.jaberoma.aoc.day3;

import java.util.List;
import java.util.stream.IntStream;

public class TreeFinder {

    private static final Character TREE = '#';

    public static long find(List<String> treeMap, int right, int down) {
        return IntStream.range(1, treeMap.size())
                .filter(rowNumber -> {
                    if (down == 1 || rowNumber % down == 0) {
                        int lineLength = treeMap.get(rowNumber).length();
                        int rightPosition = right * (rowNumber / down);
                        if (rightPosition >= lineLength) {
                            rightPosition %= lineLength;
                        }

                        return treeMap.get(rowNumber).charAt(rightPosition) == TREE;
                    } else {
                        return false;
                    }
                })
                .count();
    }
}
