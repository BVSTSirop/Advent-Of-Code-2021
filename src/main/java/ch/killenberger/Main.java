package ch.killenberger;

import ch.killenberger.days.*;

import java.io.IOException;

public class Main {
    // Day 1
    private static final Day1      dOne        = new Day1("1");
    private static final Day1Part2 dOnePartTwo = new Day1Part2("1_2");

    // Day 2
    private static final Day2      dTwo        = new Day2("2");
    private static final Day2Part2 dTwoPartTwo = new Day2Part2("2_2");

    // Day 3
    private static final Day3      dThree        = new Day3("3");
    private static final Day3Part2 dThreePartTwo = new Day3Part2("3_2");

    public static void main(String... args) throws IOException {
        System.out.println("\n------------- Day 1 -------------");
        // Day one: Part 1
        Integer resultDayOne = dOne.run();
        System.out.println("Result day one: " + resultDayOne);

        // Day one: Part 2
        Integer resultDayOnePartTwo = dOnePartTwo.run();
        System.out.println("Result day one part two: " + resultDayOnePartTwo);

        System.out.println("\n------------- Day 2 -------------");

        // Day two: Part 1
        Integer resultDayTwo = dTwo.run();
        System.out.println("Result day two: " + resultDayTwo);

        // Day two: Part 2
        Integer r2d2 = dTwoPartTwo.run();
        System.out.println("Result day two part two: " + r2d2);

        System.out.println("\n------------- Day 3 -------------");

        // Day three: Part 1
        Integer resultDayThree = dThree.run();
        System.out.println("Result day three: " + resultDayThree);

        // Day three: Part 2
        Integer resultDayThreePartTwo = dThreePartTwo.run();
        System.out.println("Result day three part two: " + resultDayThreePartTwo);
    }
}
