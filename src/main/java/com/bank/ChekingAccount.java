package com.bank;

public class ChekingAccount extends Account {

	private Double overdraftLimit;

	/** CONSTRUCTORS **/

	public ChekingAccount(Integer accountNumber, String owner,
			Double overdraftLimit) {
		super(accountNumber, owner);
		this.overdraftLimit = overdraftLimit;
		this.setInterest(0.00);
	}

	/** GETTERS AND SETTERS **/
	
	public Double getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(Double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}

	public void withdrawOnAccount(Double amount) throws MyException {
		if (amount <= (getBalance() + overdraftLimit)) {
			setBalance(getBalance() - amount);
		} else {
			throw new MyException(
					"Is not possible to withdraw "
							+ amount
							+ ", the amount is more than the balance on the account plus the limit "
							+ overdraftLimit);
		}
	}
}
