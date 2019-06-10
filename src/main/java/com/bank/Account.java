package com.bank;

import java.io.*;

import com.bank.Account;
import com.bank.MyException;

public class Account implements Serializable {

	private Integer accountNumber;
	private Double balance;
	private String owner;
	private Double interest;

	/** CONSTRUCTORS **/

	public Account(Integer accountNumber, String owner) {
		this.accountNumber = accountNumber;
		this.owner = owner;
		this.interest = 00.00;
	}

	/** GETTERS AND SETTERS **/

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getOwner() {
		return owner;
	}

	public Double getInterest() {
		return interest;
	}

	public void setInterest(Double interest) {
		this.interest = interest;
	}

	/** PUBLIC METHODS **/

	public void depositOnAccount(Double amount) throws MyException {
		if (amount > 0) {
			balance += amount;
		} else {
			throw new MyException("Is not possible to deposit " + amount
					+ ", the amount should be possitive.");
		}
	}

	public void withdrawOnAccount(Double amount) throws MyException {
		if (amount <= balance) {
			balance -= amount;
		} else {
			throw new MyException("Is not possible to withdraw " + amount
					+ ", the amount is more than the balance on the account");
		}
	}

	public void payInterest() {
		balance = balance + (balance * interest);
	}

	
	public static void Transference(Account transfer, Account transferred,
			Double amount) {

		try {
			transfer.withdrawOnAccount(amount);
			transferred.depositOnAccount(amount);
		} catch (MyException e) {
			e.printStackTrace();
		}

	}
}
