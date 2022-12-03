package day2;

import common.Solution;

import java.util.List;

public class RockPaperScissors implements Solution<List<String>, Integer> {

    @Override
    public Integer solve(List<String> input) {
        return input.stream()
                .mapToInt(line -> solveLine(line.split("\s")))
                .sum();
    }

    private int solveLine(String[] split) {
        var elfMove = split[0].charAt(0) - 64;
        var myMove = split[1].charAt(0) - 87;

        if (elfMove == myMove) {
            return 3 + myMove;
        }

        var winningMove = (elfMove + 1) % 4;
        if (winningMove == 0) {
            winningMove = 1;
        }

        if (winningMove == myMove) {
            return 6 + myMove;
        }

        return myMove;
    }
}
