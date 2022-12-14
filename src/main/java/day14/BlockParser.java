package day14;

import common.geometry.Point;
import common.geometry.Vector;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static java.lang.Integer.parseInt;

class BlockParser {

    private final Scanner scanner;
    private final Set<Point> blockedPoints;
    private int lowestY;

    private BlockParser(Scanner scanner) {
        this.scanner = scanner;
        this.lowestY = 0;
        this.blockedPoints = new HashSet<>();
        this.parse();
    }

    private void parse() {
        while (scanner.hasNextLine()) {
            var points = scanner.nextLine().split(" -> ");

            Point lastPoint = null;
            for (var point : points) {
                var coords = point.split(",");
                var currentPoint = Point.of(parseInt(coords[0]), parseInt(coords[1]));

                if (lowestY < currentPoint.y()) {
                    lowestY = currentPoint.y();
                }

                if (lastPoint != null) {
                    blockedPoints.addAll(new Vector(lastPoint, currentPoint).pointsInVector());
                }
                lastPoint = currentPoint;
            }
        }
    }

    public int getLowestY() {
        return lowestY;
    }

    public Set<Point> getBlockedPoints() {
        return blockedPoints;
    }

    public static BlockParser of(Scanner scanner) {
        return new BlockParser(scanner);
    }
}
