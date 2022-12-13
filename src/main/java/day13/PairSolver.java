package day13;

import common.Solution;

import java.util.Scanner;

public class PairSolver implements Solution<Scanner, Integer> {
    @Override
    public Integer solve(Scanner input) {
        var pairIdx = 1;
        DataPacket leftPacket = null, rightPacket = null;

        var result = 0;
        while (input.hasNextLine()) {
            var line = input.nextLine();
            if (line.isEmpty()) {
                // compare the packets
                if (leftPacket.compareTo(rightPacket) < 0) {
                    result += pairIdx;
                }

                leftPacket = null;
                rightPacket = null;
                pairIdx++;
            } else {
                if (leftPacket == null) {
                    leftPacket = DataPacket.of(line);
                } else {
                    rightPacket = DataPacket.of(line);
                }
            }
        }

        return result;
    }
}
