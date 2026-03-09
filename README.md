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

# 🧩 UC2 – Add Contact to Address Book

## Description

UC2 introduces the functionality to **add a new contact to the Address Book** using a REST API.

The system accepts contact details in **JSON format**, converts them into a `Contact` object, and stores them in an in-memory list.

This enables the application to begin managing Address Book entries dynamically.

---

## Purpose

* To allow users to **add contacts to the Address Book**.
* To expose a **REST endpoint** for creating new contact entries.
* To store contact information temporarily using an in-memory data structure.

---

## Implementation

* Implemented a **POST API** to add new contacts.
* Implemented a **GET API** to retrieve all stored contacts.
* Used `@RequestBody` to map incoming JSON data to the `Contact` model.
* Contacts are stored in an **ArrayList inside the controller**.

---

## APIs Implemented

### Add Contact

```
POST /addressbook/add
```

Example Request Body

```json id="uc2_json"
{
  "id": 1,
  "firstName": "Priyanshu",
  "lastName": "Kumar",
  "address": "Kanpur",
  "city": "Kanpur",
  "state": "UP",
  "zip": "208001",
  "phoneNumber": "9876543210",
  "email": "priyanshu@gmail.com"
}
```

Response

```
Contact added successfully
```

---

### Get All Contacts

```
GET /addressbook/contacts
```

Example Response

```json id="uc2_response"
[
 {
  "id": 1,
  "firstName": "Priyanshu",
  "lastName": "Kumar",
  "address": "Kanpur",
  "city": "Kanpur",
  "state": "UP",
  "zip": "208001",
  "phoneNumber": "9876543210",
  "email": "priyanshu@gmail.com"
 }
]
```
# 🧩 UC3 – Edit Existing Contact

## Description

UC3 introduces the ability to **edit an existing contact in the Address Book using their name**.

This feature allows users to update contact information such as address, city, state, phone number, and email after the contact has already been added.

The system searches for the contact using the **first name** and updates the corresponding fields with the new values provided.

---

## Purpose

* To allow modification of contact details already stored in the Address Book.
* To provide an API endpoint for updating contact information.
* To ensure that users can maintain accurate and up-to-date contact records.

---

## Implementation

* Implemented a **PUT API** to update an existing contact.
* The application searches the contact list using the **first name**.
* If a matching contact is found, the existing fields are updated with the new values provided in the request body.
* If the contact is not found, the system returns a **Contact not found** message.

Contacts are still stored **in memory using an ArrayList**.

---

## API Implemented

### Edit Contact

```
PUT /addressbook/edit/{firstName}
```

Example Request

```
PUT http://localhost:8080/addressbook/edit/Priyanshu
```

Request Body

```json
{
 "id": 1,
 "firstName": "Priyanshu",
 "lastName": "Kumar",
 "address": "Bhopal",
 "city": "Bhopal",
 "state": "Madhya Pradesh",
 "zip": "462022",
 "phoneNumber": "6207394439",
 "email": "priyanshu@gmail.com"
}
```

Response

```
Contact updated successfully
```

---

## Verification

To verify the updated contact, use the GET API:

```
GET /addressbook/contacts
```

Example terminal command:

```
curl http://localhost:8080/addressbook/contacts
```

The response will display the updated contact information.

---

## Outcome

With UC3 implemented, the Address Book application now supports:

* Creating contact records
* Storing contacts in memory
* Editing existing contact details

This prepares the system for the next feature: **UC4 – Delete Contact**.

# 🧩 UC4 – Delete Contact

## Description

UC4 introduces the ability to **delete an existing contact from the Address Book using the person's name**.

This feature allows users to remove a contact record that is no longer required.

The system searches the stored contact list using the **first name** and removes the corresponding contact if it exists.

---

## Purpose

* To allow users to **remove contacts from the Address Book**.
* To provide an API endpoint for deleting existing contact records.
* To maintain accurate and updated contact information.

---

## Implementation

