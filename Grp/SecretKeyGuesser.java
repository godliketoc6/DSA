public class SecretKeyGuesser {
public void start() {
    char[] possible = { 'M', 'O', 'C', 'H', 'A' };
    int index = 1;
    SecretKey key = new SecretKey();
    String currentGuess = "MMMMMMMMMMMM";

    // Make an initial guess and store the number of matches
    int match = key.guess(currentGuess); //1

    // Store the initial number of matches for reference
    int oldMatch = match;

    // Initialize the loop counter
    int i = 0;

    // Perform the initial check for the current guess
    checkMatch(currentGuess, match, key);

    // Convert the current guess string to a character array
    char[] currentGuessArray = currentGuess.toCharArray();

    // Continue guessing until all characters have been checked
    while (i < currentGuess.length()) {
        // Get the current character at the specified index
        char currentChar = currentGuess.charAt(i);

        // Replace the character at the specified index with the next possible character
        replaceChar(currentGuessArray, possible, i, index);

        // Update the current guess string with the modified character array
        currentGuess = String.valueOf(currentGuessArray);

        // Print the current guess for feedback
        System.out.println("Guessing... " + currentGuess);

        // Make a guess with the updated current guess and store the number of matches
        match = key.guess(currentGuess);

        // Restore the original character at the specified index
        replaceChar(currentGuessArray, possible, i, index);

        // Perform a check for the current guess
        checkMatch(currentGuess, match, key);

        // Compare the number of matches with the previous number of matches
        if (match > oldMatch) {
            // If the number of matches has increased, move to the next character
            oldMatch = match;
            i++;
        } else if (match < oldMatch) {
            // If the number of matches has decreased, restore the original character and move to the next character
            currentGuessArray[i] = currentChar;
            i++;
        } else {
            // If the number of matches is the same, increment the index for replacing characters
            if (index < 4) {
                index++;
            } else {
                // Reset the index if it reaches the maximum possible value
                index = 1;
            }
        }
    }
}

    // Function to replace a character in an array
    private void replaceChar(char[] replaceCharHere, char[] takeCharFromHere, int i, int i2) {
        // Assign the character from takeCharFromHere at index i2 to the replaceCharHere
        // array at index i
        replaceCharHere[i] = takeCharFromHere[i2];
    }

    // Function handle matching characters at the beginning
    private void checkMatch(String currentGuess, int match, SecretKey key) {
        int count_length = 0;

        // If all characters match, print the secret key and exit
        if (match == 12) {
            System.out.println("I found the secret key! It's: " + currentGuess);
            System.exit(0);
        }

        // If no characters match, try a few predefined guesses
        if (match == 0) {
            String[] guesses = { "OOOOOOOOOOOO", "CCCCCCCCCCCC", "HHHHHHHHHHHH", "AAAAAAAAAAAA" };
            int local_match = 0, total_match = 0;

            // Iterate through each predefined guess
            for (String x : guesses) {
                count_length++;

                // Check how many characters match with the secret key
                local_match = key.guess(x); //2
                total_match += total_match;

                // If all characters match, print the secret key and exit
                if (local_match == 12) {
                    System.out.println("I found the secret key, its: " + x);
                    System.exit(0);
                }

                // If all predefined guesses have been checked and none match, print an error
                // message and exit
                if (count_length == 4) {
                    System.out.println("Error with secret key!");
                    System.exit(0);
                }
            }
        }

        // If some characters match, print an error message and exit
        if (match < 0) {
            System.out.println("Secret key has insufficient/wrong characters!");
            System.exit(0);
        }
    }
}