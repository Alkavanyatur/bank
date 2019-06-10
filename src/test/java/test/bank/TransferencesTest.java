package test.bank;
import static org.junit.Assert.*;
import com.bank.ChekingAccount;
import com.bank.SavingAccount;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class TransferencesTest {

	SavingAccount sAccount1 = new SavingAccount(1, "Juan Perez");
	SavingAccount sAccount2 = new SavingAccount(2, "Maria Hernandez");
	
	ChekingAccount cAccount1 = new ChekingAccount(3, "Luis Gomez",300.00);
	ChekingAccount cAccount2 = new ChekingAccount(4, "Alvaro Soria",300.00);
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {	
		
		sAccount1.setBalance(1000.00);
		sAccount2.setBalance(1000.00);
		
		cAccount1.setBalance(1000.00);
		cAccount2.setBalance(1000.00);
		
	}
	
	@Test
	public void testTransference() {
		sAccount1.Transference(sAccount1,cAccount1,400.00);
		
		assertEquals(sAccount1.getBalance(), Double.valueOf("600.00"));
		assertEquals(cAccount1.getBalance(), Double.valueOf("1400.00"));
	}

	/*@Test
	public void testTransferenceException() {

		sAccount1.Transference(sAccount1,cAccount1,4000.00);
		
		assertEquals(sAccount1.getBalance(), Double.valueOf("1000.00"));
		assertEquals(cAccount1.getBalance(), Double.valueOf("1000.00"));
	}*/

}
