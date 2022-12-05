package com.udemy;

public class MobilePhone {
    Contacts contactsApp;
    public MobilePhone() {
        this.contactsApp = new Contacts();
    }

    protected void openContacts() {
        contactsApp.run();
    }
}
