package day3

import spock.lang.Specification

class GroupedRucksackTest extends Specification {
    def "Solve sample"() {
        given:
            def solver = new GroupedRucksack()
        when:
            def answer = solver.solve(List.of(
                "vJrwpWtwJgWrhcsFMMfFFhFp",
                "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
                "PmmdzqPrVvPwwTWBwg",
                "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
                "ttgJtRGJQctTZtZT",
                "CrZsJsPPZsGzwwsLwLmpwMDw"))
        then:
            answer == 70
    }

    def "Solve real puzzle"() {
        given:
            def solver = new GroupedRucksack()
        when:
            def input = GroupedRucksack.getResourceAsStream("/day3-rucksack.txt")
                .readLines()
            def answer = solver.solve(input)
        then:
            answer == 0
    }

}
