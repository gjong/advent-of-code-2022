package day14;

import common.geometry.Point;

import java.util.List;
import java.util.Set;

public class SandMover {

    private static final Point DROP_POINT = Point.of(500, 0);
    private static final List<Point> TRANSLATIONS = List.of(Point.of(0, 1), Point.of(-1, 1), Point.of(1, 1));

    public Point drop(int lowestY, Set<Point> blockedPoints) {
        var sandPos = DROP_POINT;

        while (sandPos.y() <= lowestY) {
            var changed = false;
            for (var translation : TRANSLATIONS) {
                var translated = sandPos.translate(translation);
                if (!blockedPoints.contains(translated)) {
                    sandPos = translated;
                    changed = true;
                    break;
                }
            }

            if (!changed) {
                return sandPos;
            }
        }

        return null;
    }
}
