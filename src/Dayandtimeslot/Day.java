package Dayandtimeslot;

import java.util.Date;



public class Day {
  private Date date= new Date();
  private TimeSlot[] timeSlotArray =new TimeSlot[4];
  private int timeSlotCounter = 0;

//Constructor

@SuppressWarnings("deprecation")
public Day(int dayOfMonth) {
	this.date.setDate(dayOfMonth);
	this.timeSlotArray[0] = new TimeSlot(new Date(date.getYear(),date.getMonth(),dayOfMonth,9,0,0));
	this.timeSlotArray[1] = new TimeSlot(new Date(date.getYear(),date.getMonth(),dayOfMonth,9,30,0));
	this.timeSlotArray[2] = new TimeSlot(new Date(date.getYear(),date.getMonth(),dayOfMonth,10,0,0));
	this.timeSlotArray[3] = new TimeSlot(new Date(date.getYear(),date.getMonth(),dayOfMonth,10,30,0));
}

//Getters and Setters
public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public TimeSlot[] getTimeSlotArray() {
	return timeSlotArray;
}

public void setTimeSlotArray(TimeSlot[] timeSlotArray) {
	this.timeSlotArray = timeSlotArray;
}

public int getTimeSlotCounter() {
	return timeSlotCounter;
}

public void setTimeSlotCounter(int timeSlotCounter) {
	this.timeSlotCounter = timeSlotCounter;
}




}



