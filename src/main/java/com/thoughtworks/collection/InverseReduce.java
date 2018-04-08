package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {}

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {
        List<Integer> result = new ArrayList<>();
        while (true){
            int randomInt = random.nextInt(3);
            if (number - randomInt >= 0) {
                result.add(number - randomInt);
            } else {
                break;
            }
            number = number - randomInt;
        }
        return result;
    }
}
