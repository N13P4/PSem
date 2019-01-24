package project.encryption;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESCipher {

	private static final String IV_STRING = "A-16-Byte-String";
	private static final String charset = "UTF-8";

	public static String aesEncryptString(String content, String key) throws Exception{
		byte[] contentBytes = content.getBytes(charset);
		byte[] keyBytes = key.getBytes(charset);
		byte[] encryptedBytes = aesEncryptBytes(contentBytes, keyBytes);
		Encoder encoder = Base64.getEncoder();
		return encoder.encodeToString(encryptedBytes);
	}

	public static String aesDecryptString(String content, String key) throws Exception{
		Decoder decoder = Base64.getDecoder();
		byte[] encryptedBytes = decoder.decode(content);
		byte[] keyBytes = key.getBytes(charset);
		byte[] decryptedBytes = aesDecryptBytes(encryptedBytes, keyBytes);
		return new String(decryptedBytes, charset);
	}

	public static byte[] aesEncryptBytes(byte[] contentBytes, byte[] keyBytes) throws Exception {
		return cipherOperation(contentBytes, keyBytes, Cipher.ENCRYPT_MODE);
	}

	public static byte[] aesDecryptBytes(byte[] contentBytes, byte[] keyBytes) throws Exception{
		return cipherOperation(contentBytes, keyBytes, Cipher.DECRYPT_MODE);
	}

	private static byte[] cipherOperation(byte[] contentBytes, byte[] keyBytes, int mode) throws Exception {
		SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");

		byte[] initParam = IV_STRING.getBytes(charset);
		IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);

		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(mode, secretKey, ivParameterSpec);

		return cipher.doFinal(contentBytes);
	}

}
