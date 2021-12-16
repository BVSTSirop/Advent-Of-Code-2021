package ch.killenberger.days;

import ch.killenberger.CumulativeMap;
import ch.killenberger.abstracts.AbstractDay;
import ch.killenberger.interfaces.Day;

import java.io.IOException;
import java.util.List;
import java.util.Map;

// Sonar Sweep
public class Day2Part2 extends AbstractDay implements Day<Integer> {
    private static final String FORWARD = "forward";
    private static final String UP      = "up";
    private static final String DOWN    = "down";

    public int aim        = 0;
    public int horizontal = 0;
    public int depth      = 0;

    public Day2Part2(final String day) {
        super(day);
    }

    @Override
    public Integer run() throws IOException {
        checkInputFile();

        final List<String> lines       = readInput();

        for(String s : lines) {
            final String[] splits    = s.split(" ");
            final String   direction = splits[0];
            final int      increase  = Integer.valueOf(splits[1]);

            if(FORWARD.equals(direction)) {
                this.horizontal += increase;
                this.depth += aim * increase;
            } else if (UP.equals(direction)) {
                this.aim -= increase;
            } else if (DOWN.equals(direction)) {
                this.aim += increase;
            } else {
                throw new RuntimeException("Unexpected direction: " + direction);
            }
        }

        return horizontal * depth;
    }
}
