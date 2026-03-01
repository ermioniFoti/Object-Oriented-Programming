package vaccination_system;


import java.util.Scanner;

import vaccination_system.Doctor;
import vaccination_system.SecuredCitizen;
import vaccination_system.Appointment;
import vaccination_system.VaccinationCenter;
import Dayandtimeslot.Day;
import Dayandtimeslot.TimeSlot;

import java.util.ArrayList;
import java.util.Random;




public class VaccinationSystem {
	private String name;
	private String url;
	private Day[] dayArray = new Day[7];
	private SecuredCitizen[] securedCitizenArray = new SecuredCitizen[100];
	private int securedCitizenCounter =0;
	private VaccinationCenter[] vaccinationCenterArray  =new VaccinationCenter[10];
	private int vaccinationCenterCounter = 0;
	
	//Constructor
	public VaccinationSystem(String name, String url) {
		this.name = name;
		this.url = url;
	}
	
	
	//Functions
	//adding a secured citizen to array of secured citizens and checking if the number of secured citizens is more than 100
	public void addSecuredCitizen(SecuredCitizen sc) {
		if(securedCitizenArray.length>100) {
			System.out.println("This secured citizen:"+sc.toString()+"cannot be inserted");
			return;
		}
		this.securedCitizenArray[securedCitizenCounter] =sc;
		securedCitizenCounter++;
	}
	
	//adding a vaccination center to array of vaccination centers and checking if the number if vaccination centers is more than 10
	public void addVaccinationCenter(VaccinationCenter vc) {
		if(vaccinationCenterCounter>10) {
			System.out.printf("This vaccination center:",vc.toString(),"cannot be inserted");
			return;
		}
		this.vaccinationCenterArray[vaccinationCenterCounter] = vc;
		vaccinationCenterCounter++;
	}
	
