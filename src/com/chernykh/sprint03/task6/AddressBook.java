package com.chernykh.sprint03.task6;

import java.util.*;

public class AddressBook implements Iterable<String> {

    private static final int DEFAULT_LENGTH = 10;

    private NameAddressPair[] addressBook;
    private int counter;

    public AddressBook(int capacity) {
        if (capacity <= 0) {
            this.addressBook = new NameAddressPair[DEFAULT_LENGTH];
        } else {
            this.addressBook = new NameAddressPair[capacity];
        }
        this.counter = 0;
    }

    public int getCounter() {
        return counter;
    }

    public boolean create(String firstName, String lastName, String address) {
        try {
            if (counter == addressBook.length) {
                addressBook = growArray();
            }
            if (read(firstName, lastName) == null) {
                NameAddressPair newAddress = new NameAddressPair(
                        new NameAddressPair.Person(firstName, lastName),
                        address);
                addressBook[counter] = newAddress;
                counter++;
                return true;
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return false;
    }

    private NameAddressPair[] growArray() {
        return Arrays.copyOf(addressBook, addressBook.length * 2);
    }

    public String read(String firstName, String lastName) {
        int readIndex = findIndex(firstName, lastName);

        if (readIndex == -1) {
            return null;
        }

        return addressBook[readIndex].address;
    }

    public boolean update(String firstName, String lastName, String address) {
        int updateIndex = findIndex(firstName, lastName);

        if (updateIndex == -1) {
            return false;
        }

        addressBook[updateIndex].address = address;
        return true;
    }

    public boolean delete(String firstName, String lastName) {
        int deleteIndex = findIndex(firstName, lastName);

        if (deleteIndex == -1) {
            return false;
        }

        addressBook = deleteByIndex(deleteIndex);
        return true;
    }

    private NameAddressPair[] deleteByIndex(int index) {
        NameAddressPair[] newAddressBook = new NameAddressPair[addressBook.length];

        for (int i = 0, j = 0; i + j < counter; i++) {
            if (i == index) {
                j++;
            }
            newAddressBook[i] = addressBook[i + j];
        }

        counter--;

        return newAddressBook;
    }

    private int findIndex(String firstName, String lastName) {
        for (int i = 0; i < counter; i++) {
            NameAddressPair nameAddressPair = addressBook[i];
            if (nameAddressPair.person.firstName.equals(firstName)
                    && nameAddressPair.person.lastName.equals(lastName)) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return counter;
    }

    public void sortedBy(SortOrder sortOrder) {
        switch (sortOrder) {
            case DESC:
                Arrays.sort(addressBook, (firstNameAddressPair, secondNameAddressPair) -> {
                    if (!firstNameAddressPair.person.firstName.equals(secondNameAddressPair.person.firstName)) {
                        return secondNameAddressPair.person.firstName.compareTo(firstNameAddressPair.person.firstName);
                    }
                    return secondNameAddressPair.person.lastName.compareTo(firstNameAddressPair.person.lastName);
                });
                break;
            case ASC:
            default:
                Arrays.sort(addressBook, (firstNameAddressPair, secondNameAddressPair) -> {
                    if (!firstNameAddressPair.person.firstName.equals(secondNameAddressPair.person.firstName)) {
                        return firstNameAddressPair.person.firstName.compareTo(secondNameAddressPair.person.firstName);
                    }
                    return firstNameAddressPair.person.lastName.compareTo(secondNameAddressPair.person.lastName);
                });
                break;
        }
    }

    @Override
    public Iterator iterator() {
        return new AddressBookIterator();
    }

    private static class NameAddressPair {

        private final Person person;
        private String address;

        private NameAddressPair(Person person, String address) {
            this.person = person;
            this.address = address;
        }

        @Override
        public String toString() {
            return String.format("%s => %s", person, address);
        }

        private static class Person {

            private final String firstName;
            private final String lastName;

            private Person(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Person person = (Person) o;
                return firstName.equals(person.firstName) &&
                        lastName.equals(person.lastName);
            }

            @Override
            public int hashCode() {
                return Objects.hash(firstName, lastName);
            }

            @Override
            public String toString() {
                return String.format("(%s, %s)", firstName, lastName);
            }
        }
    }


    private class AddressBookIterator implements Iterator<String> {
        private int counter;

        private AddressBookIterator() {
            this.counter = 0;
        }

        @Override
        public boolean hasNext() {
            return counter < getCounter();
        }

        @Override
        public String next() {
            if (hasNext()) {
                counter++;
            } else {
                throw new NoSuchElementException();
            }
            return getString(addressBook[counter - 1]);
        }

        private String getString(NameAddressPair nameAddressPair) {
            return String.format("First name: %s, Last name: %s, Address: %s",
                    nameAddressPair.person.firstName,
                    nameAddressPair.person.lastName,
                    nameAddressPair.address);
        }
    }


}

enum SortOrder {
    ASC,
    DESC
}