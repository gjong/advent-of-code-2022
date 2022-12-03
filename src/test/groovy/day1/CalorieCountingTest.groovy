package day1

import spock.lang.Specification

class CalorieCountingTest extends Specification {

    def "Solve"() {
        given:
            def solution = new CalorieCounting()
        when:
            def answer = solution.solve("""1000
2000
3000

4000

5000
6000

7000
8000
9000

10000""")
        then:
            answer == 24000
    }

    def "Solve real puzzle"() {
        given:
            def input = CalorieCounting.getResourceAsStream("/day1-caloric-input.txt")
                    .readLines()
                    .join("\n")
            def solver = new CalorieCounting()
        when:
            def answer = solver.solve(input)
        then:
            answer == 71506
    }
}
