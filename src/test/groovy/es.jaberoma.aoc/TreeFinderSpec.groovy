package es.jaberoma.aoc

import es.jaberoma.aoc.day3.TreeFinder
import spock.lang.Specification
import spock.lang.Unroll

class TreeFinderSpec extends Specification {

    private static final List<String> SAMPLE_DATA = Arrays.asList(new String[]{
            "..##.........##.........##.........##.........##.........##.......",
            "#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..",
            ".#....#..#..#....#..#..#....#..#..#....#..#..#....#..#..#....#..#.",
            "..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#",
            ".#...##..#..#...##..#..#...##..#..#...##..#..#...##..#..#...##..#.",
            "..#.##.......#.##.......#.##.......#.##.......#.##.......#.##.....",
            ".#.#.#....#.#.#.#....#.#.#.#....#.#.#.#....#.#.#.#....#.#.#.#....#",
            ".#........#.#........#.#........#.#........#.#........#.#........#",
            "#.##...#...#.##...#...#.##...#...#.##...#...#.##...#...#.##...#...",
            "#...##....##...##....##...##....##...##....##...##....##...##....#",
            ".#..#...#.#.#..#...#.#.#..#...#.#.#..#...#.#.#..#...#.#.#..#...#.#"
    })
    private static final String INPUT_FILENAME = 'day3.input'

    void 'number of trees in sample data'() {
        when:
        Long numberOfTrees = TreeFinder.find(SAMPLE_DATA, 3, 1)

        then:
        numberOfTrees == 7
    }

    void 'number of trees with day e input data'() {
        when:
        Long treesNumber = TreeFinder.find(AocFileReader.read(INPUT_FILENAME), 3, 1)

        then:
        treesNumber == 265
    }

    @Unroll
    void 'number of trees in sample data, part 2'() {
        when:
        Long numberOfTrees = TreeFinder.find(SAMPLE_DATA, right, down)

        then:
        numberOfTrees == trees

        where:
        right | down | trees
        1     | 1    | 2
        3     | 1    | 7
        5     | 1    | 3
        7     | 1    | 4
        1     | 2    | 2
    }

    @Unroll
    void 'number of trees in input data, part 2'() {
        when:
        Long numberOfTrees = TreeFinder.find(AocFileReader.read(INPUT_FILENAME), right, down)

        then:
        numberOfTrees == trees

        where:
        right | down | trees
        1     | 1    | 61
        3     | 1    | 265
        5     | 1    | 82
        7     | 1    | 70
        1     | 2    | 34
    }

    void 'number of trees in input data, part 2, multiplied together'() {
        given:
        List<Map> movements = [
                [right: 1, down: 1],
                [right: 3, down: 1],
                [right: 5, down: 1],
                [right: 7, down: 1],
                [right: 1, down: 2]
        ]

        when:
        long multiplied = movements.inject(1L) { result, movement ->
            TreeFinder.find(AocFileReader.read(INPUT_FILENAME), movement.right, movement.down) * result
        }

        then:
        multiplied == 3154761400
    }

}