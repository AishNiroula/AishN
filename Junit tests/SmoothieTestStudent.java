import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmoothieTestStudent {

    private Smoothie smoothieWithProtein;
    private Smoothie smoothieWithoutProtein;

    @BeforeEach
    public void setUp() {
       
        smoothieWithProtein = new Smoothie("Tropical Blast", Size.MEDIUM, 3, true);
        smoothieWithoutProtein = new Smoothie("Berry Delight", Size.SMALL, 2, false);
    }

    @Test
    public void testCalcPrice() {
       
        // Assertions
        assertEquals(5.5, smoothieWithProtein.calcPrice(), 0.01, "Price calculation for smoothie with protein is incorrect");
       
    }

    @Test
    public void testToString() {
       
        String expectedStringWithProtein = "Beverage{name='Tropical Blast', type=SMOOTHIE, size=MEDIUM}, Fruits: 3, Protein: true, Price: " + smoothieWithProtein.calcPrice();
        assertEquals(expectedStringWithProtein, smoothieWithProtein.toString(), "toString() output is incorrect for smoothie with protein");

        
        String expectedStringWithoutProtein = "Beverage{name='Berry Delight', type=SMOOTHIE, size=SMALL}, Fruits: 2, Protein: false, Price: " + smoothieWithoutProtein.calcPrice();
        assertEquals(expectedStringWithoutProtein, smoothieWithoutProtein.toString(), "toString() output is incorrect for smoothie without protein");
    }

    @Test
    public void testEquals() {
       
        Smoothie anotherSmoothieWithProtein = new Smoothie("Tropical Blast", Size.MEDIUM, 3, true);
        Smoothie differentSmoothie = new Smoothie("Berry Delight", Size.SMALL, 2, false);

       
        assertEquals(smoothieWithProtein, anotherSmoothieWithProtein, "Smoothies with the same attributes should be equal");
      
        assertNotEquals(smoothieWithProtein, differentSmoothie, "Smoothies with different attributes should not be equal");
        
        assertNotEquals(smoothieWithProtein, "Some String", "Smoothie should not equal a non-Smoothie object");
    }
}
