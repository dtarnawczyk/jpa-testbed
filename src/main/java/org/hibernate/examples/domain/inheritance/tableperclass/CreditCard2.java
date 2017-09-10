package org.hibernate.examples.domain.inheritance.tableperclass;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
@AttributeOverride(name = "owner",
                   column = @Column(name= "CC_OWNER", nullable = false)
)
public class CreditCard2 extends BillingDetails2 {

    @NotNull
    private String cardNumber;

    @NotNull
    private String expMonth;

    @NotNull
    private String expYear;

    private CreditCard2(){
        super();
    }

    public CreditCard2(String owner, String cardNumber, String expMonth, String expYear) {
        super(owner);
        this.cardNumber = cardNumber;
        this.expMonth = expMonth;
        this.expYear = expYear;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(String expMonth) {
        this.expMonth = expMonth;
    }

    public String getExpYear() {
        return expYear;
    }

    public void setExpYear(String expYear) {
        this.expYear = expYear;
    }

    public Long getId() {
        return id;
    }
}
