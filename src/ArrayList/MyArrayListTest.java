package ArrayList;

import java.util.Random;

public class MyArrayListTest {

    public static void main(String[] args) {
        MyArrayList<Integer> myList = new MyArrayList<>();

        // Додавання 1 мільйона елементів
        for (int i = 0; i < 1000000; i++) {
            myList.add(i);
        }

        // Перевірка розміру
        System.out.println("Розмір списку: " + myList.size()); // Очікуваний результат: 1000000

        // Отримання елементу за індексом
        int index = 500000;
        System.out.println("Елемент з індексом " + index + ": " + myList.get(index)); // Очікуваний результат: 500000

        // Видалення елементу за індексом
        myList.remove(index);

        // Перевірка розміру після видалення
        System.out.println("Розмір списку після видалення: " + myList.size()); // Очікуваний результат: 999999

        // Отримання елементу після видалення
        System.out.println("Елемент з індексом " + index + " після видалення: " + myList.get(index)); // Очікуваний результат: 500001
    }
}
