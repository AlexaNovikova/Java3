package ru.geekbrains.java_3;
//1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
//        2. Написать метод, который преобразует массив в ArrayList;
//        3. Большая задача:
//        a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
//        b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта,
//        поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
//        c. Для хранения фруктов внутри коробки можете использовать ArrayList;
//        d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и
//        вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
//        e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той,
//        которую подадут в compare в качестве параметра, true - если их веса равны,
//        false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
//        f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в
//        другую коробку(помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами),
//        соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты,
//        которые были в этой коробке;
//        g. Не забываем про метод добавления фрукта в коробку.

import java.util.*;

public class Main {

    public static void main(String[] args) {
        firstTask();
        secondTask();
        thirdTask();

    }


    public static void firstTask(){
        System.out.println("Первое задание.");
        System.out.println();
        Integer [] massInt =  {1,2,3,1,5,2,7,8,4,4};
        Double [] massDouble = {1.0, 3.5, 4.6, 4.0, 2.3, 3.5};
        String [] massString = {"ggg", "kkk", "www", "jjj", "uuu"};
        System.out.println(Arrays.toString(massInt));
        System.out.println(Arrays.toString(massString));
        System.out.println(Arrays.toString(massDouble));
        System.out.println();
        try{ swap(massInt,1,8);
            swap(massDouble,3,4);
            swap(massString,1,4);}
        catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            System.out.println("Выход за пределы массива");
        }
        System.out.println(Arrays.toString(massInt));
        System.out.println(Arrays.toString(massString));
        System.out.println(Arrays.toString(massDouble));
        System.out.println();

    }

    public static <T> void swap ( T [] mass, int el1, int el2) {
        if (el1> mass.length||el1<0||el2> mass.length||el2<0)
        {
            System.out.println(mass.getClass());
            throw new ArrayIndexOutOfBoundsException();
        }
       T el;
       el=mass[el1];
       mass[el1]=mass[el2];
       mass[el2]=el;
    }

    public static void secondTask(){
        System.out.println("Второе задание.");
        System.out.println();
        Integer [] massInt =  {1,2,3,1,5,2,7,8,4,4};
        Double [] massDouble = {1.0, 3.5, 4.6, 4.0, 2.3, 3.5};
        String [] massString = {"ggg", "kkk", "www", "jjj", "uuu"};

        List<Integer> integerList = new ArrayList<>();
        List<Double> doubleList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        List<Object> objects = new ArrayList<>();
        List<Number>numbers = new ArrayList<>();

        changeMassToArrayList(massInt,integerList);
        changeMassToArrayList(massDouble,doubleList);
        changeMassToArrayList(massString,stringList);
        changeMassToArrayList(massString,objects);
        changeMassToArrayList(massDouble,numbers);

        System.out.println(Arrays.toString(massInt));
        System.out.println(integerList);
        System.out.println(Arrays.toString(massString));
        System.out.println(stringList);
        System.out.println(objects);
        System.out.println(Arrays.toString(massDouble));
        System.out.println(doubleList);
        System.out.println(numbers);
        System.out.println();
    }

    public static <T> void changeMassToArrayList (T[]mass, List<? super T > arrayList) {
        Collections.addAll(arrayList, mass);
    }

    public static void thirdTask(){
        System.out.println("Третье задание.");
        System.out.println();
        Apple apple = new Apple();
        Orange orange = new Orange();
        Apple [] apples = new Apple[10];
        for (int i = 0; i < apples.length; i++) {
            apples[i]=new Apple();
        }
        Orange [] oranges = new Orange[6];
        for (int i = 0; i < oranges.length; i++) {
            oranges[i]=new Orange();
        }
        Box<Apple>appleBox = new Box<>();
        Box<Orange>orangeBox = new Box<>();
        appleBox.addFruit(apple);
        appleBox.addFruit(apple);
        appleBox.addFruit(apple);
        orangeBox.addFruit(orange);
        orangeBox.addFruit(orange);
        orangeBox.addFruit(oranges);
        appleBox.addFruit(apples);
        System.out.println("Вес коробки с апельсинами 1: " +orangeBox.boxWeight());
        System.out.println("Вес коробки с яблоками 1: "+appleBox.boxWeight());
     //   System.out.println(orangeBox.compareTo(appleBox));
        System.out.println("Коробка с апельсинами весит столько же, что и коробка с яблоками? "+orangeBox.isSameWeight(appleBox));

        Box<Apple> appleBox1 = new Box<>();
        appleBox.addFruitsToAnotherBox(appleBox1);

         Box<Orange> orangeBox2 = new Box<>();
          Orange [] oranges2 = new Orange[5];
        for (int i = 0; i < oranges2.length; i++) {
            oranges2[i]=new Orange();
        }
           orangeBox2.addFruit(oranges2);
          System.out.println("Вес коробки с апельсинами 2:" +orangeBox2.boxWeight()+ " Количество апельсинов: "+ orangeBox2.getList().size());
        orangeBox.addFruitsToAnotherBox(orangeBox2);
       System.out.println("Вес второй коробки с апельсинами после добавления в нее апельсинов из первой коробки = "+orangeBox2.boxWeight());
        System.out.println("Вес коробки с яблоками 2:" +appleBox1.boxWeight());
         appleBox.addFruitsToAnotherBox(appleBox1);
        System.out.println("Вес второй коробки с яблоками после добавления в нее яблок из первой коробки = "+appleBox1.boxWeight());
        orangeBox2.addFruitsToAnotherBox(orangeBox2);
       System.out.println("Вес второй коробки с апельсинами после попытки пересыпать в нее апельсины из себя самой " +orangeBox2.boxWeight());
        System.out.println();
    }
    }

