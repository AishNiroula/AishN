
public class Procedure {
	private String procedureName;
	private String procedureDate;
	private String practitionerName;
	private double charges;
	
	Procedure(){
		procedureName = null;
		procedureDate = null;
		practitionerName = null;
		charges = 0;
	}
	Procedure(String procedureName, String procedureDate){
		this.procedureName = procedureName;
		this.procedureDate = procedureDate;
	}
	Procedure(String procedureName, String procedureDate,
			String practitionerName, double charges){
		this.procedureName = procedureName;
		this.procedureDate = procedureDate;
		this.practitionerName = practitionerName;
		this.charges = charges;
	}

	public void setProceduceName(String procedureName) {
		this.procedureName = procedureName;
	}
	public void setProcedureDate(String procedureDate) {
		this.procedureDate = procedureDate;
	}
	public void setPractitionerName(String practitionerName) {
		this.practitionerName = practitionerName;
	}
	public void setCharges(double charges) {
		this.charges = charges;
	}
	
	String getProcedureName(){
		return procedureName;
	}
	String getProcedureDate() {
		return procedureDate;
	}
	String getPractitionerName() {
		return practitionerName;
	}
	double getCharges() {
		return charges;
	}
	@Override
	public String toString() {
		return "Procedure: " + procedureName + "\n" + "ProcedureDate= " + "\n" +
	procedureDate + "\n" + "Practitioner= " + practitionerName + "\n" + "Charge= " 
				+ charges + "\n";
	}
	
}
