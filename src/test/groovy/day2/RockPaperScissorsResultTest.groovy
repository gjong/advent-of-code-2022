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
}
