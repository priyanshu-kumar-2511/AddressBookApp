# 📒 AddressBookApp

A **Spring Boot based Java application** developed to design and implement a digital Address Book system.
The project focuses on **incremental development, modular architecture, and progressive feature expansion** to build a scalable and maintainable contact management application.

---

# 📖 Overview

AddressBookApp is a modular Spring Boot project designed to model and manage contacts within an Address Book.
The application evolves through **incremental Use Cases**, starting from basic contact creation and gradually expanding to support editing, searching, sorting, file persistence, multithreading, and database integration.

The project emphasizes:

* Clean and maintainable architecture
* Modular project structure
* Progressive feature implementation
* Scalable system design

---

# 🧩 UC1 – Create Contact

## Description

UC1 introduces the **core Contact domain model** representing an individual entry in the Address Book.

It defines essential contact attributes including:

* First Name
* Last Name
* Address
* City
* State
* Zip Code
* Phone Number
* Email

This establishes the foundational data structure that future Address Book operations will manipulate.

---

## Purpose

* To define a structured representation of a contact within the Address Book system.
* To provide the base entity required for adding, editing, searching, and persisting contact information in later use cases.

---

## Implementation

* Implemented a `Contact` model class within the **model layer** of the application.
* Encapsulates contact fields with constructors and getter/setter methods.
* Added a basic REST controller to verify the Spring Boot application runs successfully.
* Establishes the foundational domain object used by future service and repository layers.

---

# 🧩 Upcoming Use Cases

The following features will be implemented progressively:

* **UC2 – Add Contact to Address Book**
* **UC3 – Edit Existing Contact**
* **UC4 – Delete Contact**
* **UC5 – Prevent Duplicate Entries**
* **UC6 – Multiple Address Books**
* **UC7 – Search Person by City or State**
* **UC8 – View Persons by City or State**
* **UC9 – Count Contacts by City or State**
* **UC10 – Sort Contacts Alphabetically**
* **UC11 – Sort Contacts by City, State, or Zip**
* **UC12 – Write Address Book to File**
* **UC13 – Read Address Book from File**
* **UC14 – Count Contacts in File**
* **UC15 – Write Contacts to CSV File**
* **UC16 – Read Contacts from CSV File**
* **UC17 – Write Contacts to JSON File**
* **UC18 – Read Contacts from JSON File**
* **UC19 – Add Contacts Using Threads**
* **UC20 – Measure Time for Threaded Contact Addition**
* **UC21 – Add Multiple Contacts Using Thread Pools**
* **UC22 – Measure Thread Pool Performance**
* **UC23 – Store Address Book in Database**
* **UC24 – Retrieve Contacts from Database**
* **UC25 – Update Contact in Database**

---

# 🧰 Tech Stack

* **Java 17** — Core programming language
* **Spring Boot** — Application framework and REST API development
* **Maven** — Build automation and dependency management
* **Git & GitHub** — Version control

---

# ▶️ Build / Run

Build the project:

```
./mvnw clean install
```

Run the application:

```
./mvnw spring-boot:run
```

Or run directly from the IDE using:

```
AddressBookAppApplication.java
```

Open the browser:

```
http://localhost:8080
```

Expected output:

```
Welcome to Address Book Application
```

---

# 📂 Project Structure

```
AddressBookApp
│
├── src
│   │
│   ├── main
│   │   │
│   │   ├── java
│   │   │   └── com.addressbook
│   │   │       │
│   │   │       ├── controller
│   │   │       │     AddressBookController.java
│   │   │       │
│   │   │       ├── model
│   │   │       │     Contact.java
│   │   │       │
│   │   │       └── AddressBookAppApplication.java
│   │   │
│   │   └── resources
│   │         application.properties
│   │
│   └── test
│
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

---

# ⚙️ Development Approach

This project follows an **incremental development workflow**:

* Each feature is introduced through a separate **Use Case**
* Development progresses step-by-step to maintain stability
* Architecture evolves gradually with additional layers such as **service, repository, and persistence**
* Future enhancements introduce **file storage, multithreading, and database integration**

---
