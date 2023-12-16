package org.example.task1.HW3;


import org.example.task1.task2.ToDo;
import org.example.task1.task2.ToDoListApp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.task1.task2.ToDoListApp.*;


/*
Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
Обеспечьте поддержку сериализации для этого класса.
Создайте объект класса Student и инициализируйте его данными. Сериализуйте этот объект в файл.
Десериализуйте объект обратно в программу из файла.
Выведите все поля объекта, включая GPA, и обсудите, почему значение GPA не было сохранено/восстановлено.

 * Выполнить задачу 1 используя другие типы сериализаторов (в xml и json документы).
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student("Даниил", 22, 4.9);
        System.out.println("Входные данные:");
        System.out.println("Имя: " + student.getName());
        System.out.println("Возраст: " + student.getAge());
        System.out.println("Средний балл: " + student.getGPA());



        try(FileOutputStream fileOutputStream = new FileOutputStream("userdata.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(student);
            System.out.println("Объект Student сериализован.");
        }

        try(FileInputStream fileInputStream = new FileInputStream("userdata.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            student = (Student) objectInputStream.readObject();
            System.out.println("Объект Student десериализован.");
        }

        System.out.println("Объект Student десериализован.");
        System.out.println("Имя: " + student.getName());
        System.out.println("Возраст: " + student.getAge());
        System.out.println("Средний балл (должен быть null, так как transient): " + student.getGPA());
    }


}
