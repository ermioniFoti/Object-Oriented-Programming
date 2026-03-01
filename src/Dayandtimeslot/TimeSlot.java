package Dayandtimeslot;

import java.util.Date;

import vaccination_system.Appointment;

public class TimeSlot {
	private Date date;
	private Appointment[] everyDayAppointmentArray = new Appointment[4];
	private int everyDayAppointmentCounter = 0;
	
	//Constructor
	public TimeSlot(Date date) {
		this.date = date;
	}

	//Method for adding an appointment and checking if the number of appointments   is more than 4
	public void addAppointment(Appointment a) {
		if(everyDayAppointmentCounter >4) {
			System.out.println("Cannot insert another appointment:"+a.toString());
			return;
		}
		this.everyDayAppointmentArray[everyDayAppointmentCounter]=a;
		everyDayAppointmentCounter ++;
	}
    
	//Getters and Setters
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Appointment[] getEveryDayAppointmentArray() {
		return everyDayAppointmentArray;
	}

	public void setEveryDayAppointmentArray(Appointment[] everyDayAppointmentArray) {
		this.everyDayAppointmentArray = everyDayAppointmentArray;
	}

	public int getEveryDayAppointmentCounter() {
		return everyDayAppointmentCounter;
	}

	public void setEveryDayAppointmentCounter(int everyDayAppointmentCounter) {
		this.everyDayAppointmentCounter = everyDayAppointmentCounter;
	}

	
	
	

}
