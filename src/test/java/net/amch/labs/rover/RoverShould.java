package net.amch.labs.rover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static java.util.List.of;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


class RoverShould {

    private Rover rover;

    @BeforeEach
    void initialise() {
        Grid grid = new Grid();
        rover = new Rover(grid);
    }

    @ParameterizedTest
    @CsvSource({
            "R, 0:0:E",
            "RR, 0:0:S",
            "RRR, 0:0:W",
            "RRRR, 0:0:N"
    })
    void
    rotate_right(String command, String position) {

        assertThat(rover.execute(command), is(position));

    }

    @ParameterizedTest
    @CsvSource({
            "L, 0:0:W",
            "LL, 0:0:S",
            "LLL, 0:0:E",
            "LLLL, 0:0:N"
    })
    void
    rotate_left(String command, String position) {

        assertThat(rover.execute(command), is(position));

    }

    @ParameterizedTest
    @CsvSource({
            "M, 0:1:N",
            "MMM, 0:3:N"
    })
    void
    move_up(String command, String position) {
        assertThat(rover.execute(command), is(position));
    }

    @ParameterizedTest
    @CsvSource({
            "MMMMMMMMMM, 0:0:N",
            "MMMMMMMMMMMMMMMMMMMM, 0:0:N"
    })
    void
    wrap_from_top_to_buttom(String command, String position) {
        assertThat(rover.execute(command), is(position));
    }


    @ParameterizedTest
    @CsvSource({
            "RM, 1:0:E",
            "RMMMMM, 5:0:E"
    })
    void
    move_right(String command, String position) {
        assertThat(rover.execute(command), is(position));
    }

    @ParameterizedTest
    @CsvSource({
            "RMMMMMMMMMM, 0:0:E",
            "RMMMMMMMMMMM, 1:0:E"
    })
    void
    wrap_from_right_to_left_when_moving_east(String commands, String position) {
        assertThat(rover.execute(commands), is(position));
    }

    @ParameterizedTest
    @CsvSource({
            "LM, 9:0:W",
            "RMLLM, 0:0:W",
            "LMMMM, 6:0:W",
    })
    void
    move_left(String commands, String position) {
        assertThat(rover.execute(commands), is(position));
    }
    @ParameterizedTest
    @CsvSource({
            "LLM, 0:9:S",
            "RRMMMMM, 0:5:S",
    })
    void
    move_south(String commands, String position) {
        assertThat(rover.execute(commands), is(position));
    }

    @ParameterizedTest
    @CsvSource({
            "MMMM, O:0:3:N",
            "RMMMMMM, O:1:0:E"
    })
   void stop_at_obstacle(String commands, String position) {
        Coordinate obstacle_0x4 = new Coordinate(0, 4);
        Coordinate obstacle_2x0 = new Coordinate(2, 0);
        Grid grid = new Grid(of(obstacle_0x4, obstacle_2x0));
        Rover rover = new Rover(grid);

        assertThat(rover.execute(commands), is(position));
    }
}
