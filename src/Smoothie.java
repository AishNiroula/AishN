public class Smoothie extends Beverage {
    private int numOfFruits;
    private boolean addProtein;
    static final double PROTEIN_COST = 1.5;
    static final double FRUIT_COST = 0.5;

    public Smoothie(String name, Size size, int numOfFruits, boolean addProtein) {
        super(name, Type.SMOOTHIE, size);
        this.numOfFruits = numOfFruits;
        this.addProtein = addProtein;
    }

    @Override
    public double calcPrice() {
        double basePrice = addSizePrice();
        basePrice += numOfFruits * FRUIT_COST;
        if (addProtein) {
        	basePrice += PROTEIN_COST ;
        }
        return basePrice;
    }

    @Override
    public String toString() {
        return super.toString() + ", Fruits: " + numOfFruits + ", Protein: " + addProtein + ", Price: " + calcPrice();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Smoothie)) return false;
        Smoothie other = (Smoothie) obj;
        return super.equals(obj) && numOfFruits == other.numOfFruits && addProtein == other.addProtein;
    }
    public boolean getAddProtein() {
    	return addProtein;
    }
    
    public int getNumOfFruits() {
    	return numOfFruits;
    }
}