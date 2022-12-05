package com.udemy;

public class Contact {

    private final String[] contact = new String[2];

    public Contact(String name, String phoneNumber) {
        contact[0] = name;
        contact[1] = formatPhoneNumber(phoneNumber);
    }

    protected String getName() {
        return contact[0];
    }

    protected void setName(String name) {
        contact[0] = name;
    }

    protected String getPhoneNumber() {
        return contact[1];
    }

    protected void setPhoneNumber(String phoneNumber) {
        contact[1] = formatPhoneNumber(phoneNumber);
    }

    private String formatPhoneNumber(String phoneNumber) {
        if (phoneNumber.matches("\\(\\d{3}\\) \\d{3}-\\d{4}")) {
            return phoneNumber;
        } else {
            return phoneNumber.replaceFirst("(\\d{3})(\\d{3})(\\d{4})", "($1) $2-$3");
        }
    }
}