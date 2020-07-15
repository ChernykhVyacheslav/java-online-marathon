package com.chernykh.sprint09.task6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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

    public Map<String, Stream<String>> phoneNumbers2(List<Stream<String>> list) {
        return list.stream()
                .flatMap(o -> o)
                .distinct()
                .filter(o -> o != null && !o.isEmpty())
                .map(o -> o.replaceAll("\\D", ""))
                .sorted()
                .collect(Collectors.groupingBy(
                        o -> o.length() == 7 ? "loc" : (o.length() < 7 ? "err" : o.substring(0, 3)),
                        Collectors.mapping(o -> o.length() <= 7 ? o : o.substring(3), Collectors.toList())))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, t -> t.getValue().stream()));
    }

    public Map<String, Stream<String>> phoneNumbers3(List<Stream<String>> list) {
        return list.stream()
                .flatMap(s -> s)
                .filter(s -> s != null && !s.isEmpty())
                .map(s -> s.replaceAll("\\D", ""))
                .filter(s -> !s.isEmpty())
                .map(s -> s.length() == 7 ? "loc" : (s.length() < 7 ? "err" : s.substring(0, 3)))
                .distinct()
                .sorted()
                .collect(Collectors.toMap(
                        s -> s.substring(0, 3),
                        s -> Stream.of(s.substring(3)),
                        Stream::concat));
    }
}
