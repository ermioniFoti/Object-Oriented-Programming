package vaccination_system;


import Dayandtimeslot.Day;


public class VaccinationCenter {
	private int code;
	private String title;
	private String city;
	private Doctor[] doctorArray=new Doctor[5];
	private int doctorCounter=0;
    private Day[] dayArray=new Day[7];
    private Appointment[][][] appointmentArray=new Appointment[7][4][5];
    
    //constructors
	public VaccinationCenter(int code, String title, String city) {
	
		this.code = code;
		this.title = title;
		this.city = city;
	}

	public VaccinationCenter(int code, String title, String city,Day[] dayArray) {
		
		this.code = code;
		this.title = title;
		this.city = city;
		this.dayArray = dayArray;
		
	}
	
	//method for adding a doctor and checking if the number of doctors is more than 5
	public void addDoctor(Doctor d) {
		if(doctorCounter>5) {
			System.out.println("Cannot insert Doctor: "+d.toString());
			return;
		}
		this.doctorArray[doctorCounter]=d;
		doctorCounter++;
	}
	//method for adding an appointment to a vaccination center and checking if the data is valid
	public void addAppointment(Appointment a,int day,int timeSlot,int doctor) {
	
		if(day>7 || timeSlot>4 || doctor>5) {
			System.out.println("This appointment cannot be inserted  to this Vaccination Center "+a.toString());
			return;
		}
		this.dayArray[day].getTimeSlotArray()[timeSlot].addAppointment(a);
	}
	
	//Getters and Setters

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Doctor[] getDoctorArray() {
		return doctorArray;
	}

	public void setDoctorArray(Doctor[] doctorArray) {
		this.doctorArray = doctorArray;
	}

	public int getDoctorCounter() {
		return doctorCounter;
	}

	public void setDoctorCounter(int doctorCounter) {
		this.doctorCounter = doctorCounter;
	}

	public Day[] getDayArray() {
		return dayArray;
	}

	public void setDayArray(Day[] dayArray) {
		this.dayArray = dayArray;
	}

	public Appointment[][][] getAppointmentArray() {
		return appointmentArray;
	}

	public void setAppointmentArray(Appointment[][][] appointmentArray) {
		this.appointmentArray = appointmentArray;
	}
	
	
}
	
    
	