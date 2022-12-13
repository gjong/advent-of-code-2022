package day13;

import common.Solution;

import java.util.Scanner;

public class DividerSolver implements Solution<Scanner, Integer> {
    @Override
    public Integer solve(Scanner input) {
        var smallerDiv2 = 1;
        var smallerDiv6 = 2; // starts at 2 because [[2]] is also in the list

        var dataPacketDiv2 = DataPacket.of("[[2]]");
        var dataPacketDiv6 = DataPacket.of("[[6]]");
        while (input.hasNextLine()) {
            var line = input.nextLine();
            if (line.isEmpty()) {
                continue;
            }

            var packet = DataPacket.of(line);
            if (packet.compareTo(dataPacketDiv2) < 0) smallerDiv2++;
            if (packet.compareTo(dataPacketDiv6) < 0) smallerDiv6++;
        }

        return smallerDiv2 * smallerDiv6;
    }
}
