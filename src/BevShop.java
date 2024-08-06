import java.util.ArrayList;
import java.util.List;

public class BevShop implements BevShopInterface {

    List<Order> orders;
    private Order currentOrder;
    private int numOfAlcoholDrinks;

    public BevShop() {
        orders = new ArrayList<>();
        currentOrder = null; 
        numOfAlcoholDrinks = 0;
    }

    @Override
    public boolean isValidTime(int time) {
        return time >= MIN_TIME && time <= MAX_TIME;
    }

    @Override
    public int getMaxNumOfFruits() {
        return MAX_FRUIT;
    }

    @Override
    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > MAX_FRUIT;
    }

    @Override
    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public boolean isEligibleForMore() {
        return numOfAlcoholDrinks < getMaxOrderForAlcohol();
    }

    @Override
    public int getNumOfAlcoholDrink() {
        return numOfAlcoholDrinks;
    }

    @Override
    public boolean isValidAge(int age) {
        return age >= getMinAgeForAlcohol();
    }

    @Override
    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        if (!isValidTime(time)) {
            throw new IllegalArgumentException("Invalid time");
        }
        if (!isValidAge(customerAge)) {
            throw new IllegalArgumentException("Invalid age for alcohol");
        }
        currentOrder = new Order(String.valueOf(time), day, new Customer(customerName, customerAge));
        numOfAlcoholDrinks = 0;
    }

    @Override
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        if (currentOrder == null) {
            throw new IllegalStateException("No current order");
        }
        currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
    }

    @Override
    public void processAlcoholOrder(String bevName, Size size) {
        if (currentOrder == null) {
            throw new IllegalStateException("No current order");
        }
        if (!isEligibleForMore()) {
            throw new IllegalStateException("Exceeded maximum number of alcohol drinks");
        }
        currentOrder.addNewBeverage(bevName, size);
        numOfAlcoholDrinks++;
    }

    @Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        if (currentOrder == null) {
            throw new IllegalStateException("No current order");
        }
        if (isMaxFruit(numOfFruits)) {
            throw new IllegalArgumentException("Exceeded maximum number of fruits");
        }
        currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
    }

    @Override
    public int findOrder(int orderNo) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNumber() == orderNo) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public double totalOrderPrice(int orderNo) {
        int index = findOrder(orderNo);
        if (index != -1) {
            return orders.get(index).calcOrderTotal();
        }
        return 0;
    }

    @Override
    public double totalMonthlySale() {
        double total = 0;
        for (Order order : orders) {
            total += order.calcOrderTotal();
        }
        return total;
    }

    @Override
    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    @Override
    public Order getCurrentOrder() {
        if (currentOrder != null) {
            return new Order(currentOrder.getOrderTime(), currentOrder.getOrderDay(), currentOrder.getCustomer());
        }
        return null;
    }

    @Override
    public Order getOrderAtIndex(int index) {
        if (index >= 0 && index < orders.size()) {
            return new Order(orders.get(index).getOrderTime(), orders.get(index).getOrderDay(), orders.get(index).getCustomer());
        }
        return null;
    }

    @Override
    public void sortOrders() {
        orders.sort(null); 
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Orders:\n");
        for (Order order : orders) {
            sb.append(order).append("\n");
        }
        sb.append("Total Monthly Sale: $").append(totalMonthlySale());
        return sb.toString();
    }
}