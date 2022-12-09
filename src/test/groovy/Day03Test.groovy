

import common.Solution
import day3.GroupedRucksack
import day3.Rucksack
import spock.lang.Specification

class Day03Test extends Specification {
    def "Solve Part #part"(Solution<List<String>, Integer> solver, int expected) {
        when:
            def answer = solver.solve(List.of(
                "vJrwpWtwJgWrhcsFMMfFFhFp",
                "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
                "PmmdzqPrVvPwwTWBwg",
                "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
                "ttgJtRGJQctTZtZT",
                "CrZsJsPPZsGzwwsLwLmpwMDw"))
        then:
            answer == expected

        where:
            part | solver | expected
            1 | new Rucksack()        | 157
            2 | new GroupedRucksack() | 70
    }
}
