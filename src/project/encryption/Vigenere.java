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

	public static String encrypt(String text, final String key) {
		String res = "";
		text = text.toUpperCase();
		for (int i = 0, j = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if (c < 'A' || c > 'Z') continue;
			res += (char)((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
			j = ++j % key.length();
		}
		return res;
	}

	public static String decrypt(String text, final String key) {
		String res = "";
		text = text.toUpperCase();
		for (int i = 0, j = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if (c < 'A' || c > 'Z') continue;
			res += (char)((c - key.charAt(j) + 26) % 26 + 'A');
			j = ++j % key.length();
		}
		return res;
	}
}

