package com.hsf.materialtest.java;

import java.util.ArrayList;
import java.util.List;

public class MyFruit {
    public void printFruits() {
        List<String> fruitList = new ArrayList<>();
        fruitList.add("Apple");
        fruitList.add("Banana");
        for (String fruit: fruitList) {
            System.out.println(fruit);
        }
    }
}
