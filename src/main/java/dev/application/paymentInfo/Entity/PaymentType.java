package dev.application.paymentInfo.Entity;


import jakarta.persistence.*;

@Entity
@Table(name="paymenttypes")
public class PaymentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private int nds;
    @OneToOne(mappedBy = "paymentType")
    private Check check;

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNds() {
        return nds;
    }

    public void setNds(int nds) {
        this.nds = nds;
    }
}
