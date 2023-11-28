package ru.geekbrains.JJ_01_HW;

/*
1. Создать список из 1_000 рандомных чисел от 1 до 1_000_000
   * 1.1 Найти максимальное
   * 1.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
   * 1.3 Найти количество чисел, квадрат которых меньше, чем 100_000
 */

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        System.out.println("1. Создать список из 1_000 рандомных чисел от 1 до 1_000_000");

        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1001; i++) {
            list.add(random.nextInt(1_000_000));
        }
        System.out.println(list);

        System.out.println("\n1.1 Найти максимальное");

        Optional<Integer> max = list.stream().max(Integer::compare);
        System.out.printf("Максимальное значение в массиве: " + max.get());

        System.out.println("\n\n1.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать");

        list = list.stream().sorted().filter(numbers -> numbers > 500_000).map(numbers -> (numbers * 5) - 150).collect(Collectors.toList());
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum = sum + list.get(i);
        }
        System.out.println("Сумма чисел, которые больше 500 000, помноженные на 5 и за минусом 150, равняется: " + sum);

        System.out.println("\n1.3 Найти количество чисел, квадрат которых меньше, чем 100_000");

        System.out.println(
                list.stream()
                .filter(numbers -> (numbers * numbers) < 100_000)
                .count()
        );
        ;
    }
}