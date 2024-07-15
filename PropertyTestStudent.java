import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyTestStudent {

	private Property property;

	@BeforeEach
	void setUp() throws Exception {
		  property = new Property("Sample House", "Sample City", 1500.0, "Kelly Aburn", 1, 1, 100, 100);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testProperty() {
		Property defaultProperty = new Property();
        assertEquals("", defaultProperty.getPropertyName());
        assertEquals("", defaultProperty.getCity());
        assertEquals("", defaultProperty.getOwner());
        assertEquals(0.0, defaultProperty.getRentAmount());
        assertNotNull(defaultProperty.getPlot());
    }
	

	@Test
	void testPropertyProperty() {
		Property copyProperty = new Property(property);
        assertEquals(property.getPropertyName(), copyProperty.getPropertyName());
        assertEquals(property.getCity(), copyProperty.getCity());
        assertEquals(property.getOwner(), copyProperty.getOwner());
        assertEquals(property.getRentAmount(), copyProperty.getRentAmount());
        assertEquals(property.getPlot().getX(), copyProperty.getPlot().getX());
        assertEquals(property.getPlot().getY(), copyProperty.getPlot().getY());
        assertEquals(property.getPlot().getWidth(), copyProperty.getPlot().getWidth());
        assertEquals(property.getPlot().getDepth(), copyProperty.getPlot().getDepth());
	}

	@Test
	void testPropertyStringStringDoubleString() {
		 Property property = new Property("House A", "City A", 2000.0, "Jane Doe");
	        
	        // Assert that the values are set correctly
	        assertEquals("House A", property.getPropertyName());
	        assertEquals("City A", property.getCity());
	        assertEquals("Jane Doe", property.getOwner());
	        assertEquals(2000.0, property.getRentAmount());
	        assertNotNull(property.getPlot());
	}

	@Test
	void testPropertyStringStringDoubleStringIntIntIntInt() {
		Property property = new Property("House B", "City B", 2500.0, "John Smith", 2, 2, 120, 150);

        // Assert that the values are set correctly
        assertEquals("House B", property.getPropertyName());
        assertEquals("City B", property.getCity());
        assertEquals("John Smith", property.getOwner());
        assertEquals(2500.0, property.getRentAmount());
        assertNotNull(property.getPlot());
        assertEquals(2, property.getPlot().getX());
        assertEquals(2, property.getPlot().getY());
        assertEquals(150, property.getPlot().getWidth());
        assertEquals(120, property.getPlot().getDepth());
	}

	@Test
	void testToString() {
		String expectedString = "Sample House,Sample City,Kelly Aburn,1500.0";
        assertEquals(expectedString, property.toString());
	}

}
