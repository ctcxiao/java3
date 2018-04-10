package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Flaten {

    Integer[][] array;

    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        List<Integer> result = new ArrayList<>();
        Stream.of(array)
                .forEach(e -> result.addAll(Arrays.asList(e)));
        return result;
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        //todo see more about stream
        return transformToOneDimesional().stream()
            .distinct()
            .collect(Collectors.toList());
    }
}
