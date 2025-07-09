import java.util.Scanner;

public class CaesarCipher {

    // Encrypt method
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (Character.isUpperCase(character)) {
                char ch = (char)(((character - 'A' + shift) % 26) + 'A');
                result.append(ch);
            } else if (Character.isLowerCase(character)) {
                char ch = (char)(((character - 'a' + shift) % 26) + 'a');
                result.append(ch);
            } else {
                result.append(character); // Keep punctuation and spaces unchanged
            }
        }
        return result.toString();
    }

    // Decrypt method
    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - (shift % 26)); // Reverse shift
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Caesar Cipher ===");
        System.out.print("Enter your message: ");
        String message = scanner.nextLine();

        System.out.print("Enter shift value (0-25): ");
        int shift = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Do you want to Encrypt or Decrypt (E/D)? ");
        String choice = scanner.nextLine().trim().toUpperCase();

        String result;
        if (choice.equals("E")) {
            result = encrypt(message, shift);
            System.out.println("Encrypted Message: " + result);
        } else if (choice.equals("D")) {
            result = decrypt(message, shift);
            System.out.println("Decrypted Message: " + result);
        } else {
            System.out.println("Invalid choice. Please enter E or D.");
        }

        scanner.close();
    }
}