package day9;

import common.Point;
import common.Solution;

import java.util.*;

public class Rope10Solver implements Solution<Scanner, Integer> {

    @Override
    public Integer solve(Scanner input) {
        var rope = new Point[10];
        var tailVisits = new HashSet<>();

        Arrays.fill(rope, Point.zero);
        while (input.hasNextLine()) {
            var instruction = Instruction.fromLine(input.nextLine());

            var deltaPoint = new Point(instruction.deltaX(), instruction.deltaY());
            for (var step = 0; step < instruction.stepSize(); step++) {
                rope[0] = rope[0].translate(deltaPoint);
                for (var knotIdx = 1; knotIdx < rope.length; knotIdx++) {
                    if (!rope[knotIdx].touches(rope[knotIdx - 1])) {
                        rope[knotIdx] = rope[knotIdx].translate(
                                (int) Math.signum(rope[knotIdx - 1].x() - rope[knotIdx].x()),
                                (int) Math.signum(rope[knotIdx - 1].y() - rope[knotIdx].y()));
                    }
                }

                tailVisits.add(rope[rope.length - 1]);
            }
        }

        return tailVisits.size();
    }
}
