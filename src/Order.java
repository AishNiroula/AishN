import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order> {
    private static final int MIN_ORDER_NUMBER = 10000;
    private static final int MAX_ORDER_NUMBER = 90000;

    private int orderNumber;
    private int orderTime;
    private Day orderDay;
    private Customer customer;
    private List<Beverage> beverages;

    
    public Order(int orderTime, Day orderDay, Customer customer) {
        this.orderNumber = generateRandomOrderNumber();
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = new Customer(customer); // Deep copy 
        this.beverages = new ArrayList<>();
    }

    public Order(String valueOf, Day day, Customer customer2) {
		// TODO Auto-generated constructor stub
	}

	
    private int generateRandomOrderNumber() {
        Random random = new Random();
        return MIN_ORDER_NUMBER + random.nextInt(MAX_ORDER_NUMBER - MIN_ORDER_NUMBER + 1);
    }

    // add coffee to the order
    @Override
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
    }

    //add alcohol to the order
    @Override
    public void addNewBeverage(String bevName, Size size) {
        beverages.add(new Alcohol(bevName, size, isWeekend())); 
    }

    // add smoothie to the order
    @Override
    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
    }

    //calculate the total amount for order
    @Override
    public double calcOrderTotal() {
        double total = 0.0;
        for (Beverage beverage : beverages) {
            total += beverage.calcPrice();
        }
        return total;
    }

    
    @Override
    public int findNumOfBeveType(Type type) {
        int count = 0;
        for (Beverage beverage : beverages) {
            if (beverage.getType() == type) {
                count++;
            }
        }
        return count;
    }

   
    @Override
    public boolean isWeekend() {
        return orderDay == Day.SATURDAY || orderDay == Day.SUNDAY;
    }

   
    @Override
    public Beverage getBeverage(int itemNo) {
        if (itemNo >= 0 && itemNo < beverages.size()) {
            return beverages.get(itemNo); 
        }
        return null;
    }

   
    public int getTotalItems() {
        return beverages.size();
    }

   
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Order{orderNumber=%d, orderTime='%s', orderDay=%s, customer=%s, beverages=[",
                orderNumber, orderTime, orderDay, customer));
        for (int i = 0; i < beverages.size(); i++) {
            sb.append(beverages.get(i).toString());
            if (i < beverages.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]}");
        return sb.toString();
    }

    
    @Override
    public int compareTo(Order other) {
        return Integer.compare(this.orderNumber, other.orderNumber);
    }

   
    public Customer getCustomer1() {
        return new Customer(customer);
    }

   
    public void setOrderTime(int orderTime) {
        this.orderTime = orderTime;
    }

    public void setOrderDay(Day orderDay) {
        this.orderDay = orderDay;
    }

    public void setCustomer(Customer customer) {
        this.customer = new Customer(customer); 
    }

    public void setBeverages(List<Beverage> beverages) {
        this.beverages = new ArrayList<>(beverages);
    }

  
    public int getOrderNumber() {
        return orderNumber;
    }

    public int getOrderTime() {
        return orderTime;
    }

    public Day getOrderDay() {
        return orderDay;
    }

    public Customer getCustomer() {
        return new Customer(customer);
    }

    public List<Beverage> getBeverages() {
        return new ArrayList<>(beverages);
    }
}