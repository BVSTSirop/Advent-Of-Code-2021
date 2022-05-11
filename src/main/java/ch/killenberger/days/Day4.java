package ch.killenberger.days;

import ch.killenberger.CumulativeMap;
import ch.killenberger.abstracts.AbstractDay;
import ch.killenberger.interfaces.Day;

import java.io.IOException;
import java.util.List;

// Sonar Sweep
public class Day4 extends AbstractDay implements Day<Integer> {
    public Day4(final String day) {
        super(day);
    }

    @Override
    public Integer run() throws IOException {
        checkInputFile();

        final List<String> lines = readInput();

        return -1;
    }
}
