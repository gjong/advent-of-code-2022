package day3;

import common.Solution;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupedRucksack implements Solution<List<String>, Integer> {
    @Override
    public Integer solve(List<String> input) {
        var groups = input.size() / 3;

        var solution = 0;
        for (var group = 0; group < groups; group++) {
            solution += solveGroup(
                    input.subList(group * 3, (group + 1) *3));
        }

        return solution;
    }

    private int solveGroup(List<String> rucksacks) {
        var overlap = overlap(
                rucksacks.get(0),
                rucksacks.get(1)
        ).collect(Collectors.joining());

        return overlap(overlap, rucksacks.get(2))
                .mapToInt(this::computeScore)
                .limit(1)
                .sum();
    }

    private Stream<String> overlap(String rucksackOne, String rucksackTwo) {
        var rightElements = List.of(rucksackOne.split(""));

        return Stream.of(rucksackTwo.split(""))
                .filter(rightElements::contains);
    }

    private int computeScore(String item) {
        var value = item.charAt(0);

        if (value >= 'A' && value <= 'Z') {
            return value - 'A' + 27;
        }

        return value - 'a' + 1;
    }
}
