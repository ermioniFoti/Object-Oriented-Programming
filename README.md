# Pharmacy Management System

A Java-based management system for handling medicines, patients, doctors, and medical prescriptions. [cite_start]This project was developed as part of the **PLH 102 - Object-Oriented Programming** course at the **Technical University of Crete** (Spring 2022)[cite: 1, 3, 4].

## 📌 Project Overview
[cite_start]The system allows a pharmacy to manage its daily operations digitally[cite: 22]. [cite_start]It tracks medicine inventory, patient records, and doctor-issued prescriptions while ensuring data integrity through unique identification numbers[cite: 27, 33, 39, 43].

## 🚀 Features
[cite_start]The application provides a comprehensive menu-driven interface [cite: 71] with the following capabilities:

* [cite_start]**Entity Management:** Register new Medicines, Doctors, and Patients into the system[cite: 51, 52, 53].
* [cite_start]**Prescription Execution:** Create prescriptions by linking existing doctors and patients with a selection of up to six medicines[cite: 49, 54, 55].
* [cite_start]**Data Validation:** Automatic error messaging if a non-existent doctor or patient is selected during prescription entry[cite: 57, 59].
* [cite_start]**Advanced Search:** Filter prescriptions by ID, Doctor's Registration Number (AM), Patient's Social Security Number (AMKA), or specific date ranges[cite: 61, 62, 63, 64, 65].
* [cite_start]**Financial Tracking:** Calculate total costs for prescriptions associated with a specific doctor or patient[cite: 66, 67, 68].
* [cite_start]**Reporting:** Print full lists of all records (medicines, doctors, patients, and prescriptions) stored in memory[cite: 69, 70].

## 🛠️ Technical Specifications
* [cite_start]**Language:** Java[cite: 22].
* [cite_start]**Architecture:** Object-Oriented Design focusing on encapsulation and modularity[cite: 75, 77].
* [cite_start]**Data Handling:** All data is held in main memory (RAM) for the duration of the session[cite: 70].
* [cite_start]**UI:** Console-based Command Line Interface (CLI)[cite: 82, 83].



## 📂 Class Structure
[cite_start]The project is organized into distinct classes to ensure a "one-source-of-truth" model[cite: 92]:
* [cite_start]**Pharmacy:** Stores store info (Name, Address, Phone)[cite: 23, 24, 25].
* [cite_start]**Medicine:** Handles medicine details and auto-generated IDs[cite: 26, 27].
* [cite_start]**Doctor:** Manages doctor details and their list of prescribed recipes[cite: 37, 41].
* [cite_start]**Patient:** Manages patient details and their personal prescription history[cite: 31, 35].
* [cite_start]**Prescription:** Links all entities together with quantities and timestamps[cite: 42, 45, 46, 47].
* [cite_start]**Main:** Acts as the entry point and handles the user interface/menu[cite: 81, 82].

## 📝 Development Guidelines Followed
* [cite_start]**Naming Conventions:** Adheres to standard Java Code Conventions[cite: 80].
* [cite_start]**Documentation:** Explanatory comments written in Latin characters for universal encoding compatibility[cite: 10, 11].
* [cite_start]**ID Management:** Unique IDs for medicines and prescriptions are handled automatically by the system[cite: 27, 43].

---
[cite_start]**Note:** This project was created for educational purposes at the Technical University of Crete[cite: 1].
