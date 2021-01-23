package es.jaberoma.aoc.day6;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupCounter {

    public static Integer differentAnswersSumForAllGroups(List<List<String>> groupsAnswers) {
        return groupsAnswers
                .stream()
                .mapToInt(GroupCounter::answersForAGroup)
                .sum();
    }

    public static Integer answersForAGroup(List<String> groupAnswers) {
        return groupAnswers
                .stream()
                .map(GroupCounter::answersForOnePerson)
                .collect(HashSet::new, Set::addAll, Set::addAll)
                .size();
    }

    public static Set<Character> answersForOnePerson(String answers) {
        return answers.chars()
                .mapToObj(answer -> (char) answer)
                .collect(Collectors.toSet());
    }
}