* Implemented a **DELETE API** to remove a contact.
* The application searches the contact list using the **first name**.
* If a matching contact is found, it is removed from the list.
* If the contact does not exist, the system returns **Contact not found**.

Contacts are still stored **in memory using an ArrayList**.

---

# 🌐 API Implemented

### Delete Contact

```id="uc4_api"
DELETE /addressbook/delete/{firstName}
```

Example Request

```id="uc4_url"
http://localhost:8080/addressbook/delete/Sakshi
```

Expected Response

```id="uc4_response"
Contact deleted successfully
```

---

# 🧪 Testing Using Terminal (curl)

The API was tested using the **curl command from the terminal**.

```id="curl_delete"
curl -X DELETE http://localhost:8080/addressbook/delete/Sakshi
```

Response

```id="curl_delete_response"
Contact deleted successfully
```

---

# Verification

To confirm the contact has been removed:

```id="verify_delete"
GET /addressbook/contacts
```

Terminal command:

```id="verify_delete_curl"
curl http://localhost:8080/addressbook/contacts
```

The deleted contact will **no longer appear in the contact list**.

---

# Outcome

With UC4 implemented, the Address Book application now supports:

* Adding contacts
* Viewing contacts
* Editing contacts
* Deleting contacts

All operations currently use **in-memory storage (ArrayList)**.

---

# 🧩 UC5 – Add Multiple Contacts to Address Book

## Description

UC5 introduces the ability to **add multiple contacts to the Address Book** and manage them using a **Collection class**.

The application now supports storing several contact records simultaneously. Each contact is represented as a `Contact` object and stored in an in-memory **ArrayList**.

Users can add contacts **one by one** or **multiple contacts at once** through REST APIs.

---

## Purpose

* To store and manage **multiple contact entries** in the Address Book.
* To utilize Java **Collection classes** for handling multiple records.
* To provide an API that allows adding **multiple contacts in a single request**.

---

## Implementation

* Used **ArrayList<Contact>** to store multiple contacts.
* Implemented an API that accepts a **list of Contact objects**.
* The application processes the list and stores all contacts in the Address Book collection.

Contacts are still stored **in memory**.

---

# 🌐 API Implemented

### Add Multiple Contacts

```id="uc5_api"
POST /addressbook/addMultiple
```

Example Request

```id="uc5_url"
http://localhost:8080/addressbook/addMultiple
```

---

# 🧪 Testing Using Terminal (curl)

The API was tested using the **curl command from the terminal**.

```id="curl_uc5"
curl -X POST http://localhost:8080/addressbook/addMultiple -H "Content-Type: application/json" -d "[{\"id\":2,\"firstName\":\"Rahul\",\"lastName\":\"Sharma\",\"address\":\"Delhi\",\"city\":\"Delhi\",\"state\":\"Delhi\",\"zip\":\"110001\",\"phoneNumber\":\"9999999999\",\"email\":\"rahul@gmail.com\"},{\"id\":3,\"firstName\":\"Anita\",\"lastName\":\"Verma\",\"address\":\"Lucknow\",\"city\":\"Lucknow\",\"state\":\"UP\",\"zip\":\"226001\",\"phoneNumber\":\"8888888888\",\"email\":\"anita@gmail.com\"}]"
```

Response

```id="uc5_response"
Multiple contacts added successfully
```

---

# Verification

To verify that the contacts have been stored:

```id="verify_uc5"
GET /addressbook/contacts
```

Terminal command:

```id="verify_uc5_curl"
curl http://localhost:8080/addressbook/contacts
```

This will return all contacts currently stored in the Address Book.

---

# Outcome

With UC5 implemented, the Address Book application now supports:

* Adding contacts
* Adding multiple contacts
* Viewing contacts
* Editing contacts
* Deleting contacts

All contacts are currently stored using a **Java Collection (ArrayList)**.

---

# 🧩 UC6 – Multiple Address Books

## Description

UC6 introduces the ability to **maintain multiple Address Books within the system**.

Each Address Book is identified by a **unique name**, and each Address Book can contain multiple contacts.

