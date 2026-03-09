package com.addressbook.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.addressbook.model.Contact;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    private List<Contact> contactList = new ArrayList<>();

    @GetMapping("/")
    public String addressBookApp() {
        return "Welcome to Address Book Application";
    }

    @PostMapping("/add")
    public String addContact(@RequestBody Contact contact) {

        contactList.add(contact);

        return "Contact added successfully";
    }
    
    // UC5 - Add Multiple Contacts
    
    @PostMapping("/addMultiple")
    public String addMultipleContacts(@RequestBody List<Contact> contacts) {
        contactList.addAll(contacts);
        return "Multiple contacts added successfully";
    }

    @GetMapping("/contacts")
    public List<Contact> getAllContacts() {

        return contactList;
    }
    
    // UC3 - Edit contact using first name
    
    @PutMapping("/edit/{firstName}")
    public String editContact(@PathVariable String firstName, @RequestBody Contact updatedContact) {

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
    
    // UC4 - Delete Contact using first name
    
    @DeleteMapping("/delete/{firstName}")
    public String deleteContact(@PathVariable String firstName) {

        for (Contact contact : contactList) {
            if (contact.getFirstName().equalsIgnoreCase(firstName)) {
                contactList.remove(contact);
                return "Contact deleted successfully";
            }
        }

        return "Contact not found";
    }
}