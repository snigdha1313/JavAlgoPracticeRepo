import java.io.PrintStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

class EncryptDecrypt {
	
	/**
	 * Decrypt an encrypted message 
	 *
	 * @param encryptedCipher encrypted Cipher text.
	 * @param iv randomly generated IV
	 * @param key randomly generated key
	 * @param modeandPadding . Example: "AES/CBC/PKCS5PADDING" 
	 * @return decrypted text.
	 */
	 static String decrypt(String encryptedCipher, IvParameterSpec iv, SecretKey key, String method, String mode)
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		// TODO Auto-generated method stub
		Cipher cipher = Cipher.getInstance(method + "/" + mode + "/" + "PKCS5PADDING");
		cipher.init(Cipher.DECRYPT_MODE, key, iv);
		byte[] original = cipher.doFinal(Base64.getDecoder().decode(encryptedCipher));
		return new String(original);
	}
	
	/**
	 * encrypt a message 
	 *
	 * @param message.
	 * @param iv randomly generated IV
	 * @param key randomly generated key
	 * @param modeandPadding . Example: "AES/CBC/PKCS5PADDING" 
	 * @return encrypted text.
	 */
	 static String encrypt(String message, IvParameterSpec iv, SecretKey key, String method, String mode)
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		// TODO Auto-generated method stub
		Cipher cipher = Cipher.getInstance(method + "/" + mode + "/" + "PKCS5PADDING");
		cipher.init(Cipher.ENCRYPT_MODE, key, iv);
		byte[] encrypted = cipher.doFinal(message.getBytes());
		return Base64.getEncoder().encodeToString(encrypted);

	}
	
	/**
	 * Randomly generate key for AES and DES
	 *
	 * @param mode CBC OR OFB
	 * @param keysize  128 for AES, 56 for DES
	 * @return generated key.
	 */
	 static SecretKey generateRandomKey(String mode, int keySize) throws NoSuchAlgorithmException {

		KeyGenerator gen = KeyGenerator.getInstance(mode);
		gen.init(keySize); /* 128-bit AES */
		SecretKey secret = gen.generateKey();
		return secret;
	}
	
	/**
	 * Randomly generate initialization vector for AES and DES
	 * @param keysize  128 for AES, 56 for DES
	 * @return generated IV.
	 */
	 static IvParameterSpec generateRandomIV(int keySize) {
		// TODO Auto-generated method stub
		SecureRandom randomSecureRandom = new SecureRandom();
		byte[] iv = new byte[keySize / 8];
		randomSecureRandom.nextBytes(iv);
		IvParameterSpec ivParams = new IvParameterSpec(iv);
		return ivParams;
	}
	
	/**
	 * change IV to base64 encoded
	 * @param IV
	 * @return base64 encoded IV.
	 */
	 static String base64EncodeIV(IvParameterSpec iv) {
		// TODO Auto-generated method stub
		return Base64.getEncoder().encodeToString(iv.getIV());
	}
	
	/**
	 * change key to base64 encoded
	 * @param key
	 * @return base64 encoded key.
	 */
	 static String base64EncodedKey(SecretKey key) {
		// TODO Auto-generated method stub
		return Base64.getEncoder().encodeToString(key.getEncoded());
	}
	 
	 /**
		 * change decode secret key
		 * @param encodedkey and method 
		 * @return secret key.
		 */
	 
	static SecretKey SecretkeyDecode(String encodedKey, String method) {
		byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
			// rebuild key using SecretKeySpec
		return new SecretKeySpec(decodedKey, 0, decodedKey.length, method);
		}
	
	/**
	 * change decode iv
	 * @param base64iv 
	 * @return IV.
	 */
	
	static IvParameterSpec ivDecode(String Base64IV) {
		// TODO Auto-generated method stub
		byte[] decodediv = Base64.getDecoder().decode(Base64IV);
		// rebuild key using SecretKeySpec
		return new IvParameterSpec(decodediv);
	}
	
	static void output(String text, PrintStream ps1, PrintStream ps2) {        
	    ps1.println(text);
	    ps2.println(text);
	}
	

}
