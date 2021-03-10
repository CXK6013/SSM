package org.example.ioc;

/**
 * @author XingKe
 * @date 2021-02-12 18:32
 */
public class StudentCard {
    private int id;
    private String cardNo;

    public StudentCard() {
    }

    public StudentCard(int id, String cardNo) {
        this.id = id;
        this.cardNo = cardNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    @Override
    public String toString() {
        return "StudentCard{" +
                "id=" + id +
                ", cardNo='" + cardNo + '\'' +
                '}';
    }
}
