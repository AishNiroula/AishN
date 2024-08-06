public class Customer {
    private String name;
    private int age;

    
    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    public Customer(Customer other) {
        this.name = other.name;
        this.age = other.age;
    }

    public Customer(String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
	}

	
    @Override
    public String toString() {
        return String.format("Customer{name='%s', age=%d}", name, age);
    }

    
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

   
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
