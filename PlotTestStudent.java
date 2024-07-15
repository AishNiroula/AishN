import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlotTestStudent {

	private Plot plot;

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testPlot() {
		Plot plot = new Plot();
        assertEquals(0, plot.getX());
        assertEquals(0, plot.getY());
        assertEquals(1, plot.getWidth());
        assertEquals(1, plot.getDepth());
	}

	@Test
	void testPlotIntIntIntInt() {
		Plot plot = new Plot(5, 10, 3, 4);
        assertEquals(5, plot.getX());
        assertEquals(10, plot.getY());
        assertEquals(3, plot.getDepth());
        assertEquals(4, plot.getWidth());
	}

	@Test
	void testPlotPlot() {
		 Plot original = new Plot(2, 3, 4, 5);
	        Plot copy = new Plot(original);
	        assertEquals(original.getX(), copy.getX());
	        assertEquals(original.getY(), copy.getY());
	        assertEquals(original.getDepth(), copy.getDepth());
	        assertEquals(original.getWidth(), copy.getWidth());
	}

	@Test
	void testOverlaps() {
		Plot plot1 = new Plot(1, 1, 3, 3);
        Plot plot2 = new Plot(2, 2, 2, 2);
        assertTrue(plot1.overlaps(plot2));
	}

	@Test
	void testEncompasses() {
		Plot plot1 = new Plot(1, 1, 5, 5);
        Plot plot2 = new Plot(2, 2, 3, 3);
        assertTrue(plot1.encompasses(plot2));
	}

	@Test
	void testToString() {
		Plot plot = new Plot(3, 4, 5, 6);
        assertEquals("3,4,5,6", plot.toString());
	}

}
