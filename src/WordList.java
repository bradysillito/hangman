import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordList {
    private List<String> words;
    private String currentWord;
    private final String FILE_PATH = "/Users/bradysillito/Desktop/Misc Files/Hangman/src/dictionary.txt";

    //Dictionary initializes class variables and fills itself with words from a textFile;

    public WordList() {
        words = new ArrayList<>();

        //fill the array with words from the file
        try {
            fillDictionary();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Something went wrong when filling the dictionary");
        }
    }

    /**
     * Fills the List with words from a specified file
     * @throws FileNotFoundException
     */
    private void fillDictionary() throws FileNotFoundException {
        //Specify file path
        File file = new File(FILE_PATH);
        Scanner scanner = new Scanner(file);

        // read from file
        while (scanner.hasNext()){
            words.add(scanner.next());
        }

        //close scanner
        scanner.close();
    }

    /**
     * Chooses a random word from its list of words and returns it
     * @return random word
     */
    public String getWordToGuess(){
        this.currentWord = words.get(new Random().nextInt(0, words.size()));
        return currentWord;
    }


}
