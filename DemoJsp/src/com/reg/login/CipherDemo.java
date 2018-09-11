package com.reg.login;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.SecureDirectoryStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
public class CipherDemo {

public static void main(String[] args) throws Exception {

	byte[] encryptionKey = "MZygpewJsCpRrfOr".getBytes(StandardCharsets.UTF_8);
	byte[] plainText = "Hello world!!".getBytes(StandardCharsets.UTF_8);
	CipherDemo CipherDemo = new CipherDemo(
	        encryptionKey);
	byte[] cipherText = CipherDemo.encrypt(plainText);
	byte[] decryptedCipherText = CipherDemo.decrypt(cipherText);

	System.out.println(new String(plainText));
	System.out.println(new String(cipherText));
	System.out.println(new String(decryptedCipherText));
}
private byte[] key;

private static final String ALGORITHM = "AES";

public CipherDemo(byte[] key)
{
    this.key = key;
}

/**
 * Encrypts the given plain text
 *
 * @param plainText The plain text to encrypt
 */
public byte[] encrypt(byte[] plainText) throws Exception
{
    SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
    Cipher cipher = Cipher.getInstance(ALGORITHM);
    cipher.init(Cipher.ENCRYPT_MODE, secretKey);

    return cipher.doFinal(plainText);
}

/**
 * Decrypts the given byte array
 *
 * @param cipherText The data to decrypt
 */
public byte[] decrypt(byte[] cipherText) throws Exception
{
    SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
    Cipher cipher = Cipher.getInstance(ALGORITHM);
    cipher.init(Cipher.DECRYPT_MODE, secretKey);

    return cipher.doFinal(cipherText);
}	

	


}
