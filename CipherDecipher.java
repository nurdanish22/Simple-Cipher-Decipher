package CipherDecipher;

public class CipherDecipher {
    private String inputString;
    private StringBuilder cipheredString;
    private StringBuilder decipheredString;

    public CipherDecipher(String inputString) {
        this.inputString = inputString;
        this.cipheredString = new StringBuilder();
        this.decipheredString = new StringBuilder();
    }

    public boolean cipherString() {
        cipheredString.setLength(0); // Clear cipheredString

        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if (Character.isLetter(c) || c == ' ') { // Only letters and spaces are allowed
                if (Character.isUpperCase(c)) {
                    cipheredString.append((char) ('A' + (c - 'A' + 1) % 26)); // Shift 1 to the right
                } else if (Character.isLowerCase(c)) {
                    cipheredString.append((char) ('a' + (c - 'a' + 1) % 26)); // Shift 1 to the right
                } else if (c == ' ') {
                    cipheredString.append(c);
                }
            } else {
                return false; // If the inputString is invalid then return false
            }
        }
        return true; // If the inputString is valid then return true
    }

    public void decipherString() {
    decipheredString.setLength(0); // Clear decipheredString
    
    if (cipheredString.length() == 0) { // If cipheredString is empty then return nothing
        System.out.println("No Ciphered Text Found!");
        return;
    }

    for (int i = 0; i < cipheredString.length(); i++) {
        char c = cipheredString.charAt(i);
        if (Character.isLetter(c)) {
            if (Character.isUpperCase(c)) {
                decipheredString.append((char) ('A' + (c - 'A' - 1 + 26) % 26)); // Shift 1 to the left
            } else {
                decipheredString.append((char) ('a' + (c - 'a' - 1 + 26) % 26)); // Shift 1 to the left
            }
        } else if (c == ' ') {
            decipheredString.append(c);
            }
        }
    }

    // getters and setters
    public String getInputString() {
        return inputString;
    }

    public StringBuilder getCipheredString() {
        return cipheredString;
    }

    public StringBuilder getDecipheredString() {
        return decipheredString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

}