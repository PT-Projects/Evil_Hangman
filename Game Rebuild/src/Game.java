import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {

    Scanner in;

    Dictionary dictionary;

    int wordLength = 0;

    int remainingGuesses = 0;

    ArrayList<String> dictionaryList;

    boolean runningTotal = false;

    boolean PLAY = true;

    String code;

    ArrayList<String> wordList;

    FamilyList familyList;

    public Game() {

        in = new Scanner(System.in);

        dictionary = new Dictionary();

        dictionaryList = dictionary.getDictionaryList();

        code = "";

        wordList = new ArrayList<>();

        familyList = new FamilyList();

    }

    public void START(){

        getUserLength();

        for (String word: dictionaryList){
            if (word.length() == wordLength){
                wordList.add(word);
            }
        }

        setCode();

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
            System.out.println("loop");
            getUserLength();
        }

        else if (dictionary.getWords(wordLength) == 0){
            System.out.println("loop");
            logicError();
            getUserLength();
        }

    }

    /**
     * Linnea's
     */
    private void setCode(){
        for (int x = 0; x < wordLength; x++){
            code += "-";
        }
    }

    /**
     * Linnea's
     * @param identity
     */
    private void compare(String identity){

        String newCode = "";

        for (int x = 0; x < identity.length(); x++){

            if (code.charAt(x) == '-' && identity.charAt(x) != '-'){
                newCode += identity.charAt(x);
            }
            else{
                newCode += code.charAt(x);
            }

        }

        code = newCode;

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
            System.out.println("loop");
            getGuess();
        }

        else if (remainingGuesses <= 0){
            System.out.println("loop");
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
            System.out.println("loop");
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
                System.out.println("loop");
                logicError();
                runningTotal();
            }
        }

        else{
            System.out.println("loop");
            logicError();
            runningTotal();
        }

    }

    private Character getCharacterGuess(){

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
            System.out.println("loop");
            getCharacterGuess();
        }

        else if (character.length() == 0 || character.length() > 1){
            System.out.println("loop");
            logicError();
            getCharacterGuess();
        }

        return character.charAt(0);
    }

    private void RUN(){

        Character c;

        while (PLAY){

            c = getCharacterGuess();
            System.out.println(wordList.size());


            for (int x = 0; x < wordList.size(); x++){
//                System.out.print("loop");
                String word = wordList.get(x);
                familyList.addFamily(word,c);
            }

            wordList = familyList.getLargestFamily().getWordList();

            code = familyList.getLargestFamily().getCode();

            System.out.println(code);

            System.out.println(wordList);

            System.out.println("LOOP");

        }

    }

    private void inputError(){
        System.out.println("Input Error");
    }

    private void logicError(){
        System.out.println("Logic Error");
    }

}
