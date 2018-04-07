package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
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
                .forEach(e -> {
                    result.addAll(Arrays.asList(e));
                });
        return result;
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        List<Integer> result = new ArrayList<>();
        Stream.of(array)
                .forEach(e -> {
                    for (int ele : e) {
                        if (!result.contains(ele)) {
                            result.add(ele);
                        }
                    }
                });
        return result;
    }
}
