package ch.killenberger.days;

import ch.killenberger.CumulativeMap;
import ch.killenberger.abstracts.AbstractDay;
import ch.killenberger.interfaces.Day;
import ch.killenberger.utils.ListUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Sonar Sweep
public class Day2 extends AbstractDay implements Day<Integer> {
    private static final String FORWARD = "forward";
    private static final String UP      = "up";
    private static final String DOWN    = "down";

    public Day2(final String day) {
        super(day);
    }

    @Override
    public Integer run() throws IOException {
        checkInputFile();

        final List<String> lines = readInput();
        final Map<String, Integer> map = mapInput(lines);

        int horizontal = map.get(FORWARD);
        int depth      = map.get(DOWN) - map.get(UP);

        return horizontal * depth;
    }

    public Map<String, Integer> mapInput(final List<String> lines) {
        final CumulativeMap<String> cMap = new CumulativeMap<>();

        for(String s : lines) {
            String[] splits = s.split(" ");

            cMap.put(splits[0], Integer.parseInt(splits[1]));
        }

        return cMap.toMap();

    }
}
