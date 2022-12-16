package day15;

import common.Solution;
import common.geometry.Point;
import common.geometry.Vector;

import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class BeaconZoneSolver implements Solution<Scanner, Integer> {

    private static final Pattern BEACON_PATTERN = Pattern.compile("Sensor at x=(?<x>\\d+), y=(?<y>\\d+): closest beacon is at x=(?<bx>\\d+), y=(?<by>\\d+)");

    private final int yOfInterest;

    public BeaconZoneSolver(int yOfInterest) {
        this.yOfInterest = yOfInterest;
    }

    @Override
    public Integer solve(Scanner input) {
        var noBeaconPossible = new HashSet<Point>();
        while (input.hasNextLine()) {
            var matcher = BEACON_PATTERN.matcher(input.nextLine());
            if (matcher.find()) {
                var sensorPoint = Point.of(
                        parseInt(matcher.group("x")),
                        parseInt(matcher.group("y")));
                var beaconPoint = Point.of(
                        parseInt(matcher.group("bx")),
                        parseInt(matcher.group("by")));

                var dx = beaconPoint.x() - sensorPoint.x();
                var dy = beaconPoint.y() - sensorPoint.y();
                var maxSteps = Math.abs(dx) + Math.abs(dy);

                if (inPlane(sensorPoint, yOfInterest - maxSteps, yOfInterest + maxSteps)) {
                    // the area covered actually touches the Y axis we are interested in
                    dy = sensorPoint.y() + maxSteps;
                    if (sensorPoint.y() > yOfInterest) {
                        dy = sensorPoint.y() - maxSteps;
                    }

                    var edge = new Vector(
                            Point.of(sensorPoint.x() - maxSteps, sensorPoint.y()),
                            Point.of(sensorPoint.x(), dy));
                    var intersect = edge.intersectY(yOfInterest);
                    var translated = intersect.translate((sensorPoint.x() - intersect.x()) * 2, 0);
                    noBeaconPossible.addAll(new Vector(intersect, translated).pointsInVector());
                }
            }
        }

        return noBeaconPossible.size() - 1;
    }

    private boolean inPlane(Point point, int minY, int maxY) {
        return point.y() >= minY && point.y() <= maxY;
    }
}
