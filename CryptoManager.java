/**
* This is a utility class that encrypts and decrypts a phrase using two
* different approaches. The first approach is called the Caesar Cipher and is a
* simple �substitution cipher� where characters in a message are replaced by a
* substitute character. The second approach, due to Giovan Battista Bellaso,
* uses a key word, where each character in the word specifies the offset for
* the corresponding character in the message, with the key word wrapping around
* as needed.
*
* @author Farnaz Eivazi
* @version 7/16/2022
*/
public class CryptoManager {
	
	private static final char LOWER_RANGE = '_';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		
		boolean bounds = true;
		for(int i = 0; i < plainText.length(); i++){
			if(plainText.charAt(i) < LOWER_RANGE && plainText.charAt(i) > UPPER_RANGE) {
				bounds = false;
			}
				
		}
		return bounds;
	}
	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return
	 * @return the encrypted string
	 */
	
	public static String caesarEncryption(String plainText, int key) {
		
	    if (!isStringInBounds(plainText)) {
	        System.out.print("The selected string is not in bounds, Try again.");
	        return "";
	    }
	    char[] encryptedChars = new char[plainText.length()];
	    for (int i = 0; i < plainText.length(); i++) {
	       char encryptedChar = (char) (plainText.charAt(i) + key);
	          if (encryptedChar > 'Z') {
	            encryptedChar = (char) (encryptedChar - 26);
	        } else if (encryptedChar < 'A') {
	            encryptedChar = (char) (encryptedChar + 26);
	        }
	        encryptedChars[i] = encryptedChar;
	    }
	  
	    return new String(encryptedChars);
	}
	

	
	
	
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption(String plainText, String bellasoStr) {
		  
	    if (!isStringInBounds(plainText)) {
	    	return "The selected string is not in bounds, Try again.";
	    }
	  
		    StringBuilder encryptedStr = new StringBuilder();
		    int bellasoLength = bellasoStr.length();
		   
		    for (int i = 0; i < plainText.length(); i++) {
		        char plainTextChar = plainText.charAt(i);
		        char bellasoChar = bellasoStr.charAt(i % bellasoLength);
		       
		        int offset = plainTextChar + bellasoChar;
		       
		        if (offset > UPPER_RANGE) {
		            offset -= RANGE;
		        }
		        encryptedStr.append((char) offset);
		    }
		   
		    return encryptedStr.toString();
		}

	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption(String encryptedText, int key) {
		if (!isStringInBounds(encryptedText)) {
	        System.out.println("The selected string is not in bounds. Please try again.");
	        return "";
	    }
	   
	    char[] decryptedChars = new char[encryptedText.length()];
	    for (int i = 0; i < encryptedText.length(); i++) {
	        char encryptedChar = encryptedText.charAt(i);
	        char decryptedChar = (char) (encryptedChar - key);
	       
	        while (decryptedChar < ' ' || decryptedChar > '~') {
	            if (decryptedChar < ' ') {
	                decryptedChar += 95;
	            } else {
	                decryptedChar -= 95;
	            }
	        }
	        decryptedChars[i] = decryptedChar;
	    }
	    return new String(decryptedChars);
	}
	// Helper method to check if encryptedText is within bounds of printable ASCII characters
	private static boolean isStringInBounds1(String text) {
	    for (int i = 0; i < text.length(); i++) {
	        char ch = text.charAt(i);
	        if (ch < ' ' || ch > '~') {
	            return false;
	        }
	    }
	    return true;
	}

	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	  public static String bellasoDecryption(String encryptedText, String bellasoStr) {
			
		    StringBuilder decryptedStr = new StringBuilder();
		    int bellasoLength = bellasoStr.length();
		   
		    for (int i = 0; i < encryptedText.length(); i++) {
		        char encryptedChar = encryptedText.charAt(i);
		        char bellasoChar = bellasoStr.charAt(i % bellasoLength);
		     
		        int offset = encryptedChar - bellasoChar;
		        if (offset < LOWER_RANGE) {
		        	offset += RANGE;
		        }
		        decryptedStr.append((char) offset);
		    }
		   
		    return decryptedStr.toString();
		}
	}


