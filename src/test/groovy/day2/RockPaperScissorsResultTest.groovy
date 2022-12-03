package day2

import spock.lang.Specification

class RockPaperScissorsResultTest extends Specification {
    def "Solve sample"() {
        given:
            def solver = new RockPaperScissorsResult()
        when:
            def answer = solver.solve(List.of("A Y", "B X", "C Z"))
        then:
            answer == 12
    }


    def "Solve real puzzle"() {
        given:
            def input = RockPaperScissorsResult.getResourceAsStream("/day2-rock-paper-scissors.txt")
                .readLines()
            def solver = new RockPaperScissorsResult()
        when:
            def answer = solver.solve(input)
        then:
            answer == 0
    }
}
