
public class ManagementCompany {
	private String name;
	private String taxID;
	private double mgmFee;
	static final int MAX_PROPERTY = 5;
	static final int MGMT_WIDTH = 10;
	static final int MGMT_DEPTH = 10;
	private Property[] properties;
	private Plot plot;
	private int propertiesCount;
	
	 public ManagementCompany() {
		    this.name = "";
		    this.taxID = "";
		    this.mgmFee = 0;
		    this.plot = new Plot();
		    this.properties = new Property[MAX_PROPERTY];
		  }

		  public ManagementCompany(String name, String taxID, double mgmFee) {
		    this.name = name;
		    this.taxID = taxID;
		    this.mgmFee = mgmFee;
		    this.plot = new Plot(0,0,MGMT_WIDTH, MGMT_DEPTH);
		    this.properties = new Property[MAX_PROPERTY];
		  }

		  public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		    this.name = name;
		    this.taxID = taxID;
		    this.mgmFee = mgmFee;
		    this.plot = new Plot(x,y,width,depth);
		    this.properties = new Property[MAX_PROPERTY];
		  }
		  
		  //add copy constructor
		  
		  public String getName() { //done
		        return name;
		    }

		    

		    public String getTaxID() { //done
		        return taxID;
		    }

		  

		    public double getMgmFeePer() { //done
		        return mgmFee;
		    }


		    public Property[] getProperties() { //done
		        return properties;
		    }

		    public Plot getPlot() {  //done
		        return plot;
		    }

		    public int getPropertiesCount() { //done
		        return propertiesCount;
		    }
		    
		    
		    public int addProperty(Property property) {
		        if (propertiesCount >= MAX_PROPERTY) {
		            return -1;
		        }
		        if (property == null) {
		            return -2;
		        }
		        if (!plot.encompasses(property.getPlot())) {
		            return -3;
		        }
		        for (int i = 0; i < propertiesCount; i++) {
		            if (properties[i].getPlot().overlaps(property.getPlot())) {
		                return -4;
		            }
		        }
		        properties[propertiesCount] = property;
		        propertiesCount++;
		        return propertiesCount - 1;
		    }

		    public int addProperty(String name, String city, double rentalAmount, String owner) {
		        Property property = new Property(name, city, rentalAmount, owner);
		        return addProperty(property);
		    }

		    public int addProperty(String name, String city, double rentalAmount, String owner, int x, int y, int width, int depth) {
		        Property property = new Property(name, city, rentalAmount, owner, x, y, width, depth);
		        return addProperty(property);
		    }
		        
		        public double getTotalRent() { //done
		            double totalRent = 0;
		            for (int i = 0; i < propertiesCount; i++) {
		                totalRent += properties[i].getRentAmount();
		            }
		            return totalRent;
		            
		            
		        }
		        //get mgmFeePer

		        // Method to get the property with the highest rent //done
		        public Property getHighestRentPropperty() {
		            if (propertiesCount == 0) {
		                return null;
		            }
		            Property highestRentProperty = properties[0];
		            for (int i = 1; i < propertiesCount; i++) {
		                if (properties[i].getRentAmount() > highestRentProperty.getRentAmount()) {
		                    highestRentProperty = properties[i];
		                }
		            }
		            return highestRentProperty;
		        }

		        // Method to remove the last property
		        public void removeLastProperty() {
		            if (propertiesCount > 0) {
		                properties[propertiesCount - 1] = null;
		                propertiesCount--;
		            }
		        }

		        // Method to check if the properties array is full //done
		        public boolean isPropertiesFull() {
		            return propertiesCount >= MAX_PROPERTY;
		        }

		    

		        // Method to check if the management fee is valid
		        public boolean isManagementFeeValid() {
		            return mgmFee >= 0 && mgmFee <= 100;
		        }

		        // toString method to return information of all properties
		        @Override
		        public String toString() {
		            StringBuilder sb = new StringBuilder();
		            sb.append("List of the properties for ").append(name).append(", taxID: ").append(taxID).append("\n");
		            sb.append("______________________________________________________\n");
		            for (int i = 0; i < propertiesCount; i++) {
		                sb.append(properties[i].toString()).append("\n");
		            }
		            sb.append("______________________________________________________\n");
		            sb.append("\n");
                    sb.append(" total management Fee: ").append(getTotalRent() * (mgmFee / 100));
		            return sb.toString();
		        }
		    
		       
}
	

