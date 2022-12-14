package day1;

import common.Solution;

import java.util.stream.Stream;

public class CalorieCounting implements Solution<String, Integer> {

    @Override
    public Integer solve(String input) {
        return Stream.of(input.split("\n\n"))
                .mapToInt(calories -> Stream.of(calories.split("\n"))
                        .mapToInt(Integer::valueOf)
                        .sum())
                .max()
                .orElse(0);
    }

}
