public class MagicSquareCipher {
    private static final int[][] MAGIC_SQUARE = {
            {16, 3, 2, 13},
            {5, 10, 11, 8},
            {9, 6, 7, 12},
            {4, 15, 14, 1}
    };
    private static final int SIZE = 4;
    public static String encrypt(String text) {
        char[] chars = text.toCharArray();
        char[][] square = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int position = MAGIC_SQUARE[i][j] - 1;
                if (position < chars.length) {
                    square[i][j] = chars[position];
                } else {
                    square[i][j] = ' ';
                }
            }
        }
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                encryptedText.append(square[i][j]);
            }
        }
        return encryptedText.toString();
    }
    public static String decrypt(String text) {
        char[] chars = text.toCharArray();
        char[] decryptedChars = new char[SIZE * SIZE];

        int index = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int position = MAGIC_SQUARE[i][j] - 1;
                decryptedChars[position] = chars[index++];
            }
        }

        return new String(decryptedChars).trim();
    }

    public static void main(String[] args) {
        String originalText = "ПРИЕЗЖАЮ ШЕСТОГО";
        String encrypted = encrypt(originalText);
        String decrypted = decrypt(encrypted);

        System.out.println("Оригинальный текст: " + originalText);
        System.out.println("Зашифрованный текст: " + encrypted);
        System.out.println("Расшифрованный текст: " + decrypted);
    }
}
