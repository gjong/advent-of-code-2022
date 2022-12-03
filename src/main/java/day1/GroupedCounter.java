package day1;

import common.Solution;

import java.util.stream.Stream;

public class GroupedCounter implements Solution<String, Integer> {
    @Override
    public Integer solve(String input) {
        return Math.abs(Stream.of(input.split("\n\n"))
                .mapToInt(calories -> Stream.of(calories.split("\n"))
                        .mapToInt(Integer::valueOf)
                        .sum())
                .map(i -> -i)
                .sorted()
                .limit(3)
                .sum());
    }
}
