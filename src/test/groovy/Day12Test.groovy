import day12.PathSolver
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
}
