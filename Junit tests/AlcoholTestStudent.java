import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AlcoholTestStudent {

    @Test
    public void testCalcPriceWeekday() {
        Alcohol alcoholWeekday = new Alcohol("Beer", Size.SMALL, false);
        double expectedPrice = alcoholWeekday.addSizePrice();
        assertEquals(expectedPrice, alcoholWeekday.calcPrice(), 0.01);
    }

    @Test
    public void testCalcPriceWeekend() {
        Alcohol alcoholWeekend = new Alcohol("Beer", Size.SMALL, true);
        double expectedPrice = alcoholWeekend.addSizePrice() + Alcohol.WEEKEND_COST;
        assertEquals(expectedPrice, alcoholWeekend.calcPrice(), 0.01);
    }

    @Test
    public void testCalcPriceWeekendLarge() {
        Alcohol alcoholWeekendLarge = new Alcohol("Beer", Size.LARGE, true);
        double expectedPrice = alcoholWeekendLarge.addSizePrice() + Alcohol.WEEKEND_COST;
        assertEquals(expectedPrice, alcoholWeekendLarge.calcPrice(), 0.01);
    }

    @Test
    public void testToString() {
        Alcohol alcohol = new Alcohol("Beer", Size.SMALL, false);
        String expectedString = "Beverage{name='Beer', type=ALCOHOL, size=SMALL}, Weekend: false, Price: 2.0";
        assertEquals(expectedString, alcohol.toString());
    }

    @Test
    public void testEqualsSameObject() {
        Alcohol alcohol = new Alcohol("Beer", Size.SMALL, false);
        assertTrue(alcohol.equals(alcohol));
    }

    @Test
    public void testEqualsDifferentObjectSameValues() {
        Alcohol alcohol1 = new Alcohol("Beer", Size.SMALL, false);
        Alcohol alcohol2 = new Alcohol("Beer", Size.SMALL, false);
        assertTrue(alcohol1.equals(alcohol2));
    }

    @Test
    public void testEqualsDifferentValues() {
        Alcohol alcohol1 = new Alcohol("Beer", Size.SMALL, false);
        Alcohol alcohol2 = new Alcohol("Beer", Size.LARGE, true);
        assertFalse(alcohol1.equals(alcohol2));
    }

    @Test
    public void testEqualsDifferentType() {
        Alcohol alcohol = new Alcohol("Beer", Size.SMALL, false);
        assertFalse(alcohol.equals("String"));
    }
}