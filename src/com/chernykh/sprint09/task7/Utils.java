package com.chernykh.sprint09.task7;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utils {

    public Stream<Integer> duplicateElements(Stream<Integer> stream) {
        List<Integer> arrList = stream.collect(Collectors.toList());
        return arrList.stream().filter(Objects::nonNull).filter(elem ->
                Collections.frequency(arrList, elem) > 1).distinct().sorted();
    }

    public Stream<Integer> duplicateElements2(Stream<Integer> stream) {
        return stream
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(m -> m.getValue() > 1)
                .map(Map.Entry::getKey)
                .sorted();
    }
}
