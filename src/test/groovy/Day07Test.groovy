import common.Solution
import day7.DirectoryListing
import day7.DiskCleaner
import spock.lang.Specification

class Day07Test extends Specification {
    Scanner puzzle;

    def setup() {
        puzzle = new Scanner(new ByteArrayInputStream(
                """\$ cd /
\$ ls
dir a
14848514 b.txt
8504156 c.dat
dir d
\$ cd a
\$ ls
dir e
29116 f
2557 g
62596 h.lst
\$ cd e
\$ ls
584 i
\$ cd ..
\$ cd ..
\$ cd d
\$ ls
4060174 j
8033020 d.log
5626152 d.ext
7214296 k""".getBytes()))
    }

    def "Solve sample - Part #part"(Solution<Scanner, Integer> solver, int expectedAnswer) {
        when:
            def answer = solver.solve(puzzle)
        then:
            answer == expectedAnswer

        where:
        part | solver | expectedAnswer
        1 | new DirectoryListing() | 95437
        2 | new DiskCleaner() | 24933642
    }
}
