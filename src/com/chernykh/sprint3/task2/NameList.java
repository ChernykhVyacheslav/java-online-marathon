package com.chernykh.sprint3.task2;

public class NameList {

    private String[] names = {"Mike", "Emily", "Nick", "Patrick", "Sara"};

    public Iterator getIterator() {
        return new Iterator();
    }

    public class Iterator {

        private int counter;

        private Iterator() {
            this.counter = 0;
        }

        public boolean hasNext() {
            return counter < names.length;
        }

        public String next() {
            return names[counter++];
        }
    }

}
