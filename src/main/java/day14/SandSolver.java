package day14;

import common.Solution;
import common.geometry.Point;

import java.util.Scanner;

public class SandSolver implements Solution<Scanner, Integer> {

    private static final Point DROP_POINT = Point.of(500, 0);

    @Override
    public Integer solve(Scanner input) {
        var parser = BlockParser.of(input);
        var blockedPoints = parser.getBlockedPoints();
        int lowestY = parser.getLowestY();

        var droppedSand = 0;
        var blockedDrop = true;
        while (blockedDrop) {
            // drop sand
            var sandPos = DROP_POINT;

            while (sandPos.y() <= lowestY) {
                var downPos = sandPos.translate(0, 1);
                if (!blockedPoints.contains(downPos)) {
                    sandPos = downPos;
                    continue;
                }
                var vertLeft = sandPos.translate(-1, 1);
                if (!blockedPoints.contains(vertLeft)) {
                    sandPos = vertLeft;
                    continue;
                }
                var vertRight = sandPos.translate(1, 1);
                if (!blockedPoints.contains(vertRight)) {
                    sandPos = vertRight;
                    continue;
                }

                // no position change possible
                blockedPoints.add(sandPos);
                break;
            }

            blockedDrop = sandPos.y() <= lowestY;
            if (blockedDrop) {
                droppedSand++;
            }
        }

        return droppedSand;
    }
}
