# Pharmacy Management System

A Java-based application designed to manage medicines, patients, doctors, and medical prescriptions. This project was developed for the **PLH 102 - Object-Oriented Programming** course at the **Technical University of Crete** (Spring 2022).

## 📌 Project Overview
The system provides a digital infrastructure for a single pharmacy to handle its core operations. It automates the generation of unique identification codes for medicines, patients, doctors, and prescriptions, ensuring data integrity and preventing manual entry errors.



## 🚀 Key Features
The application features a robust command-line interface (CLI) with the following functionalities:

* **Inventory & Registry:** Insert and store details for Medicines, Doctors, and Patients.
* **Prescription Management:** * Create new prescriptions by selecting from existing records.
    * Automatic validation: Generates error messages if a doctor or patient is not found in the system.
    * Limit of up to six (6) medicines per prescription.
    * Delete prescriptions via their unique ID.
* **Advanced Search & Filtering:** Find prescriptions based on:
    * Unique Prescription ID.
    * Doctor's Registration Number (AM).
    * Patient's Social Security Number (AMKA).
    * Specific date ranges (e.g., all prescriptions between two dates).
* **Financial Analysis:** Calculate the total cost of all prescriptions associated with a specific Doctor or Patient.
* **Comprehensive Reporting:** Print detailed lists of all active records in the system.

## 🛠️ Technical Specifications
* **Language:** Java
* **IDE:** Optimized for Eclipse Project environment.
* **Architecture:** Modular Object-Oriented Design.
* **Memory:** Data is maintained in the main memory (RAM) during execution.
* **Coding Standards:** Follows Java Code Conventions with Latin-character comments for encoding safety.

## 📂 System Architecture
The project is structured into logical entities to avoid data redundancy:

1.  **Pharmacy:** Contains name, address, and contact info.
2.  **Medicine:** Stores auto-generated IDs, names, and prices.
3.  **Doctor:** Manages personal details and a historical list of issued prescriptions.
4.  **Patient:** Manages personal details, AMKA, and a history of received prescriptions.
5.  **Prescription:** The central link containing the doctor, patient, date, and a set of medicines with their respective quantities.
6.  **Main:** The gateway class handling the user menu, input reading, and system initialization.

---
*Developed for the School of Electrical and Computer Engineering, Technical University of Crete.*
