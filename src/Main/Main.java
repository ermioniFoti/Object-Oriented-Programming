package Main;


	import java.util.Random;
	import java.util.Scanner;

	import Dayandtimeslot.Day;
	import vaccination_system.Doctor;
	import vaccination_system.SecuredCitizen;
	import vaccination_system.Appointment;
	import vaccination_system.VaccinationCenter;
	import vaccination_system.VaccinationSystem;

	public class Main {

		public static void main(String[] args) {
			System.out.println("Vaccination System ");
			VaccinationSystem vs = new VaccinationSystem("Nationa Vaccination Program", "https://emvolio.gov.gr");
			//manual introduction of secured citizens
			SecuredCitizen sc1 = new SecuredCitizen(11111111, "Asfalismenos  1", "CHANIA");
			SecuredCitizen sc2 = new SecuredCitizen(22222222, "Asfalismenos  2", "CHANIA");
			SecuredCitizen sc3 = new SecuredCitizen(33333333, "Asfalismenos  3", "CHANIA");
			SecuredCitizen sc4 = new SecuredCitizen(44444444, "Asfalismenos  4", "CHANIA");
			SecuredCitizen sc5 = new SecuredCitizen(55555555, "Asfalismenos  5", "CHANIA");
			SecuredCitizen sc6 = new SecuredCitizen(66666666, "Asfalismenos  6", "RETHYMNO");
			SecuredCitizen sc7 = new SecuredCitizen(77777777, "Asfalismenos  7", "RETHYMNO");
		    SecuredCitizen sc8 = new SecuredCitizen(88888888, "Asfalismenos  8", "RETHYMNO");
		    SecuredCitizen sc9 = new SecuredCitizen(99999999, "Asfalismenos  9", "RETHYMNO");
			vs.addSecuredCitizen(sc1);
			vs.addSecuredCitizen(sc2);
			vs.addSecuredCitizen(sc3);
			vs.addSecuredCitizen(sc4);
			vs.addSecuredCitizen(sc5);
			vs.addSecuredCitizen(sc6);
			vs.addSecuredCitizen(sc7);
			vs.addSecuredCitizen(sc8);
			vs.addSecuredCitizen(sc9);
			
			//manual introduction of days
			Day[] manualDay = new Day[7];
			manualDay[0]= new Day(22);
			manualDay[1]= new Day(23);
			manualDay[2]= new Day(24);
			manualDay[3]= new Day(25);
			manualDay[4]= new Day(26);
			manualDay[5]= new Day(27);
			manualDay[6]= new Day(28);
			
			//manual introduction of  Vaccination Centers in two different cities
			VaccinationCenter vc1 =new VaccinationCenter(22222, "CH-22", "CHANIA");
			vc1.setDayArray(manualDay);
			Doctor d1 = new Doctor(111111,"Doctor 1");
			Doctor d2 = new Doctor(222222,"Doctor 2");
			Doctor d3 = new Doctor(333333,"Doctor 3");
			vc1.addDoctor(d1);
			vc1.addDoctor(d2);
			vc1.addDoctor(d3);
			

			VaccinationCenter vc2 =new VaccinationCenter(33333, "RTH-33", "RETHYMNO");
			vc2.setDayArray(manualDay);
			Doctor d4 = new Doctor(444444,"Doctor 4");
			Doctor d5 = new Doctor(555555,"Doctor 5");
			vc2.addDoctor(d4);
			vc2.addDoctor(d5);
			
			//manual introduction of Appointment to vc1
			Appointment ap1 =new Appointment(20,sc1,vc1,d1);
			ap1.setDate(manualDay[0].getTimeSlotArray()[0].getDate());
			d1.addAppointment(ap1);
			sc1.addAppointment(ap1);
			Appointment ap2 =new Appointment(21,sc2,vc1,d1);
			ap2.setDate(manualDay[0].getTimeSlotArray()[3].getDate());
			d1.addAppointment(ap2);
			sc2.addAppointment(ap2);
			Appointment ap3 =new Appointment(22,sc3,vc1,d2);
			ap3.setDate(manualDay[0].getTimeSlotArray()[3].getDate());
			d2.addAppointment(ap3);
			sc3.addAppointment(ap3);
			Appointment ap4 =new Appointment(23,sc4,vc1,d3);
			ap4.setDate(manualDay[0].getTimeSlotArray()[3].getDate());
			d3.addAppointment(ap4);
			sc4.addAppointment(ap4);
			Appointment ap5 =new Appointment(24,sc5,vc1,d1);
			ap5.setDate(manualDay[1].getTimeSlotArray()[1].getDate());
			d1.addAppointment(ap5);
			sc5.addAppointment(ap5);
			
			vc1.addAppointment(ap1, 0, 0, 0);
			vc1.addAppointment(ap2, 0, 3, 0);
			vc1.addAppointment(ap3, 0, 3, 1);
			vc1.addAppointment(ap4, 0, 3, 2);
			vc1.addAppointment(ap5, 1, 1, 0);
			
			//manual introduction of Appointment to vc2
			Appointment ap11 = new Appointment(30,sc6,vc2,d4);
			ap11.setDate(manualDay[1].getTimeSlotArray()[0].getDate());
			d4.addAppointment(ap11);
			sc6.addAppointment(ap11);
			Appointment ap12 = new Appointment(31,sc7,vc2,d5);
			ap12.setDate(manualDay[1].getTimeSlotArray()[1].getDate());
			d5.addAppointment(ap12);
			sc7.addAppointment(ap12);
			Appointment ap13 = new Appointment(32,sc8,vc2,d5);
			ap13.setDate(manualDay[1].getTimeSlotArray()[2].getDate());
			d5.addAppointment(ap13);
			sc8.addAppointment(ap13);
			Appointment ap14 = new Appointment(33,sc9,vc2,d4);
			ap14.setDate(manualDay[2].getTimeSlotArray()[1].getDate());
			d4.addAppointment(ap14);
			sc9.addAppointment(ap14);
			
			vc2.addAppointment(ap11, 1, 0, 0);
			vc2.addAppointment(ap12, 1, 1, 1);
			vc2.addAppointment(ap13, 1, 2, 0);
			vc2.addAppointment(ap14, 2, 0, 0);
			
			//Add Vaccination Centers to Vaccination System
			vs.addVaccinationCenter(vc1);
			vs.addVaccinationCenter(vc2);
			
			
			//Menu 
			Scanner sc = new Scanner(System.in);
			while (true) {
				System.out.println("------Menu-------");
				System.out.println("1) Introduction of Secured Citizen");
				System.out.println("2) Introduction of Vaccination Center");
				System.out.println("3) Introduction of Doctor");
				System.out.println("4) New Appointment");
				System.out.println("5) Find and Print Appointment");
				System.out.println("6) Print Secured Citizens");
				System.out.println("7) Print Vaccination Centers");
				System.out.println("8) Print Doctors");
				System.out.println("9) Exit");
				System.out.printf("-- Choose witch operation you want:");
				int operation= sc.nextInt();			
				switch (operation){
				case 1:
					vs.addSecuredCitizen();
					break;
				case 2:
					vs.addVaccinationCenter();
					break;
				case 3:
					vs.addDoctor();		
					break;
				case 4:
					vs.addAppointment();
					break;
				case 5:
					vs.FindAndPrintAppointment();
					break;
				case 6:
					vs.PrintSecuredCitzens();
					break;
				case 7:
					vs.PrintVaccinationCenters();
					break;
				case 8:
					vs.PrintDoctors();		
					break;
				case 9:
					System.out.println("Termination of program...");
					System.exit(0);
					break;
				default:
					break;
				}
			}
		}
	}


