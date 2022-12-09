

import common.Solution
import day2.RockPaperScissors
import day2.RockPaperScissorsResult
import spock.lang.Specification

class Day02Test extends Specification {
    def "Solve Part #part"(Solution<List<String>, Integer> solver, int expected) {
        given:
            def puzzle = List.of("A Y", "B X", "C Z")
        when:
            def answer = solver.solve(puzzle)
        then:
            answer == expected

        where:
            part | solver | expected
            1 | new RockPaperScissors()       | 15
            2 | new RockPaperScissorsResult() | 12
    }
}
