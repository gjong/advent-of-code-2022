package day8;

import common.Solution;

import java.util.List;

import static java.lang.Integer.parseInt;

public class TreeTopVisibility implements Solution<List<String>, Integer> {

    @Override
    public Integer solve(List<String> input) {
        HighestTree[][] highestTree = new HighestTree[input.size()][input.get(0).length()];
        var mostRightTreeIdx = highestTree[0].length - 1;
        var mostBottomTreeIdx = highestTree.length - 1;

        for (var row = 0; row < input.size(); row++) {
            var treeValues = input.get(row).split("");
            for (var column = 0; column < input.get(0).length(); column++) {
                var value = parseInt(treeValues[column]);

                if (row == 0 || row == mostBottomTreeIdx || column == 0 || column == mostRightTreeIdx) {
                    highestTree[row][column] = new HighestTree(value);
                } else {
                    highestTree[row][column] = new HighestTree(
                            highestTree[row][column - 1],
                            highestTree[row - 1][column],
                            value);
                }
            }
        }

        var visibleTrees = (input.size() * 2) + ((highestTree[0].length - 2) * 2);
        for (var row = input.size() - 2; row > 0; row--) {
            for (var column = highestTree[0].length - 2; column > 0; column--) {
                var treeHeight = highestTree[row][column];

                treeHeight.correct(
                        highestTree[row][column + 1],
                        highestTree[row + 1][column]);

                if (treeHeight.isHighest()) {
                    visibleTrees++;
                }
            }
        }

        return visibleTrees;
    }
}
