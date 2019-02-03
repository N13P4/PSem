package project.encryption;


public class Vigenere {



	public static String encrypt(String input, int key) {
		StringBuilder enc = new StringBuilder();
		for (int i = 0; i < input.length(); i++){
			char ch = (char)(input.codePointAt(i) + key);
			enc.append(ch);
		}
		return enc.toString();
	}
	public static String decrypt(String input, int key) {
		StringBuilder dec = new StringBuilder();
		for (int i = 0; i < input.length(); i++){
			char ch = (char)(input.codePointAt(i) - key);
			dec.append(ch);
		}
		return dec.toString();
	}




	}

