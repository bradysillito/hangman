public class Main {
    public static void main(String[] args) {
        System.out.println("Hello! Welcome to the game of Hangman!");


        Dictionary dictionary = new Dictionary();
        String wordToGuess = dictionary.getWordToGuess();
        System.out.println(wordToGuess);

        playGame(wordToGuess);

    }

    private static void playGame(String wordToGuess) {
        System.out.println("The word to guess has " + wordToGuess.length() + " letters!");
    }
}