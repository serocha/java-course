package com.udemy;

/*      A phone "contacts" app using console input
 *      Create, modify, delete, or search contacts
 *      Doesn't validate the case when two contacts share the same number
 *      Possible that there might be more edge cases
 */

public class Main {

    public static void main(String[] args) {
        MobilePhone phone = new MobilePhone();
        phone.openContacts();
    }
}
