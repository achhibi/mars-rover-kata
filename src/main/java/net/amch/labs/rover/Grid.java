package net.amch.labs.rover;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


public class Grid {
    private static final int MAX_HEIGHT = 10;
    private static final int MAX_WIDTH = 10;

    private List<Coordinate> obstacles = Collections.emptyList();

    Grid() {
    }

    Grid(List<Coordinate> obstacles) {
        this.obstacles = obstacles;
    }

    Optional<Coordinate> nextCoordinate(Coordinate coordinate, Direction direction) {
        int x = coordinate.x();
        int y = coordinate.y();

        switch (direction) {
            case NORTH -> y = (y + 1) % MAX_HEIGHT;
            case EAST -> x = (x + 1) % MAX_WIDTH;
            case WEST -> x = (x + MAX_WIDTH - 1) % MAX_WIDTH;
            case SOUTH -> y = (y + MAX_HEIGHT - 1) % MAX_HEIGHT;
        }


        Coordinate newCoordinate = new Coordinate(x, y);


        return obstacles.contains(newCoordinate)
                ? Optional.empty()
                : Optional.of(newCoordinate);
    }

}
