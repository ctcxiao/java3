package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        List<Integer> result = new ArrayList<>();
        //todo duplicated code, can be refactored
        if (left > right) {
            for (int i = left; i >= right; i--) {
                result.add(i);
            }
            return result;
        } else {
            for (int i = left; i <= right; i++) {
                result.add(i);
            }
            return result;
        }
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        return getListByInterval(left, right)
                .stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array)
                .boxed()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return Arrays.stream(array)
                .boxed()
                .collect(Collectors.toList())
                .get(array.length - 1);
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        return Arrays.stream(firstArray)
                .boxed()
                .filter(Arrays.stream(secondArray).boxed().collect(Collectors.toList())::contains)
                .collect(Collectors.toList());
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> result = new ArrayList<>(Arrays.asList(firstArray));
        Arrays.stream(secondArray)
                .filter(e -> !Arrays.stream(firstArray).collect(Collectors.toList()).contains(e))
                .forEach(result::add);
        return result;
    }
}
