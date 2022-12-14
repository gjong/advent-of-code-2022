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

        var droppedSand = 0;
        while (true) {
            var sandPos = DROP_POINT;

            while (sandPos.y() < (bottom - 1)) {
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

            if (sandPos.y() == (bottom - 1)) {
                // blocked by bottom
                blockedPoints.add(sandPos);
            }

            if (sandPos.equals(DROP_POINT)) {
                break;
            } else {
                droppedSand++;
            }
        }

        return droppedSand + 1;
    }
}
