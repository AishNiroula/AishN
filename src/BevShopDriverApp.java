import java.util.Scanner;

public class BevShopDriverApp {

    public static void main(String[] args) {
        BevShop myBevShop = new BevShop(); // Instantiate
        Scanner scanner = new Scanner(System.in);

        double totalAmount = 0.0;
        
        // First Order
        System.out.println("The current order in process can have at most 3 alcoholic beverages.");
        System.out.println("The minimum age to order alcohol drink is 21");
        
        System.out.println("Start please a new order:");
        System.out.println("Your Total Order for now is 0.0");

        System.out.print("Would you please enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Would you please enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  

        myBevShop.startNewOrder(10, Day.FRIDAY, name, age);

        if (myBevShop.isValidAge(age)) {
            System.out.println("Your age is above 20 and you are eligible to order alcohol");
        } else {
            System.out.println("Your age is not appropriate for alcohol drink!!");
        }

        addBeverage(myBevShop, scanner);

       
        System.out.println("#------------------------------------#");
        System.out.println("Would you please start a new order");
        
        System.out.print("Would you please enter your name: ");
        name = scanner.nextLine();
        System.out.print("Would you please enter your age: ");
        age = scanner.nextInt();
        scanner.nextLine();  

        myBevShop.startNewOrder(15, Day.SATURDAY, name, age);

        addBeverage(myBevShop, scanner);

        // Calculate and display totals
        double totalOrdersPrice = myBevShop.totalMonthlySale();
        System.out.println("Total price on the second Order: " + myBevShop.totalOrderPrice(myBevShop.getCurrentOrder().getOrderNumber()));
        System.out.println("Total amount for all Orders: " + totalOrdersPrice);
        
        scanner.close();
    }

    private static void addBeverage(BevShop myBevShop, Scanner scanner) {
        boolean moreAlcohol = true;

        while (moreAlcohol && myBevShop.isEligibleForMore()) {
            System.out.print("Would you please add an alcohol drink (yes/no): ");
            String addAlcohol = scanner.nextLine();

            if (addAlcohol.equalsIgnoreCase("yes")) {
                System.out.print("Enter the name of the Alcohol drink: ");
                String bevName = scanner.nextLine();
                System.out.print("Enter the size (small, medium, large): ");
                Size size = Size.valueOf(scanner.nextLine().toUpperCase());
                myBevShop.processAlcoholOrder(bevName, size);
                System.out.println("The current order of drinks is " + myBevShop.getNumOfAlcoholDrink());
                System.out.println("The Total price on the Order is " + myBevShop.getCurrentOrder().calcOrderTotal());
            } else {
                moreAlcohol = false;
            }
        }

        System.out.println("Your current alcohol drink order is " + (myBevShop.getNumOfAlcoholDrink() < 4 ? "less than 4" : "at maximum"));

        System.out.print("Would you please add a COFFEE to your order (yes/no): ");
        String addCoffee = scanner.nextLine();
        if (addCoffee.equalsIgnoreCase("yes")) {
            System.out.print("Enter the name of the Coffee: ");
            String bevName = scanner.nextLine();
            System.out.print("Enter the size (small, medium, large): ");
            Size size = Size.valueOf(scanner.nextLine().toUpperCase());
            System.out.print("Extra Shot (true/false): ");
            boolean extraShot = scanner.nextBoolean();
            System.out.print("Extra Syrup (true/false): ");
            boolean extraSyrup = scanner.nextBoolean();
            scanner.nextLine();  // Consume newline
            myBevShop.processCoffeeOrder(bevName, size, extraShot, extraSyrup);
        }

        System.out.print("Would you please add a SMOOTHIE to your order (yes/no): ");
        String addSmoothie = scanner.nextLine();
        if (addSmoothie.equalsIgnoreCase("yes")) {
            System.out.print("Enter the name of the Smoothie: ");
            String bevName = scanner.nextLine();
            System.out.print("Enter the size (small, medium, large): ");
            Size size = Size.valueOf(scanner.nextLine().toUpperCase());
            System.out.print("Enter the number of fruits: ");
            int numOfFruits = scanner.nextInt();
            System.out.print("Add Protein (true/false): ");
            boolean addProtein = scanner.nextBoolean();
            scanner.nextLine();  // Consume newline
            myBevShop.processSmoothieOrder(bevName, size, numOfFruits, addProtein);
        }

        System.out.println("The Total Price on the Order: " + myBevShop.getCurrentOrder().calcOrderTotal());
    }
}


