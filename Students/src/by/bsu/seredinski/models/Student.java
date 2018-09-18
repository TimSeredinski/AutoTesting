package by.bsu.seredinski.models;

import java.util.Arrays;

public class Student {

    private String name;
    private int[] marks;
    private String groupId;

    public Student(String name, int[] marks, String groupId) {
        this.name = name;
        this.marks = marks;
        this.groupId = groupId;
    }

    public static double averageMarkOfStudent(String name, Student[] students) {
        int sum = 0;
        double average = 0;
        for (Student student : students) {
            if (student.getName().equals(name)) {
                for (int i = 0; i < student.getMarks().length; i++) {
                    sum += student.getMarks()[i];
                }
                average = sum / (double)student.getMarks().length;
            }
        }
        return average;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", marks=" + Arrays.toString(marks) +
                ", groupId='" + groupId + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
