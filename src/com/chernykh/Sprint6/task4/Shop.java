package com.chernykh.Sprint6.task4;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    public List<DecisionMethod> clients = new ArrayList<>();

    public int sale(String product, int percent) {
        int count = 0;
        for (DecisionMethod decisionMethod :
                clients) {
            if (decisionMethod.decide(product, percent)) {
                count++;
            }
        }
        return count;
    }

}
