package by.bsu.seredinski.models;

import java.util.Arrays;

public class Group {

    private String id;
    private String name;
    private Student[] students;

    public Group(String id, String name, Student[] students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }

    public static double averageMarkInGroup(String id, Group[] groups) {
        double sum = 0;
        double average = 0;
        for (Group group : groups) {
            if (group.getId().equals(id)) {
                for (int i = 0; i < group.getStudents().length; i++) {
                    sum += Student.averageMarkOfStudent(group.getStudents()[i].getName(), group.getStudents());
                }
                average = sum/ (double)group.getStudents().length;
            }
        }
        return average;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", students=" + Arrays.toString(students) +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }
}
