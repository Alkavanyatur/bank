package test.bank;

import static org.junit.Assert.*;
import com.bank.ChekingAccount;
import com.bank.MyException;

import org.junit.Before;
import org.junit.Test;


public class ChekingAccountTest {

	ChekingAccount account = new ChekingAccount(1, "Juan Perez",300.00);
	
	@Before
	public void setUp() throws Exception {	
		
		account.setBalance(1000.00);
		
	}
	
	@Test
	public void testDepositOnAccount() {
		try {
			account.depositOnAccount(200.00);
		} catch (MyException e) {
			e.printStackTrace();
		}
		assertEquals(account.getBalance(), Double.valueOf(1200.00));
	}

	@Test
	public void testDepositOnAccountException() {
		try {
			account.depositOnAccount(-200.00);
		} catch (MyException e) {
			assertEquals(e.getMessage(), ("Is not possible to deposit -200.0, the amount should be possitive."));
		}
	}
	
	@Test
	public void testWithdrawOnAccount() {
		try {
			account.withdrawOnAccount(200.00);
		} catch (MyException e) {
			e.printStackTrace();
		}
		assertEquals(account.getBalance(), Double.valueOf(800.00));
	}
	
	@Test
	public void testWithdrawOnAccountLimit() {
		try {
			account.withdrawOnAccount(1200.00);
		} catch (MyException e) {
			e.printStackTrace();
		}
		assertEquals(account.getBalance(), Double.valueOf(-200.00));
	}
	
	@Test
	public void testWithdrawOnAccountException() {
		try {
			account.withdrawOnAccount(2000.00);
		} catch (MyException e) {
			assertEquals(e.getMessage(), ("Is not possible to withdraw 2000.0, the amount is more than the balance on the account plus the limit 300.0"));
		}
	}
	
	@Test
	public void testPayInterest() {
		
		account.payInterest();
		
		assertEquals(account.getBalance(), Double.valueOf(1000.00));
	}

}
