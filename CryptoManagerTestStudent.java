
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CryptoManagerTestStudent {

	@Test
	void testIsStringInBounds() {
	 //valid
		 assertTrue(CryptoManager.isStringInBounds("ABC should be an integer"));
	
	     
	    }

	

	@Test
	void testCaesarEncryption() {
		   assertEquals("DEF", CryptoManager.caesarEncryption("ABC", 3));
	       assertEquals("XYZ", CryptoManager.caesarEncryption("UVW", 3));	    }


	@Test
	void testBellasoEncryption() {
		  assertEquals("stu", CryptoManager.bellasoEncryption("ABC", "3"));
	      assertEquals("stu", CryptoManager.bellasoEncryption("ABC", "3")); 

	}

	@Test
	void testCaesarDecryption() {
		   assertEquals("ABC", CryptoManager.caesarDecryption("DEF", 3));
	       assertEquals("UVW", CryptoManager.caesarDecryption("XYZ", 3));

	}

	@Test
	void testBellasoDecryption() {
		assertEquals("ABC", CryptoManager.caesarDecryption("DEF", 3));
        assertEquals("UVW", CryptoManager.caesarDecryption("XYZ", 3));


	}

}
