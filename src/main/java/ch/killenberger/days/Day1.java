package ch.killenberger.days;

import ch.killenberger.abstracts.AbstractDay;
import ch.killenberger.interfaces.Day;
import ch.killenberger.utils.ListUtil;

import java.io.IOException;
import java.util.List;

// Sonar Sweep
public class Day1 extends AbstractDay implements Day<Integer> {
    public Day1(final String day) {
        super(day);
    }

    @Override
    public Integer run() throws IOException {
        checkInputFile();

        final List<String>  lines        = readInput();
        final List<Integer> measurements = ListUtil.convertToIntegerList(lines);

        return countIncreasedMeasurements(measurements);
    }

    private Integer countIncreasedMeasurements(final List<Integer> measurements) {
        Integer previous = null;
        int count    = 0;

        for(Integer i : measurements) {
            if(previous != null && i > previous) {
                count++;
            }

            previous = i;
        }

        return count;
    }
}
