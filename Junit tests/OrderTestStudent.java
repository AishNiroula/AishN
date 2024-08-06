import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class OrderTestStudent {

    private Order order;
    private Customer customer;

    @BeforeEach
    public void setUp() {
      
        customer = new Customer("John Doe", "123 Main St", "555-1234");

      
        order = new Order(1200, Day.FRIDAY, customer);
    }

    @Test
    public void testConstructor() {
        assertNotNull(order.getCustomer(), "Customer should not be null.");
        
    }

    @Test
    public void testAddNewBeverage() {
        order.addNewBeverage("Espresso", Size.SMALL, true, false);
        order.addNewBeverage("Red Wine", Size.LARGE);
        order.addNewBeverage("Berry Smoothie", Size.MEDIUM, 3, true);

        assertEquals(3, order.getTotalItems(), "Total items should be updated correctly.");
    }

   
    @Test
    public void testFindNumOfBeveType() {
        order.addNewBeverage("Espresso", Size.SMALL, true, false);
        order.addNewBeverage("Espresso", Size.MEDIUM, true, false);
        order.addNewBeverage("Berry Smoothie", Size.MEDIUM, 3, true);

        assertEquals(2, order.findNumOfBeveType(Type.COFFEE), "Should find the correct number of Coffee beverages.");
        assertEquals(1, order.findNumOfBeveType(Type.SMOOTHIE), "Should find the correct number of Smoothie beverages.");
    }

    @Test
    public void testIsWeekend() {
        order.setOrderDay(Day.SATURDAY);
        assertTrue(order.isWeekend(), "Order on Saturday should be considered a weekend.");

        order.setOrderDay(Day.MONDAY);
        assertFalse(order.isWeekend(), "Order on Monday should not be considered a weekend.");
    }

    @Test
    public void testGetBeverage() {
        order.addNewBeverage("Espresso", Size.SMALL, true, false);
        Beverage beverage = order.getBeverage(0);
        assertNotNull(beverage, "Should be able to get a beverage by index.");
        assertEquals("Espresso", beverage.getName(), "Retrieved beverage should be Espresso.");

        assertNull(order.getBeverage(999), "Getting a non-existent index should return null.");
    }

    @Test
    public void testToString() {
        order.addNewBeverage("Espresso", Size.SMALL, true, false);
        String expectedString = String.format("Order{orderNumber=%d, orderTime='1200', orderDay=FRIDAY, customer=%s, beverages=[Espresso]}",
                order.getOrderNumber(), customer.toString());

        assertTrue(order.toString().contains("Order{"), "toString() should include 'Order{' in its output.");
        assertTrue(order.toString().contains("customer=" + customer.toString()), "toString() should include customer details.");
    }

  

    @Test
    public void testGettersAndSetters() {
        order.setOrderTime(1300);
        order.setOrderDay(Day.SUNDAY);
        Customer newCustomer = new Customer("Jane Smith", "456 Elm St", "555-5678");
        order.setCustomer(newCustomer);

        assertEquals(1300, order.getOrderTime(), "Order time should be updated.");
        assertEquals(Day.SUNDAY, order.getOrderDay(), "Order day should be updated.");
       
    }

    @Test
    public void testSetBeverages() {
        Beverage coffee = new Coffee("Latte", Size.MEDIUM, true, false);
        Beverage smoothie = new Smoothie("Mango Smoothie", Size.SMALL, 2, false);
        order.setBeverages(Arrays.asList(coffee, smoothie));

        assertEquals(2, order.getTotalItems(), "Beverages list should be updated.");
        assertEquals("Latte", order.getBeverage(0).getName(), "First beverage should be Latte.");
        assertEquals("Mango Smoothie", order.getBeverage(1).getName(), "Second beverage should be Mango Smoothie.");
    }
}