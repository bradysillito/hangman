public class HangmanGame {
    private String wordToGuess;

    private int totalGuess;

    private String userGuess;


    public void startGame(String wordToGuess) {
        this.totalGuess = 0;
        this.wordToGuess = wordToGuess;

        System.out.println("Let's play!");
        System.out.println("The word to guess has " + this.wordToGuess.length() + " letters!");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.wordToGuess.length(); i++) {
            sb.append("_");
        }

        this.userGuess = sb.toString();
        System.out.println(sb);
    }

    public String getUserGuess() {
        return userGuess;
    }

    public String checkUserGuess(char charAt) {
        //check if the char is a letter
        if(!Character.isLetter(charAt)){
            System.out.println("You can only guess letters");
            return userGuess;
        }

        //update the amount of guesses made
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
        guessOutput(correctGuess);

        //return the userGuess string (potentially updated)
        return userGuess;
    }

    //outputs whether the guess was correct

    private void guessOutput(boolean correctGuess) {
        System.out.println("Your guess was " + correctGuess);
    }
    public int getTotalGuess() {
        return totalGuess;
    }
}
