package org.hibernate.examples.domain.inheritance.mappedsuperclass;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
@AttributeOverride(name = "owner",
        column = @Column(name= "BA_OWNER", nullable = false)
)
public class BankAccount extends BillingDetails {
    @Id
//    @GeneratedValue(generator = Constants.ID_GENERATOR)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotNull
    private String account;
    @NotNull
    private String bankname;
    @NotNull
    private String swift;

    private BankAccount(){
        super();
    }

    public BankAccount(String owner, String account, String bankname, String swift) {
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
