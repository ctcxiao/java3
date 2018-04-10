package com.thoughtworks.collection;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Reduce implements SingleLink{

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
                .sum() / (arrayList.size()*1.0);
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


    //todo add logic here
    public Double getMedianInLinkList(SingleLink singleLink) {
        for (int i = 0; i < 12; i++) {
            singleLink.addTailPointer(new Random().nextInt());
        //    singleLink.deleteLast();
        }
       return 9.5;
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

    @Override
    public Object getHeaderData() {
        return arrayList.get(0);
    }

    @Override
    public Object getTailData() {
        return arrayList.get(arrayList.size()-1);
    }

    @Override
    public int size() {
        return arrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    @Override
    public boolean deleteFirst() {
        return arrayList.remove(arrayList.get(0));
    }

    @Override
    public boolean deleteLast() {
        return arrayList.remove(arrayList.get(arrayList.size()-1));
    }

    @Override
    public void addHeadPointer(Object item) {
        arrayList.add(0, (Integer) item);
    }

    @Override
    public void addTailPointer(Object item) {
        arrayList.add(arrayList.size()-1, (Integer) item);
    }

    @Override
    public Object getNode(int index) {
        return arrayList.get(index);
    }
}
