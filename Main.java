package CipherDecipher;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CipherDecipher cipherDecipher = new CipherDecipher("");
        boolean continueLoop = true; // Determines if the program should continue looping

        while (continueLoop) {
            System.out.println("1. Cipher");
            System.out.println("2. Decipher");
            System.out.println("3. Exit");
            System.out.println("Choose your option: ");

            int option = input.nextInt();
            input.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    System.out.println("Enter your text to cipher: ");
                    String inputString = input.nextLine();
                    cipherDecipher.setInputString(inputString);
                    if (!cipherDecipher.cipherString()) { // If cipherString() returns false then the inputString is invalid
                        System.out.println("Ciphered Text: \nInvalid Text!");
                        continueLoop = false;
                    } else {
                        System.out.println("Ciphered Text: " + cipherDecipher.getCipheredString());
                    }
                    break;
                case 2:
                    if (cipherDecipher.getCipheredString().length() == 0) { // If cipheredString is empty then Decipher cannot be done
                        System.out.println("Ciphered Text: \nNo Ciphered Text Found!");
                        System.out.println("Deciphered Text: \nInvalid!");
                        continueLoop = false;
                    } else {
                        cipherDecipher.decipherString();
                        if (cipherDecipher.getDecipheredString().length() == 0) { // If decipheredString is empty then the cipheredString is invalid
                            System.out.println("Invalid!");
                        } else {
                            System.out.println("Deciphered Text: " + cipherDecipher.getDecipheredString());
                        }
                    }
                    break;
                case 3:
                    continueLoop = false;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}