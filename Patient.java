
public class Patient {
	
	
	private String firstName;
	private String middleName;
	private String lastName;
	private String streetAddress;
	private String city;
	private String state;
	private int zipcode;
	private String phoneNumber;
	private String emergencyContact;
	private String emergencyContactNumber;
	
	public Patient()
	{
		firstName = null;
		middleName = null;
		lastName = null;
		streetAddress = null;
		city = null;
		state = null;
		zipcode = 0;
		phoneNumber = null;
		emergencyContact = null;
		emergencyContactNumber = null;
	}
	
	public Patient(String firstName, String middleName, String lastName) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}
	
	public Patient(String firstName, String middleName, String lastName, 
			String streetAddress, String city, String state, int zipcode, 
			String phoneNumber, String emergencyContact, String emergencyContactNumber) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.phoneNumber = phoneNumber;
		this.emergencyContact = emergencyContact;
		this.emergencyContactNumber = emergencyContactNumber;
	
     }


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
	public void setEmergencyContactNumber(String emergencyContactNumber) {
		this.emergencyContactNumber = emergencyContactNumber;
	}
	
	String getFirstName() {
		return firstName;
	}
	String getMiddleName() {
		return middleName;
	}
	String getLastName() {
		return lastName;
	}
	String getStreetAddress() {
		return streetAddress;
	}
	String getCity() {
		return city;
	}
	String getState() {
		return state;
	}
	int getZipcode() {
		return zipcode;
	}
	String getPhoneNumber() {
		return phoneNumber;
	}
	String getEmergencyContact() {
		return emergencyContact;
	}
	String getEmergencyContactNumber() {
		return emergencyContactNumber;
	}
	
	public void buildFullName() {
		System.out.println("Name: " + firstName + " " + middleName + " " + lastName);
	}
	public void buildAddress() {
		System.out.println("Address: " + streetAddress + " " + city + " " + state + " " + zipcode);
	}
	public void buildEmergencyContact() {
		System.out.println("EmergencyContact: " + emergencyContact + " " + emergencyContactNumber);
	}

	@Override
	public String toString() {
			
		String buildFullName = null;
		String buildAddress = null;
		String buildEmergencyContact = null;
		return "Patient Information: \n" + buildFullName + buildAddress 
				+ buildEmergencyContact;
	}
	
    }
	


	


