package day10;

import common.Solution;

import java.util.Scanner;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

public class SignalStrengthSolver implements Solution<Scanner, Integer> {

    private static final int MAX_CYCLE = 220;
    public static final String ADD_INST = "addx ";

    @Override
    public Integer solve(Scanner input) {
        var answer = 0;
        var x = 1;
        var cycle = 0;
        while (cycle <= MAX_CYCLE && input.hasNextLine()) {
            var instruction = input.nextLine();
            var instructionCost = 1;
            var addition = 0;

            if (instruction.startsWith(ADD_INST)) {
                addition = parseInt(instruction.substring(ADD_INST.length()));
                instructionCost = 2;
            }

            var interestedInCycle = cycleOfInterest(cycle, instructionCost);
            if (interestedInCycle > -1) {
                answer += x * interestedInCycle;
            }

            x += addition;
            cycle += instructionCost;
        }
        return answer;
    }

    private int cycleOfInterest(int cycle, int nextCost) {
        // interested in 20, 60, 100, 140, 180, 220
        return Stream.of(20, 60, 100, 140, 180, 220)
                .filter(x -> cycle < x && (cycle + nextCost) >= x)
                .findFirst()
                .orElse(-1);
    }
}
