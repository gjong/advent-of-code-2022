package day14;

import common.Solution;

import java.util.Scanner;

public class SandSolver implements Solution<Scanner, Integer> {

    @Override
    public Integer solve(Scanner input) {
        var parser = BlockParser.of(input);
        var blockedPoints = parser.getBlockedPoints();
        int lowestY = parser.getLowestY();

        var sandMover = new SandMover();
        var droppedSand = 0;
        var blockedDrop = true;
        while (blockedDrop) {
            // drop sand
            var sandPos = sandMover.drop(lowestY, blockedPoints);
            if (sandPos != null) {
                blockedPoints.add(sandPos);
                droppedSand++;
            }

            blockedDrop = sandPos != null;
        }

        return droppedSand;
    }
}