	//introduction of secured citizen
	public void addSecuredCitizen() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n---Introduction of secured citizen---\n");
		System.out.printf("Insert the amka of secured citizen: ");
		long amkaNew = sc.nextLong();
		System.out.printf("Insert the name of secured citizen: ");
		String fullnameNew = sc.next();
		System.out.printf("Insert the city of secured citizen: ");
		String cityofresidenceNew = sc.next();
		//Create a SecuredCitizen object
		SecuredCitizen tempSecuredCitizen = new SecuredCitizen(amkaNew, fullnameNew, cityofresidenceNew);
		addSecuredCitizen(tempSecuredCitizen);
	}
	//introduction of vaccination center
	public void addVaccinationCenter() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n---Introduction of vaccination center---\n");
		System.out.printf("Insert the code of vaccination center: ");
		int codeNew =sc.nextInt();
		System.out.printf("Insert the title of vaccination center: ");
		String titleNew = sc.next();
		System.out.printf("Insert the city of vaccination center: ");
		String cityNew = sc.next();
		//Create a VaccinationCenter object
		VaccinationCenter tempVaccinationCenter = new VaccinationCenter(codeNew, titleNew, cityNew, dayArray);
		addVaccinationCenter(tempVaccinationCenter);
	}
	
	//introduction of doctor
	
	public void addDoctor() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n---Introduction of doctor---\n");
		System.out.printf("Insert the registration number of doctor: ");
		long regnumberNew =sc.nextLong();
		System.out.printf("Insert the full name of doctor: ");
		String fullnameNew = sc.next();
		//Create a  Doctor object
		Doctor tempDoctor = new Doctor(regnumberNew, fullnameNew);
		System.out.println("\n---Choice of vaccination center---\n");
		//Choose Vaccination Center
		for(int i=0;i<getVaccinationCenterArray().length;i++) {
			if(getVaccinationCenterArray()[i]!=null) {
				System.out.println(i+") Code: "+getVaccinationCenterArray()[i].getCode()+" Title:"+getVaccinationCenterArray()[i].getCode()+"City:"+getVaccinationCenterArray()[i].getCity());
			}
		}
		System.out.printf("Insert the choice: ");
		int choice = sc.nextInt();
		//Introduction tempDoctor to selected Vaccination Center
		getVaccinationCenterArray()[choice].addDoctor(tempDoctor);
	}
	
	public void addAppointment() {
		Scanner sc = new Scanner(System.in);
		//Random number generation from 0 -200
		int appointmentCode = new Random().nextInt(200);
		//Énitialization of variables
		SecuredCitizen selectedSecuredCitizen = null;
		VaccinationCenter selectedVaccinationCenter =null;
		Doctor selectedDoctor = null;
		int selectedDay =0;
		
		
		System.out.println("\n---New Appointment---\n");
		
		System.out.printf("Insert the amka of secured citizen: ");
		long selectedAmka =sc.nextLong();
		for(int i=0;i<getSecuredCitizenArray().length;i++) {
			if(getSecuredCitizenArray()[i]!=null && getSecuredCitizenArray()[i].getAmka()==selectedAmka) {
				selectedSecuredCitizen=getSecuredCitizenArray()[i];	
			}
		}
		if(selectedSecuredCitizen==null) {
			System.out.println("Secured Citizen with this amka is not found "+selectedAmka);
			return;
		}
		
		
		//Choose vaccination center
		for(int i=0;i<getVaccinationCenterArray().length;i++) {
			if(getVaccinationCenterArray()[i]!=null && selectedSecuredCitizen.getCityofresidence().equals(getVaccinationCenterArray()[i].getCity())) {
				selectedVaccinationCenter = getVaccinationCenterArray()[i];
			}
		}
		if(selectedVaccinationCenter==null) {
			System.out.println("Vaccination Center is not found in the city of secured citizen");
			return;
			}
		else
		{
			System.out.println("Vaccination Center was selected:"+selectedVaccinationCenter.getCode() +" Title "+selectedVaccinationCenter.getTitle());
		}
		
		
		//Choose day
		for(int i=0;i<selectedVaccinationCenter.getDayArray().length;i++) {
			System.out.println(i+") "+(1900+selectedVaccinationCenter.getDayArray()[i].getDate().getYear())+"-"+(selectedVaccinationCenter.getDayArray()[i].getDate().getMonth()+1)+"-"+selectedVaccinationCenter.getDayArray()[i].getDate().getDate());
		}
		System.out.printf("Select the day: ");
		selectedDay = sc.nextInt();
		
		
		//Choose TimeSlot
		TimeSlot[] timeSlotArray =selectedVaccinationCenter.getDayArray()[selectedDay].getTimeSlotArray();
		//Helping string
		String availability="";
		for(int i=0;i<timeSlotArray.length;i++) {	
			//Searching until the number of doctors that has  the vaccination center
			for(int j=0;j<selectedVaccinationCenter.getDoctorCounter();j++) {
				//if finds an empty position in array, fill the helping string with Available.Otherwise,fill with Full.
				if(timeSlotArray[i].getEveryDayAppointmentArray()[j]==null) {
					availability = "->Available";			
				}
				else
				{
					availability = "-->***FULL***";
				}
			}
			System.out.println(i+") "+timeSlotArray[i].getDate()+availability);
		}
		System.out.printf("Select hour: ");
		int timeSlotSelected =sc.nextInt();
		//instantiation of  appointment in the first empty position of array timeslot.
		int doctorPosition =-2;
		for(int i=0;i<selectedVaccinationCenter.getDoctorCounter();i++) {
			if(timeSlotArray[timeSlotSelected].getEveryDayAppointmentArray()[i]==null) {
				doctorPosition =i;
			}
		}
		//checking if the user chooses a position that is full
		if(doctorPosition==-2) {
			System.out.println("There is no availability in selected Time Slot");
			System.out.println("Try again...");
			return;
		}
		
		
		//Selection of Doctor
		int minValue = Integer.MAX_VALUE;
		for(int i=0;i<selectedVaccinationCenter.getDoctorArray().length;i++) {
			if(selectedVaccinationCenter.getDoctorArray()[i]!=null && selectedVaccinationCenter.getDoctorArray()[i].getAppointmentCounter()<=minValue) {
				minValue = selectedVaccinationCenter.getDoctorArray()[i].getAppointmentCounter();
				selectedDoctor=selectedVaccinationCenter.getDoctorArray()[i];
			}
		}
		
		//instantiation of  Appointment
		Appointment createdAppointment =new Appointment(appointmentCode,selectedSecuredCitizen,selectedVaccinationCenter,selectedDoctor);
		createdAppointment.setDate(timeSlotArray[timeSlotSelected].getDate());
		//instantiation of  Created Appointment to  Vaccination Center
		selectedVaccinationCenter.addAppointment(createdAppointment, selectedDay, timeSlotSelected, doctorPosition);
		//instantiation of  Created Appointment to Doctor
		selectedDoctor.addAppointment(createdAppointment);
		//instantiation Created Appointment to Secured Citizen 
		selectedSecuredCitizen.addAppointment(createdAppointment);
			
		
	}
	
	
	public void FindAndPrintAppointment() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n---Find and print appointment---\n");
		System.out.println("------------");
		System.out.println("1) Search with amka");
		System.out.println("2) Search with Vaccination Center");
		System.out.println("3) Search with registration number of Doctor");
		System.out.println("4) Return to the menu");
		System.out.println("------------");
		int choise=sc.nextInt();
		
		switch(choise) {
		case 1:
			//Search with amka
			System.out.printf("--Insert amka: ");
			long amkaSelected = sc.nextLong();
			for(int i=0;i<securedCitizenArray.length;i++) {
				if(securedCitizenArray[i]!=null && securedCitizenArray[i].getAmka()==amkaSelected) {
					Appointment a =securedCitizenArray[i].getAppointment();
					System.out.println("Appointment: "+a.getCodeAppointment()+"Vacciantion Center:"+a.getVaccinationCenter().getCode()+"Doctor:"+a.getDoctor().getFullname()+"Date:"+a.getDate());
				}
				
			}
			break;
		case 2:
			//Search with Vaccination Center
			System.out.printf("--Give the code of vaccination center: ");
			int codeSelected= sc.nextInt();
			VaccinationCenter vc = null;
			for(int i=0;i<vaccinationCenterArray.length;i++) {
				if(vaccinationCenterArray[i]!=null && vaccinationCenterArray[i].getCode()==codeSelected) {
					vc=vaccinationCenterArray[i];
				}
			}
			if(vc==null) {
				System.out.println("Vaccination center is not found");
				return;
			}
			//Search in 3D array [Day][TimeSlot][5]
			for(int i=0;i<vc.getDayArray().length;i++) {
				for(int j=0; j<vc.getDayArray()[i].getTimeSlotArray().length;j++) {
					for(int k=0; k<vc.getDayArray()[i].getTimeSlotArray()[j].getEveryDayAppointmentArray().length;k++) {
						if(vc.getDayArray()[i].getTimeSlotArray()[j].getEveryDayAppointmentArray()[k]!=null) {
							Appointment a =vc.getDayArray()[i].getTimeSlotArray()[j].getEveryDayAppointmentArray()[k];
							System.out.println("Appointment: "+a.getCodeAppointment()+"VaccinationCenter:"+a.getVaccinationCenter().getCode()+"Doctor:"+a.getDoctor().getFullname()+"Date:"+a.getDate());
						}
					}
				}
			}
			
			
			break;
			//Search with doctor
		case 3:
			System.out.printf("--Insert the registartion number of doctor: ");
			long doctorSelected=sc.nextLong();
			for(int i=0;i<vaccinationCenterArray.length;i++) {
				if(vaccinationCenterArray[i]!=null) {
					Doctor[] doctors = vaccinationCenterArray[i].getDoctorArray();
					for(int j=0;j<doctors.length;j++) {
						if(doctors[j]!=null && doctors[j].getRegnumber()==doctorSelected) {
							Appointment[] apps = doctors[j].getAppointmentArray();
							for(int k=0;k<apps.length;k++) {
								if(apps[k]!=null) {
									Appointment ap = apps[k];
									System.out.println("Appointment: "+ap.getCodeAppointment()+" Vaccination Center:"+ap.getVaccinationCenter().getCode()+" Doctor:"+ap.getDoctor().getFullname()+" Date:"+ap.getDate());
								}
							}
						}
					}
				}
			}

			break;
		case 4:
			break;
		}
		
		
	}
	
	//print Secured Citizens
	public void PrintSecuredCitzens() {
		System.out.println("\n---Print Secured Citizens---\n");
		for(int i=0;i<getSecuredCitizenArray().length;i++) {
			if(getSecuredCitizenArray()[i]!=null) {
				System.out.println(i+") Amka:"+getSecuredCitizenArray()[i].getAmka()+"Full name:"+getSecuredCitizenArray()[i].getFullName()+" City:"+getSecuredCitizenArray()[i].getCityofresidence());
				if(getSecuredCitizenArray()[i].getAppointment()!=null) {
					Appointment ap = getSecuredCitizenArray()[i].getAppointment();
					System.out.println("\tAppointment: "+ap.getCodeAppointment()+" Vaccination Center:"+ap.getVaccinationCenter().getCode()+" Doctor:"+ap.getDoctor().getFullname()+" Date:"+ap.getDate());
				}					
			}
		}
	}
	
	//Print Vaccination Center
	public void PrintVaccinationCenters() {
		System.out.println("\n---Print Vaccination Centers---\n");
		for(int i=0;i<getVaccinationCenterArray().length;i++) {
			if(getVaccinationCenterArray()[i]!=null) {
				System.out.println(i+") Code: "+getVaccinationCenterArray()[i].getCode()+" Title: "+getVaccinationCenterArray()[i].getCode()+" City:"+getVaccinationCenterArray()[i].getCity());
			}
		}
	}
	
	//Print Doctors
	public void PrintDoctors() {
		System.out.println("\n---Print Doctors---\n");
		for(int i=0;i<getVaccinationCenterArray().length;i++) {
			if(getVaccinationCenterArray()[i]!=null) {
				for(int j=0;j<getVaccinationCenterArray()[i].getDoctorArray().length;j++) {
					if(getVaccinationCenterArray()[i].getDoctorArray()[j]!=null) {
						System.out.println("\tIATROS: AM:"+getVaccinationCenterArray()[i].getDoctorArray()[j].getRegnumber()+" Name:"+getVaccinationCenterArray()[i].getDoctorArray()[j].getFullname());
					}
				}
			}
			
		}
	}

    //Getters and setters
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public Day[] getDayArray() {
		return dayArray;
	}


	public void setDayArray(Day[] dayArray) {
		this.dayArray = dayArray;
	}


	public SecuredCitizen[] getSecuredCitizenArray() {
		return securedCitizenArray;
	}


	public void setSecuredCitizenArray(SecuredCitizen[] securedCitizenArray) {
		this.securedCitizenArray = securedCitizenArray;
	}


	public int getSecuredCitizenCounter() {
		return securedCitizenCounter;
	}


	public void setSecuredCitizenCounter(int securedCitizenCounter) {
		this.securedCitizenCounter = securedCitizenCounter;
	}


	public VaccinationCenter[] getVaccinationCenterArray() {
		return vaccinationCenterArray;
	}


	public void setVaccinationCenterArray(VaccinationCenter[] vaccinationCenterArray) {
		this.vaccinationCenterArray = vaccinationCenterArray;
	}


	public int getVaccinationCenterCounter() {
		return vaccinationCenterCounter;
	}


	public void setVaccinationCenterCounter(int vaccinationCenterCounter) {
		this.vaccinationCenterCounter = vaccinationCenterCounter;
	}
	
	
	

}
