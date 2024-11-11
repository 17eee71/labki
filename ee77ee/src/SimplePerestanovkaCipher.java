public class SimplePerestanovkaCipher {
    private static final int[] PATTERN = {2, 0, 3, 1};
    public static String encrypt(String text) {
        StringBuilder encryptedText = new StringBuilder();
        int length = text.length();

        while (text.length() % PATTERN.length != 0) {
            text += " ";
        }

        for (int i = 0; i < text.length(); i += PATTERN.length) {
            char[] group = new char[PATTERN.length];
            for (int j = 0; j < PATTERN.length; j++) {
                group[j] = text.charAt(i + PATTERN[j]);
            }
            encryptedText.append(new String(group));
        }

        return encryptedText.toString();
    }
    public static String decrypt(String text) {
        StringBuilder decryptedText = new StringBuilder();
        int length = text.length();

        for (int i = 0; i < text.length(); i += PATTERN.length) {
            char[] group = new char[PATTERN.length];
            for (int j = 0; j < PATTERN.length; j++) {
                group[PATTERN[j]] = text.charAt(i + j);
            }
            decryptedText.append(new String(group));
        }
        return decryptedText.toString().trim();
    }

    public static void main(String[] args) {
        String originalText = "ЗАЩИТАИНФОРМАЦИИ";
        String encrypted = encrypt(originalText);
        String decrypted = decrypt(encrypted);

        System.out.println("Оригинальный текст: " + originalText);
        System.out.println("Зашифрованный текст: " + encrypted);
        System.out.println("Расшифрованный текст: " + decrypted);
    }
}