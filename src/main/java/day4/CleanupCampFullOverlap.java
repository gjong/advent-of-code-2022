package day4;

import common.Solution;

import java.util.Scanner;

public class CleanupCampFullOverlap implements Solution<Scanner, Integer> {
    @Override
    public Integer solve(Scanner input) {

        var overlapped = 0;
        while (input.hasNextLine()) {
            var sections = input.nextLine().split(",");
            if (sections.length != 2) continue;

            var range1 = parseRange(sections[0]);
            var range2 = parseRange(sections[1]);

            if (fullOverlapped(range1, range2) || fullOverlapped(range2, range1)) {
                overlapped++;
            }
        }

        return overlapped;
    }

    private boolean fullOverlapped(int[] first, int[] second) {
        return first[1] <= second[1] && first[0] >= second[0];
    }

    private int[] parseRange(String range) {
        var rawRange = range.split("-");
        return new int[] {
                Integer.valueOf(rawRange[0]),
                Integer.valueOf(rawRange[1])
        };
    }
}
