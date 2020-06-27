package com.chernykh.Sprint5.task4;

import java.util.Objects;

public class Person {

    private String firstName;
    private String lastName;
    private String idCode;

    private static final String NAME_PATTERN = "^\\p{javaUpperCase}[\\p{javaLowerCase}\\s-]+$";
    private static final String CODE_PATTERN = "^\\d{10}$";

    public void setFirstName(String firstName) {
        checkValidity(firstName, NAME_PATTERN, new NameException("Incorrect value " + firstName + " for firstName " +
                "(should start from upper case and contains only alphabetic characters and symbols -, _)"));
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        checkValidity(lastName, NAME_PATTERN, new NameException("Incorrect value " + lastName + " for lastName " +
                "(should start from upper case and contains only alphabetic characters and symbols -, _)"));
        this.lastName = lastName;
    }

    public void setIdCode(String idCode) {
        checkValidity(idCode, CODE_PATTERN, new CodeException("Incorrect value " + idCode +
                " for code (should contains exactly 10 digits)"));
        this.idCode = idCode;
    }

    private static void checkValidity(String str, String pattern, RuntimeException e) {
        if(!str.matches(pattern)) {
            throw e;
        }
    }

    public static Person buildPerson(String firstName, String lastName, String idCode) {
        Person newPerson = new Person();
        String errorMessage = "";

        try {
            newPerson.setFirstName(firstName);
        } catch (NameException e) {
            errorMessage += "; " + e.getMessage();
        }

        try {
            newPerson.setLastName(lastName);
        } catch (NameException e) {
            errorMessage += "; " + e.getMessage();
        }

        try {
            newPerson.setIdCode(idCode);
        } catch (CodeException e) {
            errorMessage += "; " + e.getMessage();
        }

        if(!errorMessage.isEmpty()) {
            throw new IllegalArgumentException(errorMessage.substring(2));
        }

        return newPerson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(idCode, person.idCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, idCode);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ": " + idCode;
    }
}
