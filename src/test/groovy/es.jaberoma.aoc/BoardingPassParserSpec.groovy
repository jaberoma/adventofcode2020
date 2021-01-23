package es.jaberoma.aoc

import es.jaberoma.aoc.day5.BoardingPassParser
import spock.lang.Specification
import spock.lang.Unroll

class BoardingPassParserSpec extends Specification {

    @Unroll
    void 'Can get row from boarding pass'() {
        when:
        int row = BoardingPassParser.row(boardingPass)

        then:
        row == expectedRow

        where:
        boardingPass | expectedRow
        'BFFFBBFRRR' | 70
        'FFFBBBFRRR' | 14
        'BBFFBBFRLL' | 102
        'FBBBBBBRRR' | 63
    }

    @Unroll
    void 'Can get column from boarding pass'() {
        when:
        int column = BoardingPassParser.column(boardingPass)

        then:
        column == expectedColumn

        where:
        boardingPass | expectedColumn
        'BFFFBBFRRR' | 7
        'FFFBBBFRRR' | 7
        'BBFFBBFRLL' | 4
        'FBBBBBBRRR' | 7
    }

    @Unroll
    void 'Can get seat ID from boarding pass'() {
        when:
        int seatId = BoardingPassParser.seatId(boardingPass)

        then:
        seatId == expectedSeatId

        where:
        boardingPass | expectedSeatId
        'BFFFBBFRRR' | 567
        'FFFBBBFRRR' | 119
        'BBFFBBFRLL' | 820
    }

    void 'Can get max seat ID from input data'() {
        when:
        int maxSeatId = BoardingPassParser.maxSeatId(AocFileReader.read('day5.input'))

        then:
        maxSeatId == 838
    }

    void 'My boarding pass finder'() {
        when:
        Integer myBoardingPass = BoardingPassParser.myBoardingPass(AocFileReader.read('day5.input'))

        then:
        myBoardingPass == 714
    }
}
