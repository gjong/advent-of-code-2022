

import common.Solution
import day5.CrateMover9000
import day5.SupplyStacks
import spock.lang.Specification

class Day05Test extends Specification {

    def "Solve Part #part"(Solution<Scanner, String> solver, String expected) {
        given:
            def puzzle = new Scanner(new ByteArrayInputStream("""    [D]    
[N] [C]    
[Z] [M] [P]
 1   2   3 

move 1 from 2 to 1
move 3 from 1 to 3
move 2 from 2 to 1
move 1 from 1 to 2""".getBytes()))
        when:
            def answer = solver.solve(puzzle)
        then:
            answer == expected

        where:
            part | solver | expected
            1 | new SupplyStacks()   | "CMZ"
            2 | new CrateMover9000() | "MCD"
    }
}
