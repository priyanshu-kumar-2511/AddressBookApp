package com.addressbook.controller;

import java.util.*;

import org.springframework.web.bind.annotation.*;

import com.addressbook.model.Contact;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    // Map<AddressBookName , List<Contact>>
    private Map<String, List<Contact>> addressBooks = new HashMap<>();


    @GetMapping("/")
    public String addressBookApp() {
        return "Welcome to Address Book Application";
    }


    // UC6 - Create new Address Book
    @PostMapping("/create/{bookName}")
    public String createAddressBook(@PathVariable String bookName) {

        if (addressBooks.containsKey(bookName)) {
            return "Address Book already exists";
        }

        addressBooks.put(bookName, new ArrayList<>());
        return "Address Book created successfully";
    }


    // UC2 + UC7 - Add Contact with Duplicate Check
    @PostMapping("/{bookName}/add")
    public String addContact(@PathVariable String bookName, @RequestBody Contact contact) {

        List<Contact> contactList = addressBooks.get(bookName);

        if (contactList == null) {
            return "Address Book not found";
        }

        boolean duplicate = contactList.stream()
                .anyMatch(c -> c.getFirstName().equalsIgnoreCase(contact.getFirstName()));

        if (duplicate) {
            return "Duplicate contact found. Contact already exists.";
        }

        contactList.add(contact);
        return "Contact added successfully to " + bookName;
    }


    // UC5 - Add Multiple Contacts
    @PostMapping("/{bookName}/addMultiple")
    public String addMultipleContacts(@PathVariable String bookName, @RequestBody List<Contact> contacts) {

        List<Contact> contactList = addressBooks.get(bookName);

        if (contactList == null) {
            return "Address Book not found";
        }

        contactList.addAll(contacts);
        return "Multiple contacts added successfully to " + bookName;
    }


    // View contacts of specific Address Book
    @GetMapping("/{bookName}/contacts")
    public List<Contact> getAllContacts(@PathVariable String bookName) {

        List<Contact> contactList = addressBooks.get(bookName);

        if (contactList == null) {
            return new ArrayList<>();
        }

        return contactList;
    }


    // UC3 - Edit contact using first name
    @PutMapping("/{bookName}/edit/{firstName}")
    public String editContact(@PathVariable String bookName, @PathVariable String firstName, @RequestBody Contact updatedContact) {

        List<Contact> contactList = addressBooks.get(bookName);

        if (contactList == null) {
            return "Address Book not found";
        }

        for (Contact contact : contactList) {
            if (contact.getFirstName().equalsIgnoreCase(firstName)) {

                contact.setLastName(updatedContact.getLastName());
                contact.setAddress(updatedContact.getAddress());
                contact.setCity(updatedContact.getCity());
                contact.setState(updatedContact.getState());
                contact.setZip(updatedContact.getZip());
                contact.setPhoneNumber(updatedContact.getPhoneNumber());
                contact.setEmail(updatedContact.getEmail());

                return "Contact updated successfully";
            }
        }

        return "Contact not found";
    }


    // UC4 - Delete Contact
    @DeleteMapping("/{bookName}/delete/{firstName}")
    public String deleteContact(@PathVariable String bookName, @PathVariable String firstName) {

        List<Contact> contactList = addressBooks.get(bookName);

        if (contactList == null) {
            return "Address Book not found";
        }

        boolean removed = contactList.removeIf(
                c -> c.getFirstName().equalsIgnoreCase(firstName)
        );

        if (removed) {
            return "Contact deleted successfully";
        }

        return "Contact not found";
    }


    // UC8 - Search by City across all Address Books
    @GetMapping("/search/city/{city}")
    public List<Contact> searchByCity(@PathVariable String city) {

        return addressBooks.values()
                .stream()
                .flatMap(List::stream)
                .filter(contact -> contact.getCity().equalsIgnoreCase(city))
                .toList();
    }


    // UC8 - Search by State across all Address Books
    @GetMapping("/search/state/{state}")
    public List<Contact> searchByState(@PathVariable String state) {

        return addressBooks.values()
                .stream()
                .flatMap(List::stream)
                .filter(contact -> contact.getState().equalsIgnoreCase(state))
                .toList();
    }
}