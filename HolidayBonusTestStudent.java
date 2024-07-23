import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




public class HolidayBonusTestStudent {

    @Test
    public void testCalculateHolidayBonus() {
        // Test case 1: Basic scenario with positive sales values
        double[][] data1 = {
            {1000, 2000, 3000},
            {4000, 5000},
            {6000, 7000, 8000, 9000}
        };
        double[] expected1 = {3000.0, 4000.0, 20000.0};
        assertArrayEquals(expected1, HolidayBonus.calculateHolidayBonus(data1), 0.001);

        // Test case 2: All sales values are zero
        double[][] data2 = {
            {0, 0},
            {0},
            {}
        };
        double[] expected2 = {0.0, 0.0, 0.0};
        assertArrayEquals(expected2, HolidayBonus.calculateHolidayBonus(data2), 0.001);

        // Test case 3: Mixed positive, negative, and zero sales values
        double[][] data3 = {
            {1000, -2000},
            {3000, 0, 4000},
            {5000}
        };
        double[] expected3 = {1000.0, 2000.0, 5000.0};
        assertArrayEquals(expected3, HolidayBonus.calculateHolidayBonus(data3), 0.001);
    }

    @Test
    public void testCalculateTotalHolidayBonus() {
        // Test case 1: Basic scenario with positive sales values
        double[][] data1 = {
            {1000, 2000, 3000},
            {4000, 5000},
            {6000, 7000, 8000, 9000}
        };
        double expectedTotal1 = 27000.0;
        assertEquals(expectedTotal1, HolidayBonus.calculateTotalHolidayBonus(data1), 0.001);

        // Test case 2: All sales values are zero
        double[][] data2 = {
            {0, 0},
            {0},
            {}
        };
        double expectedTotal2 = 0.0;
        assertEquals(expectedTotal2, HolidayBonus.calculateTotalHolidayBonus(data2), 0.001);

        // Test case 3: Mixed positive, negative, and zero sales values
        double[][] data3 = {
            {1000, -2000},
            {3000, 0, 4000},
            {5000}
        };
        double expectedTotal3 = 8000.0;
        assertEquals(expectedTotal3, HolidayBonus.calculateTotalHolidayBonus(data3), 0.001);
    }
}