package com.chernykh.sprint05.task4;

import java.util.Objects;
import java.util.StringJoiner;

public class Person {

    private static final String NAME_PATTERN = "^\\p{javaUpperCase}[\\p{javaLowerCase}\\s-]+$";
    private static final String CODE_PATTERN = "^\\d{10}$";

    private String firstName;
    private String lastName;
    private String idCode;

    public void setFirstName(String firstName) {
        checkValidity(firstName, NAME_PATTERN, new NameException("firstName", firstName));
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        checkValidity(lastName, NAME_PATTERN, new NameException("lastName", lastName));
        this.lastName = lastName;
    }

    public void setIdCode(String idCode) {
        checkValidity(idCode, CODE_PATTERN, new CodeException(idCode));
        this.idCode = idCode;
    }

    private static void checkValidity(String str, String pattern, RuntimeException e) {
        if (!str.matches(pattern)) {
            throw e;
        }
    }

    public static Person buildPerson(String firstName, String lastName, String idCode) {
        Person newPerson = new Person();
        StringJoiner errorMessage = new StringJoiner("; ");

        try {
            newPerson.setFirstName(firstName);
        } catch (NameException e) {
            errorMessage.add(e.getMessage());
        }

        try {
            newPerson.setLastName(lastName);
        } catch (NameException e) {
            errorMessage.add(e.getMessage());
        }

        try {
            newPerson.setIdCode(idCode);
        } catch (CodeException e) {
            errorMessage.add(e.getMessage());
        }

        if (errorMessage.length() > 0) {
            throw new IllegalArgumentException(errorMessage.toString());
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
