import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestStudent {
    ManagementCompany mgmt; 
	
	@Before
	public void setUp() throws Exception {
		//student create a management company
	    mgmt= new ManagementCompany("Titan", "31415",5);
		
		//student add three properties, with plots, to mgmt co
	    mgmt.addProperty("Darnestwon Rd", "Gaithersbug", 2750, "Jess Moran",2,1,3,3);
        mgmt.addProperty("Orchard Dr", "Germantown", 1450, "John Lewis",6,1,2,2);
        mgmt.addProperty("DuFief Valley", "Rockville", 3250, "Cal Cobra",2,5,3,3);
		
	}

	@After
	public void tearDown() {
		//student set mgmt co to null  
	  mgmt = null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		//student should add property with 4 args & default plot
		assertEquals(mgmt.addProperty("Tmberock", "Hill", 500, "Elly"),3,0);
		//student should add property with 8 args
		assertEquals(mgmt.addProperty("Apple", "Knolls", 4500, "Jake", 5, 5, 2, 2), 4,0);
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1
		assertEquals(mgmt.addProperty("Potomac", "Valley", 3100, "Dan", 7,4,2,2), -1, 0);
	}
 
	

	@Test
	public void testTotalRent() {
		//student should test if totalRent returns the total rent of properties
		assertEquals(mgmt.getTotalRent(),7450,0);
	}

 }