package com.thoughtworks.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return array.stream()
                .map(e -> e * 3)
                .collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        return array.stream()
                .map(e -> String.valueOf((char) (String.valueOf(e).codePointAt(0) + 48)))
                .collect(Collectors.toList());
    }

    //todo abstract to method
    public List<String> mapLetters() {
        return array.stream()
                .map(this::getLetterMethod).collect(Collectors.toList());
    }

    private String getLetterMethod(Integer e) {
        String result = "";
        if (e < 26) {
            result += letters[e - 1];
            return result;
        }
        int count = (e - 1) / 26;
        int position = (e - 1) % 26;
        result += letters[count - 1];
        result += letters[position];
        return result;
    }

    public List<Integer> sortFromBig() {
        return array.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public List<Integer> sortFromSmall() {
        return array.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
