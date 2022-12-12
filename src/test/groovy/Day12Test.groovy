import day12.PathSolver
import day12.PrettiestPathSolver
import spock.lang.Specification

class Day12Test extends Specification {
    List<String> puzzle;

    void setup() {
        puzzle = List.of(
                "Sabqponm",
                "abcryxxl",
                "accszExk",
                "acctuvwj",
                "abdefghi")
    }

    def "Solve Part 1"() {
        given:
            def solver = new PathSolver()
        when:
            def answer = solver.solve(puzzle)
        then:
            answer == 31
    }

    def "Solve Part 2"() {
        given:
            def solver = new PrettiestPathSolver()
        when:
            def answer = solver.solve(puzzle)
        then:
            answer == 29
    }
}
