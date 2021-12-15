package ch.killenberger;

import ch.killenberger.days.Day1;
import ch.killenberger.days.Day1_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    private static final String INPUT_PREFIX         = "input_day_";
    private static final String INPUT_FILE_EXTENSION = ".txt";
    private static final String RESOURCES_DIR_NAME   = "resources";
    private static final String INPUT_DIR_NAME       = "input";

    private static final String WORKING_DIR          = System.getProperty("user.dir");
    private static final String RESOURCES_DIR        = WORKING_DIR + File.separator + RESOURCES_DIR_NAME;
    private static final String INPUT_DIR            = RESOURCES_DIR + File.separator + INPUT_DIR_NAME;

    private static final Day1 dOne        = new Day1( INPUT_DIR + File.separator + INPUT_PREFIX + "1" + INPUT_FILE_EXTENSION);
    private static final Day1_2 dOnePartTwo = new Day1_2( INPUT_DIR + File.separator + INPUT_PREFIX + "1" + INPUT_FILE_EXTENSION);

    public static void main(String... args) throws IOException {
        // Day one: Part 1
        Integer resultDayOne = dOne.run();
        System.out.println("Result day one: " + resultDayOne);

        // Day one: Part 2
        Integer resultDayOnePartTwo = dOnePartTwo.run();
        System.out.println("Result day one part two: " + resultDayOnePartTwo);
    }
}
