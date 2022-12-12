package day12;

import common.Solution;
import common.algo.Dijkstra;
import common.geometry.Point;

import java.util.ArrayList;
import java.util.List;

public class PrettiestPathSolver implements Solution<List<String>, Integer> {
    @Override
    public Integer solve(List<String> input) {
        List<Point> potentialStart = new ArrayList<>();
        Point end = null;

        var dijkstra = new Dijkstra<>(this::visitAllowed);
        for (var row = 0; row < input.size(); row++) {
            if (input.get(row).isBlank()) {
                continue;
            }

            var line = input.get(row);
            for (var column = 0; column < line.length(); column++) {
                var character = line.charAt(column);
                var location = new Point(column, row);
                if (character == 'S' || character == 'a') {
                    potentialStart.add(location);
                    character = 'a';
                }
                if (character == 'E') {
                    end = location;
                    character = 'z';
                }

                dijkstra.addLocation(location, character);
            }
        }

        var finalEnd = end;
        return potentialStart.stream()
                .mapToInt(start -> dijkstra.resolve(start, finalEnd))
                .filter(v -> v > 0)
                .min()
                .orElse(-1);
    }

    private boolean visitAllowed(Character from, Character to) {
        return to - from <= 1;
    }
}
