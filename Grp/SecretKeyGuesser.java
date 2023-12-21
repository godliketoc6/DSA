public class SecretKeyGuesser {

    /**
     * Runs a guessing algorithm to find the secret key.
     */

    public void start() {
        char[] possible = { 'M', 'O', 'C', 'H', 'A' }; // Define the possible characters for the secret key
        int index = 1; // Initialize the index for replacing characters in the current guess
        SecretKey key = new SecretKey(); // Create an instance of the SecretKey class
        String currentGuess = "MMMMMMMMMMMM"; // Initialize the current guess
        int match = key.guess(currentGuess); // Make a guess and get the number of characters that match the secret key
        int oldMatch = match; // Store the initial number of matching characters

        printResult(match, currentGuess); // Call the checkGuess method

        char[] currentGuessArray = currentGuess.toCharArray(); // Convert the current guess string to a character array

        int i = 0; // Initialize the loop counter
        while (i < currentGuess.length()) { // Loop until all characters in the current guess have been checked
            char currentChar = currentGuess.charAt(i); // Get the current character at index i

            replaceChar(currentGuessArray, possible, i, index); // Replace the current character with a possible
                                                                // character at index i and index value

            currentGuess = String.valueOf(currentGuessArray); // Convert the character array back to a string

            match = key.guess(currentGuess); // Make a guess with the updated current guess

            System.out.println("Guessing: " + currentGuess); // Print the current guess

            if (match == 12) { // If all characters match the secret key
                System.out.println("I found the secret key, it's: " + currentGuess); // Print the secret key
                break; // Exit the loop
            }

            if (match > oldMatch) { // If the number of matching characters has increased
                oldMatch = match; // Update the old match value
                i++; // Move to the next character
            } else if (match < oldMatch) { // If the number of matching characters has decreased
                currentGuessArray[i] = currentChar; // Restore the original character at index i
                i++; // Move to the next character
            } else { // If the number of matching characters has remained the same
                if (index < 4) { // If the index value is less than 4
                    index++; // Increment the index value
                } else { // If the index value is equal to 4
                    index = 1; // Reset the index value to 1
                }
                replaceChar(currentGuessArray, possible, i, index); // Replace the current character with a possible
                                                                    // character at index i and updated index value
            }
        }
    }

    /**
     * Replaces a character in the replaceCharHere array with a character from the
     * takeCharFromHere array.
     * 
     * @param replaceCharHere  - The array in which the character needs to be
     *                         replaced.
     * @param takeCharFromHere - The array from which the replacement character
     *                         needs to be taken.
     * @param i                - The index of the character to be replaced in the
     *                         replaceCharHere array.
     * @param i2               - The index of the character to be taken from the
     *                         takeCharFromHere array.
     */
    public void replaceChar(char[] replaceCharHere, char[] takeCharFromHere, int i, int i2) {
        // Check if i2 is greater than 4
        if (i2 > 4) {
            // If i2 is greater than 4, set it to 1
            i2 = 1;
        }
        // Replace the character at index i in the replaceCharHere array with the
        // character at index i2 in the takeCharFromHere array
        replaceCharHere[i] = takeCharFromHere[i2];
    }

    /**
     * Checks if the match value equals 12.
     * If match is 12, prints the secret key.
     *
     * @param currentGuess the current guess
     * @param match        the match value
     */
    public void checkMatch(String currentGuess, int match) {
        if (match == 12) {
            System.out.println("I found the secret key! It's: " + currentGuess);
        }
    }

    /**
     * This function checks the guess made by the user against a secret key.
     * If the guess is invalid, it prints an error message.
     * If all characters in the guess match the secret key, it prints the secret
     * key.
     * 
     * @param match        The number of characters that match the secret key.
     * @param currentGuess The current guess made by the user.
     */
    public static void printResult(int match, String currentGuess) {
        // Check if the guess is invalid
        System.out.println(match == -1 ? "Invalid key! Please enter a correct key with 12 letters!" :
        // Check if all characters match the secret key
                (match == 12 ? "I found the secret key, it's: " + currentGuess : ""));
    }
}
