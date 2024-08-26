package net.amch.labs.rover;

import java.util.Optional;

import static net.amch.labs.rover.Direction.*;

public class Rover {

    private final Grid grid;

    Direction direction = NORTH;
    Coordinate coordinate = new Coordinate(0, 0);

    public Rover(Grid grid) {
        this.grid = grid;
    }

    public String execute(String command) {
        String obstacle = "";
        for (char action : command.toCharArray()) {
            if (action == 'R') {
                direction = direction.right();
            }
            if (action == 'L') {
                direction = direction.left();
            }
            if (action == 'M') {
                obstacle = move();
            }

        }
        return "%s%d:%d:%s".formatted( obstacle, coordinate.x(), coordinate.y(), direction.value());
    }

    private String move() {
        Optional<Coordinate> nextCoordinate = grid.nextCoordinate(coordinate, direction);
        nextCoordinate.ifPresent(nc -> coordinate = nc);
        return nextCoordinate.isPresent() ? "" : "O:";
    }



}
