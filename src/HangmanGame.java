import java.util.ArrayList;
import java.util.List;

public class HangmanGame {
    private String wordToGuess;
    private int totalGuess;
    private String userGuess;
    private List<Character> correctGuesses;
    private List<Character> incorrectGuesses;


    /**
     * Starts the Game and creates a blank string for the user to guess from
     * @param wordToGuess
     */

    public void startGame(String wordToGuess) {
        resetGame(wordToGuess);

        System.out.println("Let's play!");
        System.out.println("The word to guess has " + this.wordToGuess.length() + " letters!");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.wordToGuess.length(); i++) {
            sb.append("_");
        }

        this.userGuess = sb.toString();
        System.out.println(sb);
    }


    /**
     * resets Hangman game for a new game to be played
     * @param wordToGuess the word the user will be trying to guess
     */
    private void resetGame(String wordToGuess) {
        this.totalGuess = 0;
        this.wordToGuess = wordToGuess;
        this.incorrectGuesses = new ArrayList<>();
        this.correctGuesses = new ArrayList<>();
    }

    public String getUserGuess() {
        return userGuess;
    }

    /**
     * Checks if the guess is correct and updates the userString accordingly
     * @param charAt user guesss
     * @return a string with correct guesses in the correct place
     */
    public String checkUserGuess(char charAt) {
        //check if the char is a letter
        if(!Character.isLetter(charAt)){
            System.out.println("You can only guess letters");
            return userGuess;
        }

        //update the amount of guesses made
        //Do this after checking if it is a letter, invalid guesses wont count
        this.totalGuess ++;

        boolean correctGuess = false;
        //check if the wordToGuess contains the user's guessed letter
        if(wordToGuess.contains(Character.toString(charAt))){
            //create a string builder out of the current user guess and replace any occurrence of the letter with the
            //user's guessed letter
            StringBuilder stringBuilder = new StringBuilder(userGuess);
            for (int i = 0; i < wordToGuess.length(); i++) {
                if(wordToGuess.charAt(i) == charAt){  // if the char exist replace it at that index
                    stringBuilder.setCharAt(i,charAt);
                }
            }

            // if the user guess and stringBuilder are not equal that means the user had a correct guess
            // update the  userGuess string and mark the current guess as correct
            if(!userGuess.equals(stringBuilder.toString())){
                userGuess = stringBuilder.toString();
                correctGuess = true;
            }
        }

        //output if the guess is correct or not
        guessOutput(correctGuess,charAt);

        //return the userGuess string (potentially updated)
        return userGuess;
    }

    /**
     * Creates response ouput for correct and incorrect guesses
     * @param guess a boolean indicating whether the guess was true
     * @param charAt a char, guess from the user
     */
    private void guessOutput(boolean guess, char charAt) {
        System.out.println("\nYour guess was " + guess);

        if(guess){
            this.correctGuesses.add(charAt);
            System.out.println("Correct Guesses: " + correctGuesses.toString());
        } else {
            this.incorrectGuesses.add(charAt);
            System.out.println(charAt + " is not in the word!");
            System.out.println("Incorrect Guesses: " + incorrectGuesses.toString());
        }

        //Output the correctness of their guess and how many correct and incorrect guesses they have made
        System.out.println("Correct Guesses: " + this.correctGuesses.size() + " Incorrect Guesses: " + this.incorrectGuesses.size());
    }
    public int getTotalGuess() {
        return totalGuess;
    }

    /**
     * gets the number of correct guesses
     * @return number of correct guess
     */
    public int getTotalCorrectGuesses() {
        return correctGuesses.size();
    }

    /**
     * gets the number of incorrect guesses
     * @return number of incorrect guess
     */
    public int getTotalIncorrectGuesses() {
        return incorrectGuesses.size();
    }
}
