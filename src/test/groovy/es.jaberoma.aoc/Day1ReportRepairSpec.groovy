package es.jaberoma.aoc

import es.jaberoma.aoc.day1.Day1ReportRepair
import es.jaberoma.aoc.day1.MatchingNumbers
import spock.lang.Specification

class Day1ReportRepairSpec extends Specification {

    private static final ArrayList<Integer> HARD_CODED_TEST_DATA = [1, 27, 35, 44, 87, 2019, 38, 599]
    private static final int DISGUSTING_YEAR = 2020

    void 'get numbers that sum 2020'() {
        when:
        MatchingNumbers foundNumbers = Day1ReportRepair.numbers(HARD_CODED_TEST_DATA)

        then:
        foundNumbers.getNum1() + foundNumbers.getNum2() == DISGUSTING_YEAR
    }

    void 'get numbers that sum 2020 from day 1 report repair input data'() {
        given:
        List<Integer> inputData = Day1ReportRepair.readDay1InputData()

        when:
        MatchingNumbers foundNumbers = Day1ReportRepair.numbers(inputData)

        then:
        foundNumbers.getNum1() + foundNumbers.getNum2() == DISGUSTING_YEAR
    }

    void '[Java 8] get numbers that sum 2020'() {
        when:
        MatchingNumbers foundNumbers = Day1ReportRepair.numbersJava8(HARD_CODED_TEST_DATA)

        then:
        foundNumbers.getNum1() + foundNumbers.getNum2() == DISGUSTING_YEAR
    }

    void '[Java 8] get numbers that sum 2020 from day 1 report repair input data'() {
        given:
        List<Integer> inputData = Day1ReportRepair.readDay1InputData()

        when:
        MatchingNumbers foundNumbers = Day1ReportRepair.numbersJava8(inputData)

        then:
        foundNumbers.getNum1() + foundNumbers.getNum2() == DISGUSTING_YEAR
    }


}