package com.bank;

public class SavingAccount extends Account {


    /**CONSTRUCTORS**/

    public SavingAccount(Integer accountNumber, String owner) {
        super(accountNumber, owner);
        this.setInterest(0.02);
    }
}
