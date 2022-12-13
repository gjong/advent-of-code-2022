package day13;

import common.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class DividerSolver implements Solution<Scanner, Integer> {
    @Override
    public Integer solve(Scanner input) {
        List<DataPacket> packets = new ArrayList<>();
        while (input.hasNextLine()) {
            var line = input.nextLine();
            if (line.isEmpty()) {
                continue;
            }

            packets.add(DataPacket.of(line));
        }

        packets.add(DataPacket.of("[[2]]"));
        packets.add(DataPacket.of("[[6]]"));

        var stringify = packets.stream()
                .sorted(DataPacket::compareTo)
                .map(Objects::toString)
                .toList();

        var idxSep2 = stringify.indexOf("[[2]]") + 1;
        var idxSep6 = stringify.indexOf("[[6]]") + 1;

        return idxSep2 * idxSep6;
    }
}
