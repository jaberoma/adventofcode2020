package es.jaberoma.aoc

import es.jaberoma.aoc.day6.GroupCounter
import es.jaberoma.aoc.day6.GroupReader
import spock.lang.Specification
import spock.lang.Unroll

class GroupCounterSpec extends Specification {

    @Unroll
    void 'Can count answers for one person'() {
        when:
        Set<Character> mappedAnswers = GroupCounter.answersForOnePerson(answers)

        then:
        mappedAnswers == expectedAnswers

        where:
        answers | expectedAnswers
        'abcx'  | ['a', 'b', 'c', 'x'] as Set<Character>
        'abcy'  | ['a', 'b', 'c', 'y'] as Set<Character>
        'abcz'  | ['a', 'b', 'c', 'z'] as Set<Character>
    }

    void 'Can count different answers for a group'() {
        when:
        Integer differentAnswers = GroupCounter.answersForAGroup(['abcx', 'abcy', 'abcz'])

        then:
        differentAnswers == 6
    }

    @Unroll
    void 'Can sum different answers for all groups'() {
        given:
        List<List<String>> answersForAllGroups = GroupReader.readGroups(inputFile)

        when:
        Integer answersSum = GroupCounter.differentAnswersSumForAllGroups(answersForAllGroups)

        then:
        answersSum == expectedResult

        where:
        inputFile           | expectedResult
        'day6_sample.input' | 11
        'day6.input'        | 6735
    }

}
