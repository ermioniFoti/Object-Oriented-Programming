package vaccination_system;

import java.util.Date;

public class Appointment {
	private int codeAppointment;
	private Date date;
	private SecuredCitizen securedCitizen;
	private VaccinationCenter vaccinationCenter;
	private Doctor doctor;
	
	//constructor
	public Appointment(int codeAppointment, SecuredCitizen securedCitizen,
			VaccinationCenter vaccinationCenter, Doctor doctor) {
	
		this.codeAppointment = codeAppointment;
		this.securedCitizen = securedCitizen;
		this.vaccinationCenter = vaccinationCenter;
		this.doctor = doctor;
	}

    //Getters and setters
	public int getCodeAppointment() {
		return codeAppointment;
	}


	public void setCodeAppointment(int codeAppointment) {
		this.codeAppointment = codeAppointment;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public SecuredCitizen getSecuredCitizen() {
		return securedCitizen;
	}


	public void setSecuredCitizen(SecuredCitizen securedCitizen) {
		this.securedCitizen = securedCitizen;
	}


	public VaccinationCenter getVaccinationCenter() {
		return vaccinationCenter;
	}


	public void setVaccinationCenter(VaccinationCenter vaccinationCenter) {
		this.vaccinationCenter = vaccinationCenter;
	}


	public Doctor getDoctor() {
		return doctor;
	}


	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	
}
	
	
	
	

