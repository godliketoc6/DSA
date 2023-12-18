public class SecretKeyGuesser {

    /**
     * Runs a guessing algorithm to find the secret key.
     */
    
    public void start() {
        // Create a new instance of the SecretKey class
        SecretKey key = new SecretKey();

        // Initialize the current guess with all 'M' characters
        String currentGuess = "MMMMMMMMMMMM";

        // Perform the initial guess and store the match score
        int match = key.guess(currentGuess);

        // Store the initial match score in a separate variable for comparison
        int newMatch = match;

        // Define the characters that can be used for guessing
        final char[] possibleCharacters = { 'M', 'O', 'C', 'H', 'A' };

        // Initialize the index for replacing characters in the guess
        int index = 1;

        // Define the maximum index value and the length of the guess
        final int MAX_INDEX = 4;
        final int GUESS_LENGTH = 12;

        // Convert the current guess to a char array for easier manipulation
        char[] currentGuessArray = currentGuess.toCharArray();

        // Iterate through each character in the current guess
        int i = 0;
        while (i < currentGuess.length()) {
            // Store the previous character to restore it if needed
            char previousChar = currentGuessArray[i];

            // Replace the character at index i with the next possible character
            replaceChar(currentGuessArray, possibleCharacters, i, index);

            // Update the current guess with the modified array using StringBuilder
            StringBuilder builder = new StringBuilder();
            builder.append(currentGuessArray);
            currentGuess = builder.toString();

            // Check the match score of the new guess
            match = key.guess(currentGuess);

            // If the guess is correct, print the secret key and exit the loop
            if (match == GUESS_LENGTH) {
                System.out.println("I found the secret key, it is: " + currentGuess);
                break;
            }

            // If the match score improves, move to the next character
            if (match > newMatch) {
                newMatch = match;
                i++;
            }
            // If the match score decreases, restore the previous character and move to the
            // next character
            else if (match < newMatch) {
                currentGuessArray[i] = previousChar;
                i++;
            }
            // If the match score remains the same, try the next possible character
            else {
                if (index <= MAX_INDEX) {
                    index++;
                } else {
                    index = 1;
                }
                replaceChar(currentGuessArray, possibleCharacters, i, index);
            }
        }
    }

    /**
     * Replaces the character at the specified index in the guess array with the
     * character at the specified index in the possible characters array.
     *
     * @param guessArray         the guess array
     * @param possibleCharacters the possible characters array
     * @param guessIndex         the index in the guess array
     * @param charIndex          the index in the possible characters array
     */
    private void replaceChar(char[] guessArray, char[] possibleCharacters, int guessIndex, int charIndex) {
        guessArray[guessIndex] = possibleCharacters[charIndex - 1];
    }
}