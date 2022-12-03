package day2;

import common.Solution;

import java.util.List;

public class RockPaperScissorsResult implements Solution<List<String>, Integer> {
    @Override
    public Integer solve(List<String> input) {
        return input.stream()
                .mapToInt(line -> solveLine(line.split("\s")))
                .sum();
    }

    private int solveLine(String[] split) {
        var elfMove     = split[0].charAt(0) - 64;
        var matchResult = split[1].charAt(0) - 89;

        var move = computeMove(elfMove + matchResult);

        if (matchResult == 0) {
            return 3 + move;
        }
        if (matchResult == 1) {
            return 6 + move;
        }
        return move;
    }

    private int computeMove(int move) {
        return switch (move) {
            case 4 -> 1;
            case 0 -> 3;
            default -> move;
        };
    }
}
