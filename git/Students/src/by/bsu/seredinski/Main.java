package by.bsu.seredinski;

import by.bsu.seredinski.models.Group;
import by.bsu.seredinski.models.Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Student[] students = new Student[5];
        students[0] = new Student("Tim", new int[]{7, 6, 8, 8}, "2");
        students[1] = new Student("Nick", new int[]{10, 8, 8, 9}, "9");
        students[2] = new Student("Max", new int[]{9, 7, 6, 10}, "2");
        students[3] = new Student("Dean", new int[]{4, 6, 4, 8}, "9");
        students[4] = new Student("John", new int[]{8, 5, 7, 7}, "2");

        Group[] groups = new Group[2];
        groups[0] = new Group("2", "Web", new Student[]{students[0], students[2], students[4]});
        groups[1] = new Group("9", "Mobile", new Student[]{students[1], students[3]});

        while (true) {
            System.out.println("\nВведите номер нужной операции");
            System.out.println("1. Средняя оценка студента");
            System.out.println("2. Средняя оценка по группе");
            Scanner in = new Scanner(System.in);
            int input = in.nextInt();
            Scanner scanner = new Scanner(System.in);
            switch (input) {
                case 1:
                    System.out.println("Введите имя студента");
                    String nameOfStudent = scanner.nextLine();
                    double average = Student.averageMarkOfStudent(nameOfStudent, students);
                    if (average != 0) {
                        System.out.println("Average mark of " + nameOfStudent + " is " + average);
                    } else {
                        System.out.println("Student not found");
                    }
                    break;
                case 2:
                    System.out.println("Введите номер группы");
                    String idOfGroup = scanner.nextLine();
                    double averageGroupMark = Group.averageMarkInGroup(idOfGroup, groups);
                    if (averageGroupMark != 0) {
                        System.out.println("Average mark of group number " + idOfGroup + " is " + averageGroupMark);
                    } else {
                        System.out.println("Group not found");
                    }
                    break;
            }
        }
    }
}
