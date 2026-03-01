package vaccination_system;


public class Doctor {
	private long regnumber;
	private String fullname;
	private Appointment[] appointmentArray=new Appointment[28];
	private int appointmentCounter;
	
	
    //constructor
	public Doctor(long regnumber,String fullname){
		this.regnumber=regnumber;
		this.fullname=fullname;
	}
    //Adding an  Appointement to  appointmentArray and checking if the number of appointments is more than 28(4 time slots*7 days) 
	public void addAppointment(Appointment a) {
		if(appointmentCounter>28) {
			return;
		}
		this.appointmentArray[appointmentCounter] = a;
		appointmentCounter ++;
	}
	
	//Getters and setters
	public long getRegnumber() {
		return regnumber;
	}
	public void setRegnumber(long regnumber) {
		this.regnumber = regnumber;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public Appointment[] getAppointmentArray() {
		return appointmentArray;
	}
	public void setAppointmentArray(Appointment[] appointmentArray) {
		this.appointmentArray = appointmentArray;
	}
	public int getAppointmentCounter() {
		return appointmentCounter;
	}
	public void setAppointmentCounter(int appointmentCounter) {
		this.appointmentCounter = appointmentCounter;
	}
	
	
}
	