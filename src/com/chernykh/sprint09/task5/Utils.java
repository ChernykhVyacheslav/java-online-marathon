package com.chernykh.sprint09.task5;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utils {

    public Stream<String> nameList(Map<String, Stream<String>> map) {
        if(map == null) {
            throw new NullPointerException();
        }
        Set<String> stringSet = new HashSet<>();
        for (String key:
             map.keySet()) {
            Stream<String> stringStream = map.get(key);
            if(stringStream != null) {
                stringSet.addAll(stringStream
                        .filter(s -> s != null && !s.trim().equals(""))
                        .map(s -> s.replaceAll("\\s", "").toLowerCase())
                        .collect(Collectors.toSet()));
            }
        }
        return stringSet.stream()
                .map(s -> s.substring(0, 1).toUpperCase()
                        + s.substring(1)).sorted();
    }

    public Stream<String> nameList2(Map<String, Stream<String>> map) {
        if(map.isEmpty()) {
            throw new NullPointerException();
        }
        return map.values()
                .stream()
                .flatMap(Function.identity())
                .filter(Objects::nonNull)
                .filter(s -> !s.isEmpty())
                .map(s -> s.replaceAll("\\s", ""))
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase())
                .distinct()
                .sorted();
    }
}
