package ch.killenberger.days;

import ch.killenberger.abstracts.AbstractDay;
import ch.killenberger.interfaces.Day;
import ch.killenberger.utils.FileUtil;
import ch.killenberger.utils.ListUtil;
import com.google.common.collect.Lists;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

// Sonar Sweep
public class Day1_2 extends AbstractDay implements Day<Integer> {
    public Day1_2(final String inputPath) {
        if(inputPath == null) {
            throw new IllegalArgumentException("Input path was null");
        }

        this.inputFile = new File(inputPath);
    }

    @Override
    public Integer run() throws IOException {
        if(!this.inputFile.exists()) {
            throw new FileNotFoundException("File " + FileUtil.getFilePath(this.inputFile) + " does not exist");
        }

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
