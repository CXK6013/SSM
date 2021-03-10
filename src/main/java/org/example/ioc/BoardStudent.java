package org.example.ioc;

/**
 * @author XingKe
 * @date 2021-02-14 22:04
 */
public class BoardStudent extends Student {
    /**
     * 宿舍号
     */
    private String dormitoryNumber;

    public BoardStudent() {
    }

    public BoardStudent(String dormitoryNumber) {
        this.dormitoryNumber = dormitoryNumber;
    }

    public BoardStudent(int age, String name, StudentCard studentCard, String dormitoryNumber) {
        super(age, name, studentCard);
        this.dormitoryNumber = dormitoryNumber;
    }

    public String getDormitoryNumber() {
        return dormitoryNumber;
    }

    public void setDormitoryNumber(String dormitoryNumber) {
        this.dormitoryNumber = dormitoryNumber;
    }

    @Override
    public String toString() {
        return "BoardStudent{" +
                "dormitoryNumber='" + dormitoryNumber + '\'' +
                '}';
    }
}
