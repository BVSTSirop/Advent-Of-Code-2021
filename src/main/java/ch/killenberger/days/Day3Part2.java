package ch.killenberger.days;

import ch.killenberger.CumulativeMap;
import ch.killenberger.abstracts.AbstractDay;
import ch.killenberger.interfaces.Day;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

// Sonar Sweep
public class Day3Part2 extends AbstractDay implements Day<Integer> {
    private static final char ZERO = '0';
    private static final char ONE  = '1';

    public Day3Part2(final String day) {
        super(day);
    }

    private int lineLength = 0;

    @Override
    public Integer run() throws IOException {
        checkInputFile();

        final List<String> lines = readInput();

        this.lineLength = lines.get(0).length();

        final String binaryOxygenRating  = calculateRating(lines, true);
        final int    decimalOxygenRating = Integer.parseInt(binaryOxygenRating, 2);

        final String binaryC02Rating     = calculateRating(lines, false);
        final int    decimalCO2Rating    = Integer.parseInt(binaryC02Rating, 2);

        return decimalOxygenRating * decimalCO2Rating;
    }

    private String calculateRating(final List<String> lines, boolean mostCommon) {
        final ConcurrentLinkedQueue<String> q = new ConcurrentLinkedQueue<>(lines);

        for(int pos = 0; pos < this.lineLength; pos++) {
            final char match = calculateCharToMatch(q, pos, mostCommon);

            for(String s : q) {
                if(s.toCharArray()[pos] != match) {
                    q.remove(s);
                }
            }

            if(q.size() == 1) {
                break;
            }
        }

        return q.poll();
    }

    private char calculateMostCommonBitAtPosition(final List<String> l, final int pos) {
        return calculateCommonBitAtPosition(l, pos, ONE, false);
    }

    private char calculateLeastCommonBitAtPosition(final List<String> l, final int pos) {
        return calculateCommonBitAtPosition(l, pos, ZERO, true);
    }

    private char calculateCommonBitAtPosition(final List<String> l, final int pos, final char defaultReturn, final boolean leastCommon) {
        final CumulativeMap<Character> cMap = new CumulativeMap<>();

        for(String s : l) {
            cMap.put(s.toCharArray()[pos]);
        }

        if(cMap.get(ZERO).equals(cMap.get(ONE))) {
            return defaultReturn;
        }

        if(leastCommon) {
            return cMap.getLowestValueEntry().getKey();
        }

        return cMap.getHighestValueEntry().getKey();
    }

    private char calculateCharToMatch(final ConcurrentLinkedQueue<String> q, final int pos, final boolean mostCommon) {
        if(mostCommon) {
            return calculateMostCommonBitAtPosition(new ArrayList<>(q), pos);
        }

        return calculateLeastCommonBitAtPosition(new ArrayList<>(q), pos);
    }
}
