package day2


import spock.lang.Specification

class RockPaperScissorsTest extends Specification {
    def "Solve sample"() {
        given:
            def solver = new RockPaperScissors()
        when:
            def answer = solver.solve(List.of("A Y", "B X", "C Z"))
        then:
            answer == 15
    }
}
