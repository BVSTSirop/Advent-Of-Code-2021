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

        final List<String>        lines =  Files.readAllLines(this.inputFile.toPath());
        final List<Integer>       measurements = ListUtil.convertToIntegerList(lines);
        final List<List<Integer>> segments = Lists.partition(measurements, 3);

        return countIncreasedMeasurements(segments);
    }

    private Integer countIncreasedMeasurements(final List<List<Integer>> measureSegments) {
        int count = 0;
        Integer previous = null;

        for(List<Integer> l : measureSegments) {
            Integer sum = l.stream().reduce(0, Integer::sum);
            System.out.println("---------");
            System.out.println("List:         " + l);
            System.out.println("Segment sum:  " + sum);
            System.out.println("Previous max: " + previous);
            System.out.println("---------");

            if(previous != null) {
                if(sum > previous) {
                    count++;
                }
            }

            previous = sum;
        }

        return count;
    }
}
