import day14.SandSolver
import day14.SandWithFloorSolver
import spock.lang.Specification

class Day14Test extends Specification {

    private Scanner puzzle;

    void setup() {
        puzzle = new Scanner(new ByteArrayInputStream("""498,4 -> 498,6 -> 496,6
503,4 -> 502,4 -> 502,9 -> 494,9""".getBytes()))
    }

    def "Solve Part 1"() {
        given:
            def solver = new SandSolver()
        when:
            def answer = solver.solve(puzzle)
        then:
            answer == 24
    }

    def "Solve Part 2"() {
        given:
            def solver = new SandWithFloorSolver()
        when:
            def answer = solver.solve(puzzle)
        then:
            answer == 93
    }
}
