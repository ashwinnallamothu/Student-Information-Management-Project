import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Student {
    private String studentID;
    private String name;
    private String gender;
    private int age;

    // Constructor
    public Student(String studentID, String name, String gender, int age) {
        this.studentID = studentID;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    // Getters and setters
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Override toString method to display student information
    @Override
    public String toString() {
        return studentID + "," + name + "," + age + "," + gender;
    }
}


