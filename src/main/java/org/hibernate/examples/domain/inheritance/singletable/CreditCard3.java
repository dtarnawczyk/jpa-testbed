package org.hibernate.examples.domain.inheritance.singletable;

import com.sun.istack.internal.NotNull;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Entity
@AttributeOverride(name = "owner",
                   column = @Column(name= "CC_OWNER", nullable = false)
)
@DiscriminatorColumn(name = "CC")
public class CreditCard3 extends BillingDetails3 {

    @NotNull
    private String cardNumber;

    @NotNull
    private String expMonth;

    @NotNull
    private String expYear;

    private CreditCard3(){
        super();
    }

    public CreditCard3(String owner, String cardNumber, String expMonth, String expYear) {
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
