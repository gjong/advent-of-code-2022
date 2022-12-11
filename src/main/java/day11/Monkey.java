package day11;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class Monkey {

    record Resolution(long divisible, int throwIfTrue, int throwIfFalse) {
        Instruction resolve(long worry) {
            var target = worry % divisible == 0 ? throwIfTrue : throwIfFalse;
            return new Instruction(target, worry);
        }
    }

    record Instruction(int toMonkey, long worryLevel) {}

    private List<Long> items;

    private Resolution resolution;

    private Function<Long, Long> operation;

    private WorryResolver worryReducer;

    private long numberOfInspections;

    public Monkey() {
        items = new ArrayList<>();
        numberOfInspections = 0;
    }

    public void addWorry(long worry) {
        this.items.add(worry);
    }

    public List<Instruction> processRound() {
        numberOfInspections += items.size();
        var instructions = items.stream()
                .map(x -> operation.apply(x))
                .map(worryReducer)
                .map(x -> resolution.resolve(x))
                .toList();
        items = new ArrayList<>();
        return instructions;
    }

    public long getNumberOfInspections() {
        return numberOfInspections;
    }

    public Resolution getResolution() {
        return resolution;
    }

    static Monkey of(String monkeyString, WorryResolver worryReducer) {
        var parts = monkeyString.split("\n");
        var monkey = new Monkey();

        monkey.worryReducer = worryReducer;
        monkey.items = new ArrayList<>(Stream.of(parts[1].substring(18).split(", "))
                .map(String::trim)
                .map(Long::parseLong)
                .toList());

        var operation = parts[2].substring(19).split(" ");
        monkey.operation = value -> {
            var left = "old".equals(operation[0]) ? value : parseLong(operation[0]);
            var right = "old".equals(operation[2]) ? value : parseLong(operation[2]);

            return switch (operation[1]) {
                case "+" -> left + right;
                case "-" -> left - right;
                case "*" -> left * right;
                default -> throw new IllegalArgumentException("Cannot understand " + operation[1]);
            };
        };

        var division = parseInt(parts[3].substring(21));
        var trueMonkey = parseInt(parts[4].substring(29));
        var falseMonkey = parseInt(parts[5].substring(30));
        monkey.resolution = new Resolution(division, trueMonkey, falseMonkey);

        return monkey;
    }
}
