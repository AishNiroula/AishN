public class Alcohol extends Beverage {
    private boolean isWeekend;
    static final double WEEKEND_COST = 0.6;

    public Alcohol(String name, Size size, boolean isWeekend) {
        super(name, Type.ALCOHOL, size);
        this.isWeekend = isWeekend;
    }

    @Override
    public double calcPrice() {
        double basePrice = addSizePrice();
        if (isWeekend) basePrice += WEEKEND_COST;
        return basePrice;
    }

    @Override
    public String toString() {
        return super.toString() + ", Weekend: " + isWeekend + ", Price: " + calcPrice();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Alcohol)) return false;
        Alcohol other = (Alcohol) obj;
        return super.equals(obj) && isWeekend == other.isWeekend;
    }
}