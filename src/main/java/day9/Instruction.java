package day9;

import static java.lang.Integer.parseInt;

record Instruction(Direction direction, int stepSize) {

    static Instruction ofLine(String line) {
        var split = line.split(" ");
        return new Instruction(
                Direction.valueOf(split[0]),
                parseInt(split[1]));
    }
}
