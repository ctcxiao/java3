package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream()
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt();
    }

    public double getMinimum() {
        return arrayList.stream()
                .mapToInt(Integer::intValue)
                .min()
                .getAsInt();
    }

    public double getAverage() {
        return arrayList.stream()
                .mapToInt(Integer::intValue)
                .sum() / arrayList.size();
    }

    public double getOrderedMedian() {
        double median;
        List<Integer> list = arrayList.stream()
                .sorted()
                .collect(Collectors.toList());

        if (list.size() % 2 == 0) {
            median = (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2.0;
        } else {
            median = list.get(list.size() / 2);
        }
        return median;
    }

    public int getFirstEven() {
        return arrayList.stream()
                .filter(e -> e % 2 == 0)
                .findFirst()
                .get();
    }

    public int getIndexOfFirstEven() {
        return arrayList.indexOf(arrayList.stream()
                .filter(e -> e % 2 == 0)
                .findFirst()
                .get());
    }

    public boolean isEqual(List<Integer> arrList) {
        List<Integer> list = arrayList.stream()
                .filter(arrList::contains)
                .collect(Collectors.toList());
        if (list.size() == arrayList.size()){
            return true;
        }
        return false;
    }

    //实现接口SingleLink，然后再此函数内使用
    public Double getMedianInLinkList(SingleLink singleLink) {
        throw new NotImplementedException();
    }

    public int getLastOdd() {
        List<Integer> oddList = arrayList.stream()
                .filter(e -> e % 2 != 0)
                .collect(Collectors.toList());
        return oddList.get(oddList.size() - 1);
    }

    public int getIndexOfLastOdd() {
        List<Integer> oddList = arrayList.stream()
                .filter(e -> e % 2 != 0)
                .collect(Collectors.toList());
        return arrayList.indexOf(oddList.get(oddList.size() - 1));
    }
}
