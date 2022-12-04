package day4


import spock.lang.Specification

class CleanupCampAnyOverlapTest extends Specification {
    def "Solve sample"() {
        given:
            def solution = new CleanupCampAnyOverlap()
        when:
            def answer = solution.solve(new Scanner(new ByteArrayInputStream("""
2-4,6-8
2-3,4-5
5-7,7-9
2-8,3-7
6-6,4-6
2-6,4-8""".getBytes())))
        then:
            answer == 4
    }
}
