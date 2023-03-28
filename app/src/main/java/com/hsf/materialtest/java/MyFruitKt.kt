package com.hsf.materialtest.java

import java.util.*

class MyFruitKt {
    fun printFruits() {
        val fruitList: MutableList<String> = ArrayList()
        fruitList.add("Apple")
        fruitList.add("Banana")
        for (fruit in fruitList) {
            println(fruit)
        }
    }
}