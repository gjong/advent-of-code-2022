package day8

import spock.lang.Specification

class ScenicSolverTest extends Specification {
    def "Solve sample"() {
        given:
            def solution = new ScenicSolver()
        when:
            def answer = solution.solve(List.of(
                "30373",
                "25512",
                "65332",
                "33549",
                "35390"))
        then:
            answer == 8
    }
}
