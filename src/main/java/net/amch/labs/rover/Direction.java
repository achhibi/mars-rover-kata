package net.amch.labs.rover;

import java.util.Arrays;

enum Direction {

    NORTH("N", "E", "W"),
    EAST("E", "S", "N"),
    SOUTH("S", "W", "E"),
    WEST("W", "N", "S");

    private final String value;
    private  final String right;
    private final String left;

    Direction(String value, String right, String left) {
        this.value = value;
        this.right = right;
        this.left = left;
    }

    String value() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    Direction right() {
        return getDirection(this.right);
    }

    Direction left() {
        return getDirection(this.left);
    }

    private static Direction getDirection(String rotation) {
        return Arrays.stream(values())
                .filter(direction -> direction.value.equals(rotation))
                .findFirst()
                .orElseThrow();
    }
}