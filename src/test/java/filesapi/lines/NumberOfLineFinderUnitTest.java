package filesapi.lines;


import org.junit.Test;

import static filesapi.nio.lines.NumberOfLineFinder.*;
import static org.junit.Assert.assertEquals;

public class NumberOfLineFinderUnitTest {
    private static final String INPUT_FILE_NAME = "src/main/resources/input.txt";
    private static final int ACTUAL_LINE_COUNT = 45;

    @Test
    public void whenUsingBufferedReader_thenReturnTotalNumberOfLines() {
        int lines = getTotalNumberOfLinesUsingBufferedReader(INPUT_FILE_NAME);
        assertEquals(ACTUAL_LINE_COUNT, lines);
    }

    @Test
    public void whenUsingLineNumberReader_thenReturnTotalNumberOfLines() {
        int lines = getTotalNumberOfLinesUsingLineNumberReader(INPUT_FILE_NAME);
        assertEquals(ACTUAL_LINE_COUNT, lines);
    }

    @Test
    public void whenUsingScanner_thenReturnTotalNumberOfLines() {
        int lines = getTotalNumberOfLinesUsingScanner(INPUT_FILE_NAME);
        assertEquals(ACTUAL_LINE_COUNT, lines);
    }

    @Test
    public void whenUsingNIOFiles_thenReturnTotalNumberOfLines() {
        int lines = getTotalNumberOfLinesUsingNIOFiles(INPUT_FILE_NAME);
        assertEquals(ACTUAL_LINE_COUNT, lines);
    }

    @Test
    public void whenUsingNIOFilesReadAllLines_thenReturnTotalNumberOfLines() {
        int lines = getTotalNumberOfLinesUsingNIOFilesReadAllLines(INPUT_FILE_NAME);
        assertEquals(ACTUAL_LINE_COUNT, lines);
    }

    @Test
    public void whenUsingNIOFileChannel_thenReturnTotalNumberOfLines() {
        int lines = getTotalNumberOfLinesUsingNIOFileChannel(INPUT_FILE_NAME);
        assertEquals(ACTUAL_LINE_COUNT, lines);
    }
}
