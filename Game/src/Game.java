import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    Scanner in;

    Dictionary dictionary;

//    ArrayList<String> DictionaryList;

    int wordLength = 0;

    int remainingGuesses = 0;

    boolean runningTotal = false;

    boolean play = true;

    public Game() {

        in = new Scanner(System.in);

        dictionary = new Dictionary();

//        DictionaryList = dictionary.getDictionaryList();

    }

    public void START(){

        getUserLength();

        getGuess();

        runningTotal();

        RUN();

    }

    private void getUserLength() {

        boolean clear = true;

        System.out.print("Input Word Length: ");

        try {
            wordLength = in.nextInt();
        } catch (Exception e) {
            inputError();
            in.nextLine();
            clear = false;
        }

        if (!clear) {
            getUserLength();
        }

        else if (dictionary.getWords(wordLength) == 0){
            logicError();
            getUserLength();
        }

    }

    private void getGuess(){

        boolean clear = true;

        System.out.print("Input Number of Guesses: ");

        try {
            remainingGuesses = in.nextInt();
        } catch (Exception e) {
            inputError();
            in.nextLine();
            clear = false;
        }

        if (!clear) {
            getGuess();
        }

        else if (remainingGuesses <= 0){
            logicError();
            getGuess();
        }

    }

    private void runningTotal(){

        boolean clear = true;

        String check = "";

        System.out.print("Number of Words Remaining (Y,N): ");

        try {
            check = in.next();
            check = check.toUpperCase();
        } catch (Exception e) {
            inputError();
            in.nextLine();
            clear = false;
        }

        if (!clear) {
            runningTotal();
        }

        else if (check.equals("Y") || check.equals("N")){
            if (check.equals("Y")){
                runningTotal = true;
            }
            else if (check.equals("N")){
                runningTotal = false;
            }
            else{
                logicError();
                runningTotal();
            }
        }

        else{
            logicError();
            runningTotal();
        }

    }

    private String getCharacterGuess(){

        boolean clear = true;

        String character = "";

        System.out.print("Input Character Guess: ");

        try {
            character = in.next();
        } catch (Exception e) {
            inputError();
            in.nextLine();
            clear = false;
        }

        if (!clear) {
            getCharacterGuess();
        }

        else if (character.length() == 0 || character.length() > 1){
            logicError();
            getCharacterGuess();
        }

        return character;
    }

    private void RUN(){

        WordFamily wf = new WordFamily(dictionary.getDictionaryList(),wordLength);

        Character c = getCharacterGuess().charAt(0);

        ArrayList<String> wfI = wf.identifyWords(c);

        SpecificFamily sf = new SpecificFamily(wf,wfI,)

    }

    private void inputError(){
        System.out.println("Input Error");
    }

    private void logicError(){
        System.out.println("Logic Error");
    }

}
