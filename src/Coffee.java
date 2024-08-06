public class Coffee extends Beverage {
    private boolean extraShot;
    private boolean extraSyrup;
    static final double EXTRA_SHOT_COST = 0.5;
    static final double EXTRA_SYRUP_COST = 0.5;

    public Coffee(String name, Size size, boolean extraShot, boolean extraSyrup) {
        super(name, Type.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    @Override
    public double calcPrice() {
        double basePrice = super.addSizePrice();
        if (extraShot) basePrice += EXTRA_SHOT_COST;
        if (extraSyrup) basePrice += EXTRA_SYRUP_COST;
        return basePrice;
    }

    @Override
    public String toString() {
        return super.toString() + ", Extra Shot: " + extraShot + ", Extra Syrup: " + extraSyrup + ", Price: " + calcPrice();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Coffee)) return false;
        Coffee other = (Coffee) obj;
        return super.equals(obj) && extraShot == other.extraShot && extraSyrup == other.extraSyrup;
    }
}