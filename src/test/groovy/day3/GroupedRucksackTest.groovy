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
}
