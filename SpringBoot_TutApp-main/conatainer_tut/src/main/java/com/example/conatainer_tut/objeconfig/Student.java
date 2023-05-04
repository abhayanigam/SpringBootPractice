package com.example.conatainer_tut;

public class Student {
    private int studentId;
    private String name;
    private String address;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Student(int studentId, String name, String address) {
        this.studentId = studentId;
        this.name = name;
        this.address = address;
    }

    public Student(){
        super();
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
