package day6

import spock.lang.Specification

class TuningTroubleTest extends Specification {
    def "Solve sample 1"() {
        given:
            var solution = new TuningTrouble(4)
        when:
            var answer = solution.solve("mjqjpqmgbljsphdztnvjfqwrcgsmlb")
        then:
            answer == 7
    }

    def "Solve sample 2"() {
        given:
            var solution = new TuningTrouble(4)
        when:
            var answer = solution.solve("nppdvjthqldpwncqszvftbrmjlhg")
        then:
            answer == 6
    }

    def "Solve sample 3"() {
        given:
            var solution = new TuningTrouble(4)
        when:
            var answer = solution.solve("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg")
        then:
            answer == 10
    }


    def "Solve sample 4"() {
        given:
            var solution = new TuningTrouble(4)
        when:
            var answer = solution.solve("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw")
        then:
            answer == 11
    }

    def "Solve part 2 sample 1"() {
        given:
            var solution = new TuningTrouble(14)
        when:
            var answer = solution.solve("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw")
        then:
            answer == 26
    }

    def "Solve part 2 sample 2"() {
        given:
            var solution = new TuningTrouble(14)
        when:
            var answer = solution.solve("mjqjpqmgbljsphdztnvjfqwrcgsmlb")
        then:
            answer == 19
    }
}
