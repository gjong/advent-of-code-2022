

import common.Solution
import day4.CleanupCampAnyOverlap
import day4.CleanupCampFullOverlap
import spock.lang.Specification

class Day04Test extends Specification {
    def "Solve Part #part"(Solution<Scanner, Integer> solver, int expected) {
        given:
            def puzzle = new Scanner(new ByteArrayInputStream("""
2-4,6-8
2-3,4-5
5-7,7-9
2-8,3-7
6-6,4-6
2-6,4-8""".getBytes()))
        when:
            def answer = solver.solve(puzzle)
        then:
            answer == expected

        where:
            part | solver | expected
            1 | new CleanupCampAnyOverlap()  | 4
            2 | new CleanupCampFullOverlap() | 2
    }
}
