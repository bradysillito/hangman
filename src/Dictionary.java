import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Dictionary {
    private List<String> words;
    private String currentWord;
    private final String FILE_PATH = "/Users/bradysillito/Desktop/Misc Files/Hangman/src/dictionary.txt";

    //Dictionary initializes class variables and fills itself with words from a textFile;

    public Dictionary() {
        words = new ArrayList<>();

        try {
            fillDictionary();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Something went wrong when filling the dictionary");
        }
    }

    private void fillDictionary() throws FileNotFoundException {
        File file = new File(FILE_PATH);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()){
            words.add(scanner.next());
        }

        scanner.close();
    }

    public String getWordToGuess(){
        this.currentWord = words.get(new Random().nextInt(0, words.size()));
        return currentWord;
    }


}
