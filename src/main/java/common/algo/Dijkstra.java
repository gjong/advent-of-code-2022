package common.algo;

import common.geometry.Point;

import java.util.*;
import java.util.function.BiPredicate;

public class Dijkstra<T> {

    private final Map<Point, T> grid;
    private final BiPredicate<T, T> visitAllowed;

    public Dijkstra(BiPredicate<T, T> visitAllowed) {
        this.grid = new HashMap<>();
        this.visitAllowed = visitAllowed;
    }

    public void addLocation(Point location, T value) {
        grid.put(location, value);
    }

    public int resolve(Point start, Point end) {
        Objects.requireNonNull(start, "Start cannot be null.");
        Objects.requireNonNull(end, "End cannot be null.");
        assert grid.containsKey(start) && grid.containsKey(end);

        var visited = new HashMap<Point, Integer>();
        visited.put(start, 0);

        var processing = new PriorityQueue<Point>(Comparator.comparingInt(visited::get));
        processing.add(start);
        while (!processing.isEmpty()) {
            var current = processing.poll();
            if (current.equals(end)) {
                return visited.get(end);
            }

            current.neighbours()
                    .stream()
                    .filter(p -> !visited.containsKey(p))
                    .filter(grid::containsKey)
                    .filter(p -> visitAllowed.test(grid.get(current), grid.get(p)))
                    .forEach(p -> {
                        visited.put(p, visited.get(current) + 1);
                        processing.add(p);
                    });
        }

        throw new IllegalStateException("Could not find a route from start to end.");
    }
}
