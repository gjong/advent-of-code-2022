package day3;

import common.Solution;

import java.util.List;
import java.util.stream.Stream;

public class Rucksack implements Solution<List<String>, Integer> {
    @Override
    public Integer solve(List<String> input) {
        return input.stream()
                .mapToInt(this::solveLine)
                .sum();
    }

    private int solveLine(String line) {
        var compartmentSize = line.length() / 2;

        var compartmentOne = line.substring(0, compartmentSize);
        var compartmentTwo = line.substring(compartmentSize);

        return overlap(compartmentOne, compartmentTwo)
                .mapToInt(this::computeBadgeScore)
                .limit(1)
                .sum();
    }

    private Stream<String> overlap(String left, String right) {
        var rightElements = List.of(right.split(""));

        return Stream.of(left.split(""))
                .filter(rightElements::contains);
    }

    private int computeBadgeScore(String item) {
        var value = item.charAt(0);

        if (value >= 'A' && value <= 'Z') {
            return value - 'A' + 27;
        }

        return value - 'a' + 1;
    }
}
