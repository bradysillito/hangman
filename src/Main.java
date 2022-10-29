public class Main {
    public static void main(String[] args) {
        System.out.println("Hello! Welcome to the game of Hangman!");


        Dictionary dictionary = new Dictionary();
        String wordToGuess = dictionary.getWordToGuess();
        System.out.println(wordToGuess);


    }
}