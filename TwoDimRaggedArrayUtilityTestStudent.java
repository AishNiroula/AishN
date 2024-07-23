import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilityTestStudent{

    private static final String TEST_FILE_PATH = "test_data.txt";
    private File testFile;

    @Before
    public void setUp() throws Exception {
       
        testFile = new File(TEST_FILE_PATH);
        PrintWriter writer = new PrintWriter(testFile);
        writer.println("1.5 2.5 3.5");
        writer.println("4.5 5.5");
        writer.println("6.5");
        writer.close();
    }

    @After
    public void tearDown() {

        testFile.delete();
    }

    @Test
    public void testReadFile() throws FileNotFoundException {
        double[][] expected = {
            { 1.5, 2.5, 3.5 },
            { 4.5, 5.5 },
            { 6.5 }
        };

        double[][] actual = TwoDimRaggedArrayUtility.readFile(testFile);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testWriteToFile() throws FileNotFoundException {
        double[][] data = {
            { 1.5, 2.5, 3.5 },
            { 4.5, 5.5 },
            { 6.5 }
        };

        File outputFile = new File("output_test.txt");
        TwoDimRaggedArrayUtility.writeToFile(data, outputFile);

        double[][] readData = TwoDimRaggedArrayUtility.readFile(outputFile);

        assertArrayEquals(data, readData);
    }

    @Test
    public void testGetTotal() {
        double[][] data = {
            { 1.5, 2.5, 3.5 },
            { 4.5, 5.5 },
            { 6.5 }
        };

        double expected = 1.5 + 2.5 + 3.5 + 4.5 + 5.5 + 6.5;
        double actual = TwoDimRaggedArrayUtility.getTotal(data);

        assertEquals(expected, actual, 0.0001);
    }

 
    @Test
    public void testGetAverage() {
        double[][] data = {
            { 1.5, 2.5, 3.5 },
            { 4.5, 5.5 },
            { 6.5 }
        };

        double expected = (1.5 + 2.5 + 3.5 + 4.5 + 5.5 + 6.5) / 6.0;
        double actual = TwoDimRaggedArrayUtility.getAverage(data);

        assertEquals(expected, actual, 0.0001);
    }

    
    @Test
    public void testGetRowTotal() {
        double[][] data = {
            { 1.5, 2.5, 3.5 },
            { 4.5, 5.5 },
            { 6.5 }
        };

        double expected = 4.5 + 5.5;
        double actual = TwoDimRaggedArrayUtility.getRowTotal(data, 1);

        assertEquals(expected, actual, 0.0001);
    }

   
    @Test
    public void testGetHighestInRow() {
        double[][] data = {
            { 1.5, 2.5, 3.5 },
            { 4.5, 5.5 },
            { 6.5 }
        };

        double expected = 3.5;
        double actual = TwoDimRaggedArrayUtility.getHighestInRow(data, 0);

        assertEquals(expected, actual, 0.0001);
    }

 

}