import java.util.Scanner;

public class PatientDriverApp {
	public static void main (String [] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter patient information:");
		System.out.print("First Name: ");
		String firstName = scanner.nextLine();
		System.out.print("Middle Name: ");
		String middleName = scanner.nextLine();
		System.out.print("Last name: ");
		String lastName = scanner.nextLine();
		System.out.print("Street address: ");
		String streetAddress = scanner.nextLine();
		System.out.print("City: ");
        String city = scanner.nextLine();
        System.out.print("State: ");
        String state = scanner.nextLine();
        System.out.print("Zipcode: ");
        int zipcode = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Emergency Contact: ");
        String emergencyContact = scanner.nextLine();
        System.out.print("Emergency Contact Number: ");
        String emergencyContactNumber = scanner.nextLine();

        Patient patient = new Patient(firstName, middleName, lastName,
                streetAddress, city, state, zipcode, phoneNumber,
                emergencyContact, emergencyContactNumber);
        
        Procedure procedure1 = new Procedure("Annual Checkup", "2023-01-15");
        Procedure procedure2 = new Procedure("Dental Hygiene", "2023-02-28", "Dr. Lee", 150.00);
        Procedure procedure3 = new Procedure("Tonsil Surgery", "2023-03-10", "Dr. Smith", 200.00);
        
        System.out.println("\nPatient Information:");
        displayPatient(patient);
        
        System.out.println("\n\tProcedure Information:");
        displayProcedure(procedure1);
        displayProcedure(procedure2);
        displayProcedure(procedure3);
        
        
        double totalCharges = calculateTotalCharges(procedure1, procedure2, procedure3);

        System.out.printf("\nTotal Charges $: %,.2f%n", totalCharges);
        
        System.out.println("Student Name: Aishwarya Niroula \nMC#: M21114769 \nDue Date: 06/12/2023");

        scanner.close();
    }
	public static void displayPatient(Patient patient) {
        System.out.println(" " + "Name: " + patient.getFirstName() + " " + patient.getMiddleName() + " " + patient.getLastName());
        System.out.println(" " + "Address: " + patient.getStreetAddress() + ", " + patient.getCity() + ", " + patient.getState() + " " + patient.getZipcode());
        System.out.println(" " + "Phone: " + patient.getPhoneNumber());
        System.out.println(" " + "Emergency Contact: " + patient.getEmergencyContact() + " (" + patient.getEmergencyContactNumber() + ")");
    }

    public static void displayProcedure(Procedure procedure) {
        System.out.println("\tProcedure Name: " + procedure.getProcedureName());
        System.out.println("\tProcedure Date: " + procedure.getProcedureDate());
        if (procedure.getPractitionerName() != null) {
            System.out.println("\tPractitioner: " + procedure.getPractitionerName());
        }
        System.out.printf("\tCharges: $%,.2f%n", procedure.getCharges());
    }

    public static double calculateTotalCharges(Procedure procedure1, Procedure procedure2, Procedure procedure3) {
        return procedure1.getCharges() + procedure2.getCharges() + procedure3.getCharges();
    }


}