This refactor extends the system from managing a single Address Book to managing **multiple collections of contacts**, allowing users to organize contacts into categories such as **Friends, Family, or Office**.

---

## Purpose

* To allow the system to manage **multiple Address Books**.
* To uniquely identify each Address Book using a **name**.
* To organize contacts into separate groups.
* To improve scalability of the Address Book system.

---

## Implementation

* Refactored the application to use a **Dictionary structure (`Map<String, List<Contact>>`)**.
* The **key** represents the Address Book name.
* The **value** represents the list of contacts belonging to that Address Book.

Example structure:

```
Friends  → [Contact1, Contact2]
Family   → [Contact3, Contact4]
Office   → [Contact5]
```

This allows the system to maintain **multiple independent Address Books**.

---

# 🌐 APIs Implemented

### Create Address Book

```
POST /addressbook/create/{bookName}
```

Example

```
POST /addressbook/create/Friends
```

Response

```
Address Book created successfully
```

---

### Add Contact to Address Book

```
POST /addressbook/{bookName}/add
```

Example

```
POST /addressbook/Friends/add
```

---

### Add Multiple Contacts

```
POST /addressbook/{bookName}/addMultiple
```

---

### View Contacts of Address Book

```
GET /addressbook/{bookName}/contacts
```

Example

```
GET /addressbook/Friends/contacts
```

---

### Edit Contact

```
PUT /addressbook/{bookName}/edit/{firstName}
```

---

### Delete Contact

```
DELETE /addressbook/{bookName}/delete/{firstName}
```

---

# 🧪 Testing Using Terminal (curl)

Create Address Book

```
curl -X POST http://localhost:8080/addressbook/create/Friends
```

Add Contact

```
curl -X POST http://localhost:8080/addressbook/Friends/add -H "Content-Type: application/json" -d "{\"id\":1,\"firstName\":\"Rahul\",\"lastName\":\"Sharma\"}"
```

View Contacts

```
curl http://localhost:8080/addressbook/Friends/contacts
```

---

# Outcome

With UC6 implemented, the Address Book application now supports:

* Multiple Address Books
* Adding contacts to specific Address Books
* Adding multiple contacts
* Viewing contacts by Address Book
* Editing contacts
* Deleting contacts

The system now uses a **Dictionary (Map) structure** to manage multiple Address Books efficiently.

---

# 🧩 UC7 – Prevent Duplicate Contact Entries

## Description

UC7 introduces the ability to **prevent duplicate entries of the same person in an Address Book**.

When a new contact is added to an Address Book, the system checks whether a contact with the **same name already exists** in that Address Book.

If a duplicate contact is detected, the system **rejects the request** and prevents the duplicate entry from being stored.

---

## Purpose

* To maintain **data consistency** in the Address Book.
* To ensure that the same person is not added multiple times in a single Address Book.
* To enforce **duplicate validation while adding contacts**.

---

## Implementation

* Implemented duplicate validation while adding a contact.
* Used **Java Streams** to search the collection for an existing contact.
* The system compares contacts based on **first name**.
* If a matching contact already exists, the contact is **not added**.

Example duplicate check logic:

```java id="uc7_stream_logic"
boolean duplicate = contactList.stream()
        .anyMatch(c -> c.getFirstName().equalsIgnoreCase(contact.getFirstName()));
```

If `duplicate == true`, the system returns:

```text id="duplicate_response"
Duplicate contact found. Contact already exists.
```

---

# 🌐 API Used

### Add Contact

```text id="uc7_api"
POST /addressbook/{bookName}/add
```

Example

```text id="uc7_url"
POST /addressbook/Friends/add
```

---

# 🧪 Testing Using Terminal (curl)

Add a contact:

```id="uc7_curl_add"
curl -X POST http://localhost:8080/addressbook/Friends/add -H "Content-Type: application/json" -d "{\"id\":1,\"firstName\":\"Rahul\",\"lastName\":\"Sharma\"}"
```

Response

```id="uc7_success"
Contact added successfully to Friends
```

---

### Attempt Duplicate Entry

