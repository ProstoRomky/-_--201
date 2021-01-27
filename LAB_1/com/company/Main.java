package com.company;

import java.util.Scanner;

public class Main {
    int a;
    char b;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Task1:\nHello World");
        System.out.println("Task2:");
        Main NEW = new Main();
        System.out.print( "a is " + NEW.a + " ; b is " + (int)NEW.b);

        Method method = new Method();
        System.out.print("\nВведіть початок інтервалу:");
        method.begin = in.nextInt();

        System.out.print("Введіть кінець інтервалу: ");
        method.end = in.nextInt();

        System.out.print("Непарні числа(За зростанням): ");
        method.Odd();
        System.out.print("Парні числа(За спаданням): ");
        method.Even(); ;



        System.out.println("Сума непарних: " + method.SumOdd());
        System.out.println("Сума парних: " + method.SumEven());

        System.out.print("Введіть розмірність ряду Фібоначчі: ");
        int length = in.nextInt();
        if (method.end % 2 != 0) { //перевірка чи виводитимуться парні числа
            System.out.print("Ряд: " + method.end + ";");
            method.even++;
        }
        else if (method.end % 2 == 0) { // перевірка чи виводитимуться непарні числа
            System.out.print("Ряд: " + (method.end - 1) + ";");
            method.odd++;
        }
        for (int i = 0; i < length - 1; ++i)
            System.out.print(method.Fibonacci(i) + ";"); //вивід на екран ряду Фібоначчі

        System.out.println("\nВідсоток непарних чисел у ряді:" + method.percentOdd(length) + "%");
        System.out.println("Відсоток парних чисел у ряді:" + method.percentEven(length) + "%");
    }
}
