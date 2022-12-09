

import common.Solution
import day1.CalorieCounting
import day1.GroupedCounter
import spock.lang.Specification

class Day01Test extends Specification {

    def "Solve Part #part"(Solution<String, Integer> solver, int expected) {
        given:
            def puzzle = """1000
2000
3000

4000

5000
6000

7000
8000
9000

10000"""
        when:
            def answer = solver.solve(puzzle)
        then:
            answer == expected

        where:
            part | solver | expected
            1 | new CalorieCounting() | 24000
            2 | new GroupedCounter()  | 45000
    }
}
