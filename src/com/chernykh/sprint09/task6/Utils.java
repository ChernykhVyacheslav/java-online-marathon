package com.chernykh.sprint09.task6;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utils {

    private static final String LOCAL_CODE = "loc";
    private static final String ERROR_CODE = "err";
    private static final int LENGTH_WITHOUT_CODE = 7;

    public Map<String, Stream<String>> phoneNumbers(List<Stream<String>> list) {
        Map<String, Stream<String>> phoneNumbers = new HashMap<>();
        for (Stream<String> currentStream :
                list) {
            if (currentStream != null) {
                currentStream
                        .filter(Objects::nonNull)
                        .map(s -> s.replaceAll("[\\s\\D()-]", ""))
                        .filter(s -> !s.isEmpty())
                        .forEach(s -> {
                            int networkCodeIndex = 0;
                            String mobileNetworkCode;

                            if (s.length() > LENGTH_WITHOUT_CODE) {
                                networkCodeIndex = s.length() - LENGTH_WITHOUT_CODE;
                                mobileNetworkCode = s.substring(0, networkCodeIndex);
                            } else if (s.length() == LENGTH_WITHOUT_CODE) {
                                mobileNetworkCode = LOCAL_CODE;
                            } else {
                                mobileNetworkCode = ERROR_CODE;
                            }

                            if (phoneNumbers.containsKey(mobileNetworkCode)) {
                                phoneNumbers.put(mobileNetworkCode,
                                        Stream.concat(
                                                phoneNumbers.get(mobileNetworkCode),
                                                Stream.of(s.substring(networkCodeIndex)))
                                                .distinct().sorted());
                            } else {
                                phoneNumbers.put(mobileNetworkCode,
                                        Stream.of(s.substring(networkCodeIndex)));
                            }
                        });
            }
        }
        return phoneNumbers;
    }
}
