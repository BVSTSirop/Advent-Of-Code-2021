package ch.killenberger.days;

import ch.killenberger.abstracts.AbstractDay;
import ch.killenberger.interfaces.Day;
import ch.killenberger.utils.ListUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

// Sonar Sweep
public class Day1Part2 extends AbstractDay implements Day<Integer> {
    public Day1Part2(final String day) {
        super(day);
    }

    @Override
    public Integer run() throws IOException {
        checkInputFile();

        final List<String>  lines =  Files.readAllLines(this.inputFile.toPath());
        final List<Integer> measurements = ListUtil.convertToIntegerList(lines);

        return countIncreasedMeasurements(measurements);
    }

    private Integer countIncreasedMeasurements(final List<Integer> l) {
        final int lSize = l.size();

        int     count    = 0;
        Integer previous = null;

        for(int i = 0; i < lSize; i++) {
            final int subEndIndex = i + 3;

            if(subEndIndex <= lSize) {
                final List<Integer> sub = l.subList(i, subEndIndex);
                final Integer       sum = sub.stream().reduce(0, Integer::sum);

                if(previous != null && sum > previous) {
                    count++;
                }

                previous = sum;
            }
        }

        return count;
    }
}
