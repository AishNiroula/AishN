import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerTestStudent {

    @Test
    public void testConstructorWithParameters() {
        Customer customer = new Customer("Alice", 30);
        assertEquals("Alice", customer.getName(), "Name should be 'Alice'");
        assertEquals(30, customer.getAge(), "Age should be 30");
    }

    @Test
    public void testCopyConstructor() {
        Customer original = new Customer("Bob", 25);
        Customer copy = new Customer(original);
        assertEquals(original.getName(), copy.getName(), "Name of copied customer should match original");
        assertEquals(original.getAge(), copy.getAge(), "Age of copied customer should match original");
    }

    @Test
    public void testToString() {
        Customer customer = new Customer("Charlie", 40);
        String expected = "Customer{name='Charlie', age=40}";
        assertEquals(expected, customer.toString(), "toString() method should return the correct string");
    }

    @Test
    public void testSetName() {
        Customer customer = new Customer("Dave", 50);
        customer.setName("Eve");
        assertEquals("Eve", customer.getName(), "Name should be updated to 'Eve'");
    }

    @Test
    public void testSetAge() {
        Customer customer = new Customer("Frank", 60);
        customer.setAge(70);
        assertEquals(70, customer.getAge(), "Age should be updated to 70");
    }
}