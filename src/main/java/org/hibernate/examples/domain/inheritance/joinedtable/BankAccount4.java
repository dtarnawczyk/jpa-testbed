package org.hibernate.examples.domain.inheritance.joinedtable;

import com.sun.istack.internal.NotNull;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Entity
@AttributeOverride(name = "owner",
        column = @Column(name= "BA_OWNER", nullable = false)
)
@DiscriminatorColumn(name = "BA")
public class BankAccount4 extends BillingDetails4 {

    @NotNull
    private String account;
    @NotNull
    private String bankname;
    @NotNull
    private String swift;

    private BankAccount4(){
        super();
    }

    public BankAccount4(String owner, String account, String bankname, String swift) {
        super(owner);
        this.account = account;
        this.bankname = bankname;
        this.swift = swift;
    }

    public Long getId() {
        return id;
    }

    public String getAccount() {

        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }
}
