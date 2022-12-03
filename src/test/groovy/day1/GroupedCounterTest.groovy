package day1

import spock.lang.Specification

class GroupedCounterTest extends Specification {
    def "Solve sample"() {
        given:
            def solution = new GroupedCounter()
        when:
            def answer = solution.solve("""1000
2000
3000

4000

5000
6000

7000
8000
9000

10000""")
        then:
            answer == 45000
    }
}
