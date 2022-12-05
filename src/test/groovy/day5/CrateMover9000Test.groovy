package day5

import spock.lang.Specification

class CrateMover9000Test extends Specification {
    def "Solve sample"() {
        given:
            def solution = new CrateMover9000()
        when:
            def answer = solution.solve(new Scanner(new ByteArrayInputStream("""    [D]    
[N] [C]    
[Z] [M] [P]
 1   2   3 

move 1 from 2 to 1
move 3 from 1 to 3
move 2 from 2 to 1
move 1 from 1 to 2""".getBytes())))
        then:
            answer == "MCD"
    }
}
