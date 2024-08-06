public abstract class Beverage {
	    private String name;
	    private Type type;
	    private Size size;
	    private static final double BASE_PRICE = 2.0;
	    private static final double SIZE_PRICE = 0.5;

	    
	    public Beverage(String name, Type type, Size size) {
	        this.name = name;
	        this.type = type;
	        this.size = size;
	    }

	    // calculate size price
	    protected double addSizePrice() {
	        double price = BASE_PRICE;
	        switch (size) {
	            case MEDIUM:
	                price += SIZE_PRICE;
	                break;
	            case LARGE:
	                price += 2 * SIZE_PRICE;
	                break;
	            default:
	                break; 
	        }
	        return price;
	    }

	    // implement by subclasses
	    public abstract double calcPrice();

	    
	    @Override
	    public String toString() {
	        return "Beverage{name='" + name + "', type=" + type + ", size=" + size + "}";
	    }

	    
	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) return true;
	        if (obj == null || getClass() != obj.getClass()) return false;
	        Beverage beverage = (Beverage) obj;
	        return name.equals(beverage.name) &&
	               type == beverage.type &&
	               size == beverage.size;
	    }

	   
	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public Type getType() {
	        return type;
	    }

	    public void setType(Type type) {
	        this.type = type;
	    }

	    public Size getSize() {
	        return size;
	    }

	    public void setSize(Size size) {
	        this.size = size;
	    }
	}

