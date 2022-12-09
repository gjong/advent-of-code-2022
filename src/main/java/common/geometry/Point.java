package common.geometry;

public record Point(int x, int y) {

    public Point translate(Point translation) {
        return new Point(
                x + translation.x,
                y + translation.y);
    }

    public Point translate(int x, int y) {
        return new Point(
                this.x + x,
                this.y + y);
    }

    public boolean touches(Point other) {
        return (x >= (other.x - 1) && x <= (other.x + 1))
                && (y >= (other.y - 1) && y <= (other.y + 1));
    }

    public static Point zero = new Point(0, 0);

}
