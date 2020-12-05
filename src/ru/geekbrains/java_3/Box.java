package ru.geekbrains.java_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box <T extends Fruits> implements Comparable<Box> {
  private List <T> list;

     Box(){
         list=new ArrayList<>();
     }

     Box( T fruit){
         this();
         addFruit(fruit);
     }

     Box(T [] fruits){
         this();
         addFruit(fruits);
     }

     public  void addFruit (T fruit) {
         this.list.add(fruit);

     }

    public  void addFruit (T ... fruit) {
        for (int i = 0; i < fruit.length; i++) {
            addFruit(fruit[i]);
        }
    }

    public float boxWeight (){
         float totalWeight=0.0f;
        for (Fruits fruits:list) {
            totalWeight+=fruits.getWeight();

        }
//         float totalWeight=0f;
//         float weight = this.getList().get(this.getList().);
//        totalWeight=list.size()*weight;
        return totalWeight;
    }

    public List<T> getList() {
        return list;
    }


    @Override
    public int compareTo(Box o) {
        return (int)(this.boxWeight()-o.boxWeight());
    }

    public boolean isSameWeight (Box o) {
         return compareTo(o)==0;
    }

    public void addFruitsToAnotherBox(Box<T> box){
         if (this != box) {
             box.list.addAll(this.list);
       // this.list.clear();
       }

    }
}
