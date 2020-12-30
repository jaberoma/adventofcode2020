package es.jaberoma.aoc


import es.jaberoma.aoc.day2.PasswordsChecker
import spock.lang.Specification

class PasswordsCheckerSpec extends Specification {

    private static final List<String> SINGLE_DATA = Arrays.asList(new String[]{
            "1-3 a: abcde",
            "1-3 b: cdefg",
            "2-9 c: ccccccccc"
    })

    void 'number of valid passwords with single data'() {
        when:
        Long validPasswords = PasswordsChecker.getNumberOfValidPasswords(SINGLE_DATA)

        then:
        validPasswords == 2
    }

    void 'number of valid passwords with day 2 input data'() {
        when:
        Long validPasswords = PasswordsChecker.getNumberOfValidPasswords(PasswordsChecker.readDay2InputData())

        then:
        validPasswords == 517
    }

}