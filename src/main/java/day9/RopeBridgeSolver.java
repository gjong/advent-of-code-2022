package day9;

import common.Point;
import common.Solution;

import java.util.HashSet;
import java.util.Scanner;

public class RopeBridgeSolver implements Solution<Scanner, Integer> {

    @Override
    public Integer solve(Scanner input) {
        var tailVisits = new HashSet<>();

        var head = new Point(0, 0);
        var tail = new Point(0, 0);
        while (input.hasNextLine()) {
            var instruction = Instruction.fromLine(input.nextLine());

            for (var move = 0; move < instruction.stepSize(); move++) {
                var newHead = new Point(
                        head.x() + instruction.deltaX(),
                        head.y() + instruction.deltaY());
                if (!newHead.touches(tail)) {
                    tailVisits.add(tail);
                    tail = head;
                }
                head = newHead;
            }
        }
        return tailVisits.size() + 1;
    }
}
