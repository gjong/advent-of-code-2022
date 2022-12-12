package day12;

import common.Solution;
import common.algo.Dijkstra;
import common.geometry.Point;

import java.util.*;

public class PathSolver implements Solution<List<String>, Integer> {

    @Override
    public Integer solve(List<String> input) {
        Point start = null, end = null;
        var dijkstra = new Dijkstra<>(this::visitAllowed);
        for (var row = 0; row < input.size(); row++) {
            if (input.get(row).isBlank()) {
                continue;
            }
            var line = input.get(row);
            for (var column = 0; column < line.length(); column++) {
                var character = line.charAt(column);
                var location = new Point(column, row);
                if (character == 'S') {
                    start = location;
                    character = 'a';
                }
                if (character == 'E') {
                    end = location;
                    character = 'z';
                }

                dijkstra.addLocation(location, character);
            }
        }

        return dijkstra.resolve(start, end);
    }

    private boolean visitAllowed(Character from, Character to) {
        return to - from <= 1;
    }

}
