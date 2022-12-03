package day1

import spock.lang.Specification

class GroupedCounterTest extends Specification {
    def "Solve"() {
        given:
            def solution = new GroupedCounter()
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
            answer == 45000
    }

    def "Solve real puzzle"() {
        given:
            def input = GroupedCounter.getResourceAsStream("/day1-caloric-input.txt")
                    .readLines()
                    .join("\n")
            def solver = new GroupedCounter()
        when:
            def answer = solver.solve(input)
        then:
            answer == 71506
    }
}
