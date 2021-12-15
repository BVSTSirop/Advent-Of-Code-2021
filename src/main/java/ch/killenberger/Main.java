package ch.killenberger;

import ch.killenberger.days.Day1;
import ch.killenberger.days.Day1Part2;

import java.io.IOException;

public class Main {
    private static final Day1 dOne        = new Day1("1");
    private static final Day1Part2 dOnePartTwo = new Day1Part2("1_2");

    public static void main(String... args) throws IOException {
        // Day one: Part 1
        Integer resultDayOne = dOne.run();
        System.out.println("Result day one: " + resultDayOne);

        // Day one: Part 2
        Integer resultDayOnePartTwo = dOnePartTwo.run();
        System.out.println("Result day one part two: " + resultDayOnePartTwo);
    }
}
