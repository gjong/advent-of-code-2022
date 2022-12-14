package day14;

import common.Solution;
import common.geometry.Point;

import java.util.Scanner;

public class SandWithFloorSolver implements Solution<Scanner, Integer> {
    private static final Point DROP_POINT = Point.of(500, 0);

    @Override
    public Integer solve(Scanner input) {
        var parser = BlockParser.of(input);
        var blockedPoints = parser.getBlockedPoints();
        int bottom = parser.getLowestY() + 2;

        // bottom needs to be no wider then the triangle from drop point to bottom + 1
        var width = (int) Math.ceil(bottom * Math.tan(45)) + 1;
        for (var x = 500 - width; x < 500 + width; x++) {
            blockedPoints.add(Point.of(x, bottom));
        }

        var sandMover = new SandMover();
        var droppedSand = 0;
        while (true) {
            var sandPos = sandMover.drop(bottom, blockedPoints);

            droppedSand++;
            blockedPoints.add(sandPos);
            if (sandPos.equals(DROP_POINT)) {
                break;
            }
        }

        return droppedSand;
    }
}
