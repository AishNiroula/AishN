import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CoffeeTestStudent {

    private Coffee coffeeWithExtras;
    private Coffee coffeeWithoutExtras;
    private Coffee coffeeWithDifferentSize;
    private Coffee coffeeWithDifferentExtras;

    @BeforeEach
    public void setUp() {
        // Initialize Coffee objects
        coffeeWithExtras = new Coffee("Latte", Size.MEDIUM, true, true);
        coffeeWithoutExtras = new Coffee("Latte", Size.MEDIUM, false, false);
        coffeeWithDifferentSize = new Coffee("Latte", Size.LARGE, true, true);
        coffeeWithDifferentExtras = new Coffee("Latte", Size.MEDIUM, true, false);
    }

    @Test
    public void testCalcPrice() {
        double basePrice = coffeeWithExtras.addSizePrice();
        double expectedPriceWithExtras = basePrice + Coffee.EXTRA_SHOT_COST + Coffee.EXTRA_SYRUP_COST;
        double expectedPriceWithoutExtras = basePrice;

        assertEquals(expectedPriceWithExtras, coffeeWithExtras.calcPrice(), "Price with extras should be calculated correctly");
        assertEquals(expectedPriceWithoutExtras, coffeeWithoutExtras.calcPrice(), "Price without extras should be calculated correctly");
    }

    @Test
    public void testToString() {
        String expectedStringWithExtras = "Beverage{name='Latte', type=COFFEE, size=MEDIUM}, Extra Shot: true, Extra Syrup: true, Price: " + coffeeWithExtras.calcPrice();
        String expectedStringWithoutExtras = "Beverage{name='Latte', type=COFFEE, size=MEDIUM}, Extra Shot: false, Extra Syrup: false, Price: " + coffeeWithoutExtras.calcPrice();

        assertEquals(expectedStringWithExtras, coffeeWithExtras.toString(), "ToString with extras should be correct");
        assertEquals(expectedStringWithoutExtras, coffeeWithoutExtras.toString(), "ToString without extras should be correct");
    }

    @Test
    public void testEquals() {
        Coffee coffee1 = new Coffee("Latte", Size.MEDIUM, true, true);
        Coffee coffee2 = new Coffee("Latte", Size.MEDIUM, true, true);
        Coffee coffee3 = new Coffee("Latte", Size.LARGE, true, true);
        Coffee coffee4 = new Coffee("Latte", Size.MEDIUM, true, false);

        assertEquals(coffee1, coffee2, "Two coffee objects with the same properties should be equal");
        assertNotEquals(coffee1, coffee3, "Coffee with different size should not be equal");
        assertNotEquals(coffee1, coffee4, "Coffee with different extras should not be equal");
        assertNotEquals(coffee1, null, "Coffee should not be equal to null");
        assertNotEquals(coffee1, "Some String", "Coffee should not be equal to a different type");
    }

    @Test
    public void testHashCode() {
        Coffee coffee1 = new Coffee("Latte", Size.MEDIUM, true, true);
        Coffee coffee2 = new Coffee("Latte", Size.MEDIUM, true, true);
        Coffee coffee3 = new Coffee("Latte", Size.LARGE, true, true);

       
        assertNotEquals(coffee1.hashCode(), coffee3.hashCode(), "HashCode should be different for coffee objects with different properties");
    }
}