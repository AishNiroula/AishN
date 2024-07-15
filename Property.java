public class Property {
	private String name;
	private String city;
	private Double rentAmount;
	private String owner;
	private Plot plot;
	

	  public Property() {
		this.name = "";
	    this.city = "";
	    this.rentAmount = 0.0;
	    this.owner = "";
	    this.plot = new Plot();
	  }

	  public Property(Property plot) {
	    this.city = plot.city;
	    this.owner = plot.owner;
	    this.name = plot.name;
	    this.rentAmount = plot.rentAmount;
	    this.plot = new Plot(plot.plot);
	  }

	  public Property(String name, String city, double rentalAmount, String owner) {
	    this.city = city;
	    this.owner = owner;
	    this.name = name;
	    this.rentAmount = rentalAmount;
	    this.plot = new Plot();
	  }

	  public Property(String name, String city, double rentalAmount, String owner, int x, int y,
	      int width, int depth) {
	    this.city = city;
	    this.owner = owner;
	    this.name = name;
	    this.rentAmount = rentalAmount;
	    this.plot = new Plot(x, y, width, depth);
	  }

	  public String getCity() {
	    return city;
	  }

	 
	  public String getOwner() {
	    return owner;
	  }

	  

	  public String getPropertyName() {
	    return name;
	  }


	

	  public double getRentAmount() {
	    return rentAmount;
	  }


	  

	  public Plot getPlot() {
	    return plot;
	  }

	
	  @Override
	  public String toString() {
		  return name + "," + city + "," + owner + "," + rentAmount;
	  }


}
