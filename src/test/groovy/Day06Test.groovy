import day6.TuningTrouble
import spock.lang.Specification

class Day06Test extends Specification {

    def "Solve #part - Example #example"(int uniqueChars, String puzzle, int expectedAnswer) {
        given:
            def solver = new TuningTrouble(uniqueChars)
        when:
            def answer = solver.solve(puzzle)
        then:
            answer == expectedAnswer

        where:
            part | example | uniqueChars | puzzle | expectedAnswer
            1 | 1 | 4 | "mjqjpqmgbljsphdztnvjfqwrcgsmlb" | 7
            1 | 2 | 4 | "nppdvjthqldpwncqszvftbrmjlhg" | 6
            1 | 3 | 4 | "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg" | 10
            1 | 4 | 4 | "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw" | 11
            2 | 1 | 14 | "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw" | 26
            2 | 2 | 14 | "mjqjpqmgbljsphdztnvjfqwrcgsmlb" | 19
    }
}
