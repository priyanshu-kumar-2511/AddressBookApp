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

    @GetMapping("/contacts")
    public List<Contact> getAllContacts() {

        return contactList;
    }
}