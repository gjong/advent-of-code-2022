package day9;

import common.geometry.Point;

enum Direction {
    R(new Point(1, 0)),
    U(new Point(0, -1)),
    D(new Point(0, 1)),
    L(new Point(-1, 0));
    private final Point translation;

    Direction(Point translation) {
        this.translation = translation;
    }

    public Point getTranslation() {
        return translation;
    }
}
