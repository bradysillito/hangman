import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello! Welcome to the game of Hangman!");


        Dictionary dictionary = new Dictionary();
        String wordToGuess = dictionary.getWordToGuess();
        System.out.println(wordToGuess);

        //Create the class that handles game logic, and start a new game
        HangmanGame hangmanGame = new HangmanGame(wordToGuess);
        hangmanGame.startGame();

        //Create a scanner to read items from the console;
        Scanner scanner = new Scanner(System.in);

        //Get a string that represents the correct guesses that the user has made so far
        //here it will be a string filled with "_"
        String userGuess = hangmanGame.getUserGuess();

        //Begin reading the input and checking to see if it exists in the word they are guessing
        while (!userGuess.equals(wordToGuess)){
            String guess = scanner.next();
            //if more than one letter is given, take the first letter
            userGuess = hangmanGame.checkUserGuess(guess.charAt(0));
            System.out.println(hangmanGame.getUserGuess());

        }



    }

}