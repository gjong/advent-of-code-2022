package day6;

import common.Solution;

import java.util.LinkedList;

public class TuningTrouble implements Solution<String, Integer> {

    private final int uniqueCharsRequired;

    public TuningTrouble(int uniqueCharsRequired) {
        this.uniqueCharsRequired = uniqueCharsRequired;
    }

    @Override
    public Integer solve(String input) {
        var investigate = new LinkedList<Character>();

        var letterIdx = 1;
        for (var letter : input.toCharArray()) {
            investigate.add(letter);
            if (investigate.size() > uniqueCharsRequired) {
                investigate.poll();
            }

            if (isAllUnique(investigate)) {
                return letterIdx;
            }
            letterIdx++;
        }
        return -1;
    }

    private boolean isAllUnique(LinkedList<?> entries) {
        return entries.stream().distinct().count() == uniqueCharsRequired;
    }
}
