package org.example.ioc;

/**
 * @author XingKe
 * @date 2021-02-12 17:24
 */
    public class Student {
    private int age;
    private String name;
    private StudentCard studentCard;

    public Student() {

    }
    public Student(int age, String name , StudentCard studentCard) {

        this.age = age;
        this.name = name;
        this.studentCard = studentCard;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudentCard getStudentCard() {
        return studentCard;
    }

    public void setStudentCard(StudentCard studentCard) {
        this.studentCard = studentCard;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", studentCard=" + studentCard +
                '}';
    }
}
