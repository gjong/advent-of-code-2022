import common.Solution
import day8.ScenicSolver
import day8.TreeTopVisibility
import spock.lang.Specification

class Day08Test extends Specification {

    def "Solve Part #part"(Solution<List<String>, Integer> solver, int expectedAnswer) {
        when:
            def answer = solver.solve(List.of(
                "30373",
                "25512",
                "65332",
                "33549",
                "35390"))
        then:
            answer == expectedAnswer
        where:
            part | solver | expectedAnswer
            1 | new ScenicSolver() | 8
            2 | new TreeTopVisibility() | 21
    }
}
