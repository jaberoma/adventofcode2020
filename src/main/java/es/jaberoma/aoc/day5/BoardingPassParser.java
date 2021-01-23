package es.jaberoma.aoc.day5;

import java.util.*;
import java.util.stream.Collectors;

public class BoardingPassParser {

    public static Integer myBoardingPass(List<String> boardingPasses) {
        Set<Integer> seatIdsInTheMiddleOfPlane = boardingPasses
                .stream()
                .filter(boardingPass -> row(boardingPass) > 25 && row(boardingPass) < 100)
                .map(BoardingPassParser::seatId)
                .collect(Collectors.toSet());

        Set<MatchingSeatIds> closerSeatIds = seatIdsNearMine(new ArrayList<>(seatIdsInTheMiddleOfPlane))
                .stream()
                .filter(match -> !seatIdsInTheMiddleOfPlane.contains(match.seatIdInBetween()))
                .collect(Collectors.toSet());

        if (closerSeatIds.size() != 1) {
            throw new NoSuchElementException();
        }

        return closerSeatIds.stream().findFirst().get().seatIdInBetween();
    }

    private static Set<MatchingSeatIds> seatIdsNearMine(List<Integer> seatIds) {
        Set<MatchingSeatIds> matchingSeatIds = new HashSet<>();
        for (int i = seatIds.size(); --i >= 0; ) {
            for (int j = seatIds.size(); --j >= 0; ) {
                if (Math.abs(seatIds.get(i) - seatIds.get(j)) == 2) {
                    matchingSeatIds.add(new MatchingSeatIds(seatIds.get(i), seatIds.get(j)));
                }
            }
        }
        return matchingSeatIds;
    }

    public static int maxSeatId(List<String> boardingPasses) {
        return boardingPasses
                .stream()
                .mapToInt(BoardingPassParser::seatId)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    public static int seatId(String boardingPass) {
        return (row(boardingPass) * 8) + column(boardingPass);
    }

    public static int row(String boardingPass) {
        return BoardingPassParser.parse(boardingPass, 'F', 6, 0, 0, 127);
    }

    public static int column(String boardingPass) {
        return BoardingPassParser.parse(boardingPass, 'L', 9, 7, 0, 7);
    }

    private static int parse(String boardingPass, char discriminator, int stopAt, int position, int min, int max) {
        char half = boardingPass.charAt(position);
        if (position == stopAt) {
            return half == discriminator ? min : max;
        } else {
            int limit = max - ((max - min) / 2);
            int newPosition = position + 1;
            return half == discriminator ? parse(boardingPass, discriminator, stopAt, newPosition, min, limit - 1) : parse(boardingPass, discriminator, stopAt, newPosition, limit, max);
        }
    }
}
