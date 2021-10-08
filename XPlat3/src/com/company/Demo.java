package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Demo {

    private static final String FILENAME_1 = "file1.txt";
    private static final String FILENAME_2 = "file2.txt";

    private static List<String> students = new ArrayList<>();
    private static final List<Teacher> teachers = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Initial list of teachers:");
        readFile(FILENAME_1);
        display(teachers);

        while (true) {
            menu();

            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();

            try {
                checkInput(input);
            } catch (InputMismatchException e) { break; }
            catch (IllegalArgumentException e) {
                e.printStackTrace();
                System.out.println();
            }
        }
    }

    private static void menu() {
        System.out.println("Enter number 1-3 to execute corresponding task or 'e' to exit: ");
    }

    private static void checkInput(String input) {
        switch (input) {
            case "1":
                display(getStudentCourses());
                break;
            case "2":
                display(getStudentsWithAllCourses());
                break;
            case "3":
                display(getNonAverageTeacherInfo());
                break;
            case "e":
                throw new InputMismatchException();
            default:
                throw new IllegalArgumentException("Wrong parameter chosen!");
        }
    }

    private static Map<String, List<String>> getStudentCourses() {
        Map<String, List<String>> studentCourses = new HashMap<>();
        for (String student : students) {
            List<String> courses = new ArrayList<>();
            for (Teacher t : teachers) {
                if (t.getStudents().contains(student)) {
                    courses.add(t.getCourse());
                }
            }
            studentCourses.put(student, courses);
        }
        return studentCourses;
    }

    private static List<String> getStudentsWithAllCourses() {
        List<String> list = new ArrayList<>();
        Map<String, List<String>> map = getStudentCourses();
        for (Map.Entry<String, List<String>> student : map.entrySet()) {
            if (student.getValue().size() == teachers.size()) {
                list.add(student.getKey());
            }
        }
        return list;
    }

    private static List<String> getNonAverageTeacherInfo() {
        readFile(FILENAME_2);
        List<String> list = new ArrayList<>();
        int avgStudentNumber = countAverageStudentNumber();

        for (Teacher t : teachers) {
            if (t.getStudents().size() > avgStudentNumber) {
                list.add(t.getSurname());
            }
        }
        return list;
    }

    private static int countAverageStudentNumber() {
        int sum = 0;
        for (Teacher t : teachers) {
            sum += t.getStudents().size();
        }
        return (sum / teachers.size());
    }

    private static void readFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                Teacher t = new Teacher(line);
                teachers.add(t);
                students.addAll(t.getStudents());
            }
            students = students.stream().distinct().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void display(List list) {
        for (Object o : list) {
            System.out.println(o);
        }
        System.out.println();
    }

    private static void display(Map<String, List<String>> map) {
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println();
    }

}
