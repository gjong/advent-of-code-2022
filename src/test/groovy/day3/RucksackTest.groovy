package day3


import spock.lang.Specification

class RucksackTest extends Specification {
    def "Solve sample"() {
        given:
            def solver = new Rucksack()
        when:
            def answer = solver.solve(List.of(
                    "vJrwpWtwJgWrhcsFMMfFFhFp",
                    "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
                    "PmmdzqPrVvPwwTWBwg",
                    "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
                    "ttgJtRGJQctTZtZT",
                    "CrZsJsPPZsGzwwsLwLmpwMDw"))
        then:
            answer == 157
    }
}
