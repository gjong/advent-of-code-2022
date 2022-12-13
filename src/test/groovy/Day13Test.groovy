import day13.DividerSolver
import day13.PairSolver
import spock.lang.Specification

class Day13Test extends Specification {

    Scanner puzzle;

    void setup() {
        puzzle = new Scanner(new ByteArrayInputStream("""[1,1,3,1,1]
[1,1,5,1,1]

[[1],[2,3,4]]
[[1],4]

[9]
[[8,7,6]]

[[4,4],4,4]
[[4,4],4,4,4]

[7,7,7,7]
[7,7,7]

[]
[3]

[[[]]]
[[]]

[1,[2,[3,[4,[5,6,7]]]],8,9]
[1,[2,[3,[4,[5,6,0]]]],8,9]""".getBytes()))
    }

    def "Solve part 1"() {
        given:
            def solver = new PairSolver()
        when:
            def answer = solver.solve(puzzle)
        then:
            answer == 13
    }

    def "Solve part 2"() {
        given:
            def solver = new DividerSolver()
        when:
            def answer = solver.solve(puzzle)
        then:
            answer == 140
    }
}
