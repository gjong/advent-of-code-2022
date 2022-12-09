package day9

import spock.lang.Specification

class Day9Test extends Specification {
    def "Solve sample - part 1"() {
        given:
            def solution = new RopeSolver(2)
        when:
            def puzzle = new Scanner(new ByteArrayInputStream("""R 4
U 4
L 3
D 1
R 4
D 1
L 5
R 2""".getBytes()))
            def answer = solution.solve(puzzle)
        then:
            answer == 13
    }

    def "Solve sample - part 2"() {
        given:
            def solution = new RopeSolver(10)
        when:
            def puzzle = new Scanner(new ByteArrayInputStream("""R 4
U 4
L 3
D 1
R 4
D 1
L 5
R 2""".getBytes()))
            def answer = solution.solve(puzzle)
        then:
            answer == 1
    }

    def "Solve sample 2 - part 2"() {
        given:
            def solution = new RopeSolver(10)
        when:
            def puzzle = new Scanner(new ByteArrayInputStream("""R 5
U 8
L 8
D 3
R 17
D 10
L 25
U 20""".getBytes()))
            def answer = solution.solve(puzzle)
        then:
            answer == 36
    }
}
