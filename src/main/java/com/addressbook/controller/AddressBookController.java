package com.addressbook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressBookController {

    @GetMapping("/")
    public String addressBookApp() {
        return "Welcome to Address Book Application";
    }

}