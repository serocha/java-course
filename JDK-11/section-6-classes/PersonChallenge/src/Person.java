public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        if (firstName.isEmpty()) {
            this.firstName = firstName;
        } else if (isFormattedString(firstName)) {
            this.firstName = firstName;
        } else {
            this.firstName = formattedString(firstName);
        }
    }

    public void setLastName(String lastName) {
        if (lastName.isEmpty()) {
            this.lastName = lastName;
        } else if (isFormattedString(lastName)) {
            this.lastName = lastName;
        } else {
            this.lastName = formattedString(lastName);
        }
    }

    public void setAge(int age) {
        if (age > 100 || age < 0) {
            age = 0;
        }
        this.age = age;
    }

    public boolean isTeen() {
        return (age > 12 && age < 20);
    }

    public String getFullName() {
        if (firstName.isEmpty() && lastName.isEmpty()) {
            return "";
        } else if (firstName.isEmpty()) {
            return lastName;
        } else  if (lastName.isEmpty()) {
            return firstName;
        }
        return firstName + " " + lastName;
    }

    private boolean isFormattedString(String string) {
        // string validator

        return string.equals(formattedString(string));
    }

    private String formattedString(String string) {
        // converts string to valid name format with leading uppercase, following lowercase
        return string.toLowerCase().replace(string.substring(0, 1),
                string.substring(0, 1).toUpperCase());
    }
}
