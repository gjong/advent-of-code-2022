package day9;

import common.geometry.Point;
import common.Solution;
import common.geometry.Vector;

import java.util.*;

public class RopeSolver implements Solution<Scanner, Integer> {

    private final Rope rope;

    public RopeSolver(int ropeLength) {
        this.rope = new Rope(ropeLength);
    }

    @Override
    public Integer solve(Scanner input) {
        var tailVisits = new HashSet<>();
        while (input.hasNextLine()) {
            var instruction = Instruction.ofLine(input.nextLine());

            var deltaPoint = instruction.direction().getTranslation();
            for (var step = 0; step < instruction.stepSize(); step++) {
                rope.move(deltaPoint);
                tailVisits.add(rope.tail());
            }
        }

        return tailVisits.size();
    }

    private static class Rope {

        private final Point[] knots;

        Rope(int length) {
            knots = new Point[length];
            Arrays.fill(knots, Point.zero);
        }

        void move(Point translation) {
            knots[0] = knots[0].translate(translation);
            for (var knotIdx = 1; knotIdx < knots.length; knotIdx++) {
                var knot = knots[knotIdx];
                var previousKnot = knots[knotIdx - 1];
                if (!knot.touches(previousKnot)) {
                    var vector = new Vector(knot, previousKnot);
                    knots[knotIdx] = knot.translate(vector.direction());
                }
            }
        }

        Point tail() {
            return knots[knots.length - 1];
        }
    }
}
