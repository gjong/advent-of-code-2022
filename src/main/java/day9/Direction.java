package day9;

enum Direction {
    R(1, 0),
    U(0, -1),
    D(0, 1),
    L(-1, 0);
    private int deltaX;
    private int deltaY;

    Direction(int deltaX, int deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    public int getDeltaX() {
        return deltaX;
    }

    public int getDeltaY() {
        return deltaY;
    }
}
