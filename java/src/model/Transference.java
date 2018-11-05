package model;

public class Transference {

	/** CONSTRUCTORS **/

	public static void Transference(Account transfer, Account transferred, Double amount) {

		try {
			transfer.withdrawOnAccount(amount);
			transferred.depositOnAccount(amount);
		} catch (MyException e) {
			e.printStackTrace();
		}
	

	}

}
