package com.chernykh.Sprint3.task5;

public enum ClientType {

    NEW(0) {
        @Override
        public double discount() {
            return ((100 - 0 * 0.35) / 100);
        }
    },
    SILVER(12) {
        @Override
        public double discount() {
            return ((100 - 12 * 0.35) / 100);
        }
    },
    GOLD(30) {
        @Override
        public double discount() {
            return ((100 - 30 * 0.35) / 100);
        }
    },
    PLATINUM(60) {
        @Override
        public double discount() {
            return ((100 - 60 * 0.35) / 100);
        }
    };

    private final int months;

    ClientType(int months) {
        this.months = months;
    }

    public double discount() {
        return 1.0;
    }
}
