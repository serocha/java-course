package com.udemy;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact) < 0) {
            myContacts.add(contact);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        if (findContact(oldContact) == -1) {
            return false;
        }
        myContacts.add(findContact(oldContact), newContact);
        return true;
    }

    public boolean removeContact(Contact contact) {
        if (findContact(contact) == -1) {
            return false;
        }
        myContacts.remove(contact);
        return true;
    }

    private int findContact(Contact contact) {
        return findContact(contact.getName());
    }

    private int findContact(String name) {
        for(Contact contact : myContacts) {
            if(contact.getName().equals(name)) {
                return myContacts.indexOf(contact);
            }
        }
        return -1;
    }

    public Contact queryContact(String contactStr) {
        return findContact(contactStr) < 0 ? null : myContacts.get(findContact(contactStr));
    }

    public void printContacts() {
        System.out.println("Contact List:");
        for (Contact contact : myContacts) {
            System.out.println((myContacts.indexOf(contact) + 1) + ". " + contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }
}