package es.jaberoma.aoc.day5;

import java.util.List;
import java.util.NoSuchElementException;

public class BoardingPassParser {

    public static int maxSeatId(List<String> boardingPasses) {
        return boardingPasses
                .stream()
                .mapToInt(BoardingPassParser::seatId)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    public static int row(String boardingPass) {
        return BoardingPassParser.parse(boardingPass, 'F', 6, 0, 0, 127);
    }

    public static int column(String boardingPass) {
        return BoardingPassParser.parse(boardingPass, 'L', 9, 7, 0, 7);
    }

    public static int seatId(String boardingPass) {
        return (row(boardingPass) * 8) + column(boardingPass);
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
