import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BevShopTestStudent {

    private BevShop bevShop;
    private Order testOrder1;
    private Order testOrder2;

    @BeforeEach
    public void setUp() {
        bevShop = new BevShop();
      
        testOrder1 = new Order("10", Day.MONDAY, new Customer("Alice", 21));
        testOrder2 = new Order("15", Day.FRIDAY, new Customer("Bob", 30));
    }

    @Test
    public void testIsValidTime() {
        assertTrue(bevShop.isValidTime(9));
        assertFalse(bevShop.isValidTime(25)); 
    }

    @Test
    public void testGetMaxNumOfFruits() {
        assertEquals(BevShop.MAX_FRUIT, bevShop.getMaxNumOfFruits());
    }

    @Test
    public void testGetMinAgeForAlcohol() {
        assertEquals(BevShop.MIN_AGE_FOR_ALCOHOL, bevShop.getMinAgeForAlcohol());
    }

    @Test
    public void testIsMaxFruit() {
        assertTrue(bevShop.isMaxFruit(BevShop.MAX_FRUIT + 1));
        assertFalse(bevShop.isMaxFruit(BevShop.MAX_FRUIT));
    }

    @Test
    public void testGetMaxOrderForAlcohol() {
        assertEquals(BevShop.MAX_ORDER_FOR_ALCOHOL, bevShop.getMaxOrderForAlcohol());
    }


    @Test
    public void testIsValidAge() {
        assertTrue(bevShop.isValidAge(21));
        assertFalse(bevShop.isValidAge(18));
    }

 
    @Test
    public void testFindOrder() {
        bevShop.orders.add(testOrder1);
        bevShop.orders.add(testOrder2);
        equals(1);
      
    }



    @Test
    public void testTotalNumOfMonthlyOrders() {
        bevShop.orders.add(testOrder1);
        bevShop.orders.add(testOrder2);
        assertEquals(2, bevShop.totalNumOfMonthlyOrders());
    }

 

    @Test
    public void testSortOrders() {
        bevShop.orders.add(testOrder1);
        bevShop.orders.add(testOrder2);
        bevShop.sortOrders();
        assertEquals(testOrder1, bevShop.orders.get(0)); 
        assertEquals(testOrder2, bevShop.orders.get(1));
    }
}

  