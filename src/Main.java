import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello! Welcome to the game of Hangman!\n");

        boolean keepPlaying = true;

        //Create these in main, we don't need to create a new dictionary or game each time we play
        //Another way to do this is to have the play method create a new WordList each time, but
        // use the singleton pattern to just keep reusing the already intialized Wordlist.

        HangmanGame hangmanGame = new HangmanGame();
        WordList wordList  = new WordList();
        Scanner scanner = new Scanner(System.in);

        while (keepPlaying){
            play(hangmanGame, wordList.getWordToGuess(),scanner);
            keepPlaying = playAnother(scanner);
        }

        scanner.close();

        System.out.println("Thank you for playing Hangman!");

    }

    private static boolean playAnother(Scanner scanner) {
        //Prompt the User
        System.out.println("Would you like to play another round?");
        System.out.println("Type \"yes\" to play again or \"no\" to stop");

        //get the next input
        String answer = scanner.next();

        //if the users answer is not of the specified type, then let them know and call playAnother again;
        if(!answer.equals("yes") && !answer.equals("no")){
            System.out.println("Invalid Input");
            return playAnother(scanner);
        } else return answer.equals("yes");
    }

    private static void play(HangmanGame hangmanGame, String wordToGuess, Scanner scanner) {
        //Create the class that handles game logic, and start a new game
        hangmanGame.startGame(wordToGuess);

        //Get a string that represents the correct guesses that the user has made so far
        //here it will be a string filled with "_"
        String userGuess = hangmanGame.getUserGuess();

        //Begin reading the input and checking to see if it exists in the word they are guessing
        while (!userGuess.equals(wordToGuess)){
            //Ouptut the total number of guesses they have made;
            System.out.println("You have made " + hangmanGame.getTotalGuess() + " guesses");
            System.out.println("Please make your guess");

            //get the next guess from the user
            String guess = scanner.next();

            //if more than one letter is given, take the first letter
            userGuess = hangmanGame.checkUserGuess(guess.charAt(0));

            //print out the current guess progress
            System.out.println(hangmanGame.getUserGuess() + "\n");
        }

        victoryMessage(hangmanGame, wordToGuess);
    }

    private static void victoryMessage(HangmanGame hangmanGame, String wordToGuess) {
        System.out.println("You guessed correct, the word was: " + wordToGuess);
        System.out.println("You made " + hangmanGame.getTotalGuess() + " total guesses");
        System.out.println("Correct: " + hangmanGame.getTotalCorrectGuesses());
        System.out.println("Incorrect: " + hangmanGame.getTotalIncorrectGuesses());
        System.out.println();
    }
}