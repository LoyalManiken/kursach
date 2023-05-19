package dev.application.paymentInfo.Entity;

import jakarta.persistence.*;


import java.util.Date;

@Entity
@Table(name="checks")
public class Check {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paymentType_id", referencedColumnName = "id")
    private PaymentType paymentType;
    private Date date;
    private int checkSum;
    private int checkSumWithNds;

    public Long getId() {
        return id;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCheckSum() {
        return checkSum;
    }

    public void setCheckSum(int checkSum) {
        this.checkSum = checkSum;
    }

    public void setCheckSumWithNds(int checkSumWithNds) {
        this.checkSumWithNds = checkSumWithNds;
    }
}
