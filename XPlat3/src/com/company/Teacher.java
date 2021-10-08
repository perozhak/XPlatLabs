package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Teacher {

    private String surname;
    private String course;
    private List<String> students = new ArrayList<>();

    public Teacher(String input) {
        String[] data = input.split(" ");
        this.surname = data[0];
        this.course = data[1];
        this.students.addAll(Arrays.asList(data).subList(2, data.length));
    }

    public String getSurname() {
        return surname;
    }

    public String getCourse() {
        return course;
    }

    public List<String> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "surname='" + surname + '\'' +
                ", course='" + course + '\'' +
                ", students=" + students +
                '}';
    }

}
