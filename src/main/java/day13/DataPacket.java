package day13;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class DataPacket implements Packet {

    private record SingleValue(int value) implements Packet {
        @Override
        public int compareTo(Packet o) {
            if (o instanceof DataPacket) {
                return new DataPacket(List.of(this)).compareTo(o);
            }
            if (o instanceof SingleValue casted) {
                return Integer.compare(value, casted.value);
            }

            return -1;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        static SingleValue of(char startNumber, List<Character> characters) {
            var number = String.valueOf(startNumber);
            if (characters.size() > 0 && Character.isDigit(characters.get(0))) {
                number += characters.remove(0);
            }
            return new SingleValue(parseInt(number));
        }
    }

    private final List<Packet> packets;

    private DataPacket(List<Packet> packets) {
        this.packets = packets;
    }

    @Override
    public int compareTo(Packet other) {
        if (other instanceof SingleValue) {
            return compareTo(new DataPacket(List.of(other)));
        }

        if (other instanceof DataPacket casted) {
            for (var idx = 0; idx < packets.size(); idx++) {
                if (idx >= casted.packets.size()) {
                    return 1;
                }

                var compared = packets.get(idx).compareTo(casted.packets.get(idx));
                if (compared == 0) {
                    continue;
                }
                return compared;
            }

            if (packets.size() < casted.packets.size()) {
                return -1;
            }
        }

        return 0;
    }

    @Override
    public String toString() {
        return "[%s]".formatted(
                packets.stream()
                        .map(Packet::toString)
                        .collect(Collectors.joining(","))
        );
    }

    public static DataPacket of(String line) {
        var dataPacket = line.substring(1, line.length() - 1);
        List<Character> characters = new ArrayList<>(dataPacket.length());
        for (char character : dataPacket.toCharArray())
            characters.add(character);

        return (DataPacket) parse(characters);
    }

    private static Packet parse(List<Character> characters) {
        var dataPacket = new DataPacket(new ArrayList<>());
        while (!characters.isEmpty()) {
            var nextChar = characters.remove(0);
            if (nextChar == '[') {
                dataPacket.packets.add(DataPacket.parse(characters));
            } else if (nextChar == ']') {
                return dataPacket;
            } else if (nextChar != ',') {
                dataPacket.packets.add(SingleValue.of(nextChar, characters));
            }
        }

        return dataPacket;
    }
}
