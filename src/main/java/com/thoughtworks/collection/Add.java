package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int sum = 0;
        if (leftBorder > rightBorder) {
            int tmp = leftBorder;
            leftBorder = rightBorder;
            rightBorder = tmp;
        }

        if (leftBorder % 2 == 0) {
            for (int i = leftBorder; i <= rightBorder; i += 2) {
                if (i % 2 == 0) {
                    sum += i;
                }
            }
        } else {
            for (int i = leftBorder + 1; i <= rightBorder; i += 2) {
                if (i % 2 == 0) {
                    sum += i;
                }
            }
        }
        return sum;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int sum = 0;
        if (leftBorder > rightBorder) {
            int tmp = leftBorder;
            leftBorder = rightBorder;
            rightBorder = tmp;
        }
        for (int i = leftBorder; i <= rightBorder; i++) {
            sum += i;
        }
        return sum - getSumOfEvens(leftBorder, rightBorder);
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        int sum = 0;
        for (int ele : arrayList) {
            sum += ele * 3 + 2;
        }
        return sum;
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        List<Integer> result = new ArrayList<>();
        arrayList.forEach(e -> {
            if (e % 2 == 0) {
                result.add(e);
            } else {
                result.add(e * 3 + 2);
            }
        });
        return result;
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().
                filter(e -> e % 2 != 0).
                reduce(0, (e1, e2) -> e1 + (e2 * 3 + 5));
    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        double median;
        List<Integer> list = arrayList.stream()
                .filter(e -> e % 2 == 0)
                .sorted()
                .collect(Collectors.toList());

        if (list.size() % 2 == 0) {
            median = (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2.0;
        } else {
            median = list.get(list.size() / 2);
        }
        return median;
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        int sum = arrayList.stream()
                .filter(e -> e % 2 == 0)
                .mapToInt(value -> value)
                .sum();
        return sum / arrayList.stream().filter(e -> e % 2 == 0).count();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList())
                .contains(specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(e -> e % 2 == 0)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> oddList = arrayList.stream()
                .filter(e -> e % 2 == 0)
                .sorted()
                .collect(Collectors.toList());

        List<Integer> evenList = arrayList.stream()
                .filter(e->e%2!=0)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        List<Integer> result =  new ArrayList<>();
        result.addAll(oddList);
        result.addAll(evenList);
        return result;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arrayList.size() - 1; i++) {
            result.add((arrayList.get(i) + arrayList.get(i + 1)) * 3);
        }
        return result;
    }
}
