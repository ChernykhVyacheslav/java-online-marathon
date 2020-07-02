package com.chernykh.sprint3.task5;

public enum ClientType {

    NEW(0) {
        @Override
        public double discount() {
            return ((100 - NEW.months * 0.35) / 100);
        }
    },
    SILVER(12) {
        @Override
        public double discount() {
            return ((100 - SILVER.months * 0.35) / 100);
        }
    },
    GOLD(30) {
        @Override
        public double discount() {
            return ((100 - GOLD.months * 0.35) / 100);
        }
    },
    PLATINUM(60) {
        @Override
        public double discount() {
            return ((100 - PLATINUM.months * 0.35) / 100);
        }
    };

    private final int months;

    ClientType(int months) {
        this.months = months;
    }

    public abstract double discount();
}
