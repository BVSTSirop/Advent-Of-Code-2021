package ch.killenberger.days;

import ch.killenberger.CumulativeMap;
import ch.killenberger.abstracts.AbstractDay;
import ch.killenberger.interfaces.Day;

import java.io.IOException;
import java.util.List;

// Sonar Sweep
public class Day3 extends AbstractDay implements Day<Integer> {
    public Day3(final String day) {
        super(day);
    }

    private int lineLength = 0;

    @Override
    public Integer run() throws IOException {
        checkInputFile();

        final List<String> lines = readInput();

        this.lineLength = lines.get(0).length();

        String binaryGammaRate   = calculateGammaRate(lines);
        int    decimalGammaRate  = Integer.parseInt(binaryGammaRate, 2);

        String binaryEpsilonRate = invertBinary(binaryGammaRate);
        int decimalEpsilonRate   = Integer.parseInt(binaryEpsilonRate, 2);

        return decimalGammaRate * decimalEpsilonRate;
    }

    private String calculateGammaRate(final List<String> l) {
        final StringBuilder            sb   = new StringBuilder(lineLength);
        final CumulativeMap<Character> cMap = new CumulativeMap<>();

        for(int gammeIndex = 0; gammeIndex < lineLength; gammeIndex++) {
            for(String s : l) {
                cMap.put(s.toCharArray()[gammeIndex]);
            }

            sb.append(cMap.getHighestValueEntry().getKey());

            cMap.clear();
        }

        return sb.toString();
    }

    private String invertBinary(final String b) {
        final char[] chars = b.toCharArray();

        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == '0') {
                chars[i] = '1';
            } else if(chars[i] == '1') {
                chars[i] = '0';
            }
        }

        return new String(chars);
    }
}
