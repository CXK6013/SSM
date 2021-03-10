package org.example.ioc;

/**
 * @author XingKe
 * @date 2021-02-14 22:06
 */
public class HomeStudent extends Student {
    /**
     * 出入证
     */
    private String pass;

    public HomeStudent() {
    }

    public HomeStudent(String pass) {
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "HomeStudent{" +
                "pass='" + pass + '\'' +
                '}';
    }
}