```id="uc7_duplicate_test"
curl -X POST http://localhost:8080/addressbook/Friends/add -H "Content-Type: application/json" -d "{\"id\":2,\"firstName\":\"Rahul\",\"lastName\":\"Sharma\"}"
```

Response

```id="uc7_duplicate_response"
Duplicate contact found. Contact already exists.
```

---

# Outcome

With UC7 implemented, the Address Book application now supports:

* Creating contacts
* Adding contacts
* Adding multiple contacts
* Managing multiple Address Books
* Editing contacts
* Deleting contacts
* **Preventing duplicate contact entries**

Duplicate validation ensures that the Address Book maintains **unique contact records within each Address Book**.

---

# 🧩 UC8 – Search Person by City or State

## Description

UC8 introduces the ability to **search for contacts by city or state across multiple Address Books**.

The system scans all Address Books and returns a list of contacts whose **city or state matches the search criteria**. The search result may include **multiple contacts from different Address Books**.

---

## Purpose

* To allow users to **search contacts across all Address Books**.
* To retrieve contacts belonging to a specific **city or state**.
* To efficiently filter contacts using **Java Streams**.

---

## Implementation

* Implemented search functionality across all Address Books.
* Used **Java Streams** to flatten and filter contacts stored in the `Map<String, List<Contact>>`.
* The search operation iterates through all Address Books and returns matching contacts.

Example logic:

```java id="uc8_stream_example"
addressBooks.values()
        .stream()
        .flatMap(List::stream)
        .filter(contact -> contact.getCity().equalsIgnoreCase(city))
        .toList();
```

This stream:

1. Retrieves all Address Book contact lists
2. Flattens them into a single stream of contacts
3. Filters contacts by city or state
4. Returns the matching contacts

---

# 🌐 APIs Implemented

### Search by City

```id="uc8_api_city"
GET /addressbook/search/city/{city}
```

Example

```id="uc8_example_city"
GET /addressbook/search/city/Delhi
```

---

### Search by State

```id="uc8_api_state"
GET /addressbook/search/state/{state}
```

Example

```id="uc8_example_state"
GET /addressbook/search/state/UP
```

---

# 🧪 Testing Using Terminal (curl)

Search by city:

```id="uc8_curl_city"
curl http://localhost:8080/addressbook/search/city/Delhi
```

Search by state:

```id="uc8_curl_state"
curl http://localhost:8080/addressbook/search/state/UP
```

Example Response

```json id="uc8_response"
[
 {
  "id": 1,
  "firstName": "Rahul",
  "lastName": "Sharma",
  "city": "Delhi",
  "state": "Delhi"
 },
 {
  "id": 3,
  "firstName": "Sakshi",
  "lastName": "Kumari",
  "city": "Delhi",
  "state": "Delhi"
 }
]
```

---

# Outcome

With UC8 implemented, the Address Book application now supports:

* Creating contacts
* Adding contacts
* Adding multiple contacts
* Managing multiple Address Books
* Editing contacts
* Deleting contacts
* Preventing duplicate entries
* **Searching contacts by city or state across multiple Address Books**

---

# 🧩 Upcoming Use Cases

The following features will be implemented progressively:

* **UC9 – View Persons by City or State**
* **UC10 – Count Contacts by City or State**
* **UC11 – Sort Contacts Alphabetically**
* **UC12 – Sort Contacts by City, State, or Zip**
* **UC13 – Write Address Book to File**
* **UC14 – Read Address Book from File**
* **UC15 – Count Contacts in File**
* **UC16 – Write Contacts to CSV File**
* **UC17 – Read Contacts from CSV File**
* **UC18 – Write Contacts to JSON File**
* **UC19 – Read Contacts from JSON File**
* **UC20 – Add Contacts Using Threads**
* **UC21 – Measure Time for Threaded Contact Addition**
* **UC22 – Add Multiple Contacts Using Thread Pools**
* **UC23 – Measure Thread Pool Performance**
* **UC24 – Store Address Book in Database**
* **UC25 – Retrieve Contacts from Database**

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
