package ch.killenberger.days;

import ch.killenberger.interfaces.Day;
import ch.killenberger.utils.FileUtil;
import ch.killenberger.utils.ListUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

// Sonar Sweep
public class Day1 implements Day<Integer> {
    private final File inputFile;

    public Day1(final String inputPath) {
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

        final List<String> lines =  Files.readAllLines(this.inputFile.toPath());
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
