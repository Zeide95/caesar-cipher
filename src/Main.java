import java.util.*;

public class Main {
    static char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("1. Encryption\n" + "2. Decryption\n" + "Choose option: ");
        int choice = input.nextInt();
        input.nextLine();

        if(choice == 1) {
            encrypt();
        }
        else if(choice == 2) {
            decrypt();
        }
        else {
            System.out.println("Incorrect input.");
        }
    }

    static void encrypt() {
        System.out.print("Enter number between 1 and 25 for shift value: ");
        int num = input.nextInt();
        if (num < 1 || num > 25) {
            System.out.println("Incorrect input.");
            return;
        }
        input.nextLine();

        System.out.print("Enter text to encrypt: ");
        String text = input.nextLine();
        char[] letter = text.toUpperCase().toCharArray();

        for(int i = 0; i < letter.length; i++) {
            for(int j = 0; j < alphabet.length; j++) {
                if(letter[i] == alphabet[j]) {
                    letter[i] = (char)('A' + (j + num) % 26);
                    break;
                }
            }
        }

        for(int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if(Character.isLowerCase(ch)) {
                letter[i] = Character.toLowerCase(letter[i]);
            }
        }

        for(char c : letter) { System.out.print(c); }
    }

    static void decrypt() {
        System.out.print("Enter number between 1 and 25 for shift value: ");
        int num = input.nextInt();
        if (num < 1 || num > 25) {
            System.out.println("Incorrect input.");
            return;
        }
        input.nextLine();

        System.out.print("Enter text to decrypt: ");
        String text = input.nextLine();
        char[] letter = text.toUpperCase().toCharArray();

        for(int i = 0; i < letter.length; i++) {
            for(int j = 0; j < alphabet.length; j++) {
                if(letter[i] == alphabet[j]) {
                    letter[i] = (char)('A' + (j - num + 26) % 26);
                    break;
                }
            }
        }

        for(int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if(Character.isLowerCase(ch)) {
                letter[i] = Character.toLowerCase(letter[i]);
            }
        }

        for(char c : letter) { System.out.print(c); }
    }
}