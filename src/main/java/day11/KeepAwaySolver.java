package day11;

import common.Solution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

public class KeepAwaySolver implements Solution<String, Long> {
    private int numberOfRounds;
    private WorryResolver worryReducer;

    public KeepAwaySolver(int numberOfRounds, WorryResolver worryReducer) {
        this.numberOfRounds = numberOfRounds;
        this.worryReducer = worryReducer;
    }

    @Override
    public Long solve(String input) {
        var monkeyStrings = input.split("\n\n");
        var monkeys = Stream.of(monkeyStrings)
                .map(raw -> Monkey.of(raw, worryReducer))
                .toList();
        var maxNumber = monkeys.stream()
                .mapToLong(m -> m.getResolution().divisible())
                .reduce((left, right) -> left * right)
                .orElse(1);

        for (var round = 0; round < numberOfRounds; round++) {
            for (var monkey : monkeys) {
                monkey.processRound()
                        .forEach(instruction ->
                                monkeys.get(instruction.toMonkey())
                                        .addWorry(instruction.worryLevel() % maxNumber));
            }
        }

        return monkeys.stream()
                .map(Monkey::getNumberOfInspections)
                .map(x -> -x)
                .sorted()
                .limit(2)
                .map(Math::abs)
                .reduce((left, right) -> left * right)
                .orElse(0L);
    }
}
