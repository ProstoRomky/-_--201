/*Student: id, Прізвище, Ім'я, По батькові, Дата народження, Адреса,

Телефон, Факультет, Курс, Група.
Скласти масив об'єктів. Вивести:
a) список студентів заданого факультету;
b) список студентів, які народились після заданого року;
c) список навчальної групи.*/
package com.company;
import com.company.student.Student;
import java.util.Scanner;

public class Main {
    public static Student[] createList(int numb) {
        System.out.println("Введіть дані: id, Прізвище, Ім'я, По батькові, Дата народження, Адреса, Телефон, Факультет, Курс, Група.");
        Student a = new Student(1, "Питель", "Владислав", "Михайлович",1999, "Червоноград", "0666653348", "ІКТА", 4, "КІ-44");
        Student b = new Student(2, "Андріїв", "Андрій", "Андрійович", 2002, "Стрий", "0975209264", "ІКНІ", 2, "КН-206");
        Student c = new Student(3, "Михайлов", "Михайло", "Михайлович", 2004, "Львів", "0970047268", "ІСТР", 1,"ТУ-11");
       Student d = new Student(4, "Максимов", "Максим", "Максимович", 2001, "Львів", "06387202884", "ІКНІ", 3, "КН-31");
        Student e = new Student(5, "Іванів", "Андрій", "Іванович", 2002, "Хмельницький", "06693745201", "ІКНІ", 2, "КН-206");
        Student f = new Student(6, "Семенів", "Семен", "Семенович", 2000, "Луцьк", "0975302834", "ІКТА", 4, "КІ-44");
        Student g = new Student(7, "Романів", "Роман", "Романович", 2003, "Запоріжжя", "0639201306", "ІСТР", 2,"ТУ-21");

        Student[] person = new Student[7];

        person[0] = a;
        person[1] = b;
        person[2] = c;
        person[3] = d;
        person[4] = e;
        person[5] = f;
        person[6] = g;
        return person;
    }

    static void printList(Student[] person, int numb) {
        System.out.println("Лист всіх студентів: ");
        for (int i = 0; i < numb; ++i) {
            System.out.println(person[i]);
        }
    }

    public static void printTaskA( Student[] person, int numb) {
        int a = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("\nВведіть факультет: ");
        String faculty = in.nextLine();
        System.out.println("На факультеті " + faculty + " вчатся:");
        for (int i = 0; i < numb; ++i) {
            if (faculty.equals(person[i].getFaculty().intern())) {
                System.out.println(person[i].getLastName() + ' ' + person[i].getFirstName() + ' ' + person[i].getSurname());
                a++;
            }
        }
        if (a == 0) {
            System.out.println("Студентів цього факультету не має у списку.");
        }
    }

    public static void printTaskB(Student[] arr, int numb) {
        int a = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("\nВведіть рік: ");
        int year = in.nextInt();
        System.out.println("Студенти, які народились після " + year + " року:");
        for (int i = 0; i < numb; ++i) {
            if (arr[i].getDateOfBirth() < year) {
                System.out.println(arr[i].toString());
                a++;
            }
        }
        if (a == 0) {
            System.out.println("Студентів, які народились після " + year + " року немає.");
        }
    }

    public static void printTaskC(Student[] person, int numb) {
        int a = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("\nВведіть групу: ");
        String group = in.nextLine();
        System.out.println("Студенти з " + group + "  групи:");
        for (int i = 0; i < numb; ++i) {
            if (group.equals(person[i].getGroup())) {
                System.out.println(person[i].toString());
                a++;
            }
        }
        if (a == 0) {
            System.out.println("Студентів " + group + " групи нема у списку.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Введіть кількість студентів:");
        int numb = 7;
        Student[] person = createList(numb);
        printList(person,numb);
        printTaskA(person,numb);
        printTaskB(person,numb);
        printTaskC(person,numb);
    }
}