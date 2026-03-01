package vaccination_system;

public class SecuredCitizen {
	private long amka;
	private String fullName;
	private String cityofresidence;
	private Appointment appointment;
	
	//constructor
	public SecuredCitizen(long amka,String fullName,String cityofresidence)
	{
		this.amka=amka;
		this.fullName=fullName;
		this.cityofresidence=cityofresidence;
	}
	
	//adding  appointment to secured citizen
	public void addAppointment(Appointment a) {
		this.appointment=a;
	}
	
	//Getters and setters

	public long getAmka() {
		return amka;
	}

	public void setAmka(long amka) {
		this.amka = amka;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCityofresidence() {
		return cityofresidence;
	}

	public void setCityofresidence(String cityofresidence) {
		this.cityofresidence = cityofresidence;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	

}