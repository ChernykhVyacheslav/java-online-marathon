package com.chernykh.Sprint4.task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyUtils {

    public Map<String, List<String>> createNotebook(Map<String, String> phones) {
        Map<String, List<String>> notebook = new HashMap<>();
        for (Map.Entry<String, String> entry :
                phones.entrySet()) {
            String contactName = entry.getValue();
            if (!notebook.containsKey(contactName)) {
                notebook.put(contactName, new ArrayList<>());
            }
            notebook.get(contactName).add(entry.getKey());
        }
        return notebook;
    }

}
