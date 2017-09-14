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

    public Game() {

        in = new Scanner(System.in);

        dictionary = new Dictionary();

        dictionaryList = dictionary.getDictionaryList();

    }

    public void START(){

        getUserLength();

        getGuess();

        runningTotal();

        RUN();

        playAgain(getPlayAgain());

    }

    private void FINISH(){
        System.out.println("GAME OVER: SHUTTING DOWN");
    }

    private void playAgain(boolean check){
        if (check){
            START();
            System.out.println("-----------------------------");
        }
        else{
            FINISH();
        }
    }

    private boolean getPlayAgain(){

        boolean clear = true;

        boolean finish = false;

        String check = "";

        System.out.print("Play Again (Y,N): ");

        try {
            check = in.next();
            check = check.toUpperCase();
        } catch (Exception e) {
            inputError();
            in.nextLine();
            clear = false;
        }

        if (!clear) {
            getPlayAgain();
        }

        else if (check.equals("Y") || check.equals("N")){
            if (check.equals("Y")){
                finish = true;
            }
            else if (check.equals("N")){
                finish = false;
            }
            else{
                logicError();
                getPlayAgain();
            }
        }

        else{
            logicError();
            getPlayAgain();
        }

        return finish;

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
            getCharacterGuess();
        }

        else if (character.length() == 0 || character.length() > 1){
            logicError();
            getCharacterGuess();
        }

        return character.charAt(0);
    }

    /**
     * Method found on Internet
     * @param codeList
     * @return
     */
    private String mostCommon(ArrayList<String> codeList){

        Map<String, Integer> map = new HashMap<String, Integer>();

        for(int i=0; i< codeList.size(); i++) {

            Integer frequency = map.get(codeList.get(i));
            if(frequency == null) {
                map.put(codeList.get(i), 1);
            } else {
                map.put(codeList.get(i), frequency+1);
            }
        }

        String mostCommonKey = null;
        int maxValue = -1;
        for(Map.Entry<String, Integer> entry: map.entrySet()) {

            if(entry.getValue() > maxValue) {
                mostCommonKey = entry.getKey();
                maxValue = entry.getValue();
            }
        }

        return mostCommonKey;

    }

    private void RUN(){

        Character c;

        WordFamily wf = new WordFamily(dictionaryList,wordLength);

        SpecificFamily sf;

        while (PLAY) {

            System.out.println("-----------------------------");

            remainingGuesses --;

            c = getCharacterGuess();

            mostCommon(wf.identifyWords(c));

            sf = new SpecificFamily(wf,wf.identifyWords(c),mostCommon(wf.identifyWords(c)));

            wf.setWordList(sf.getWordList());

            System.out.println("Word: " + sf.getIDENTITY());

            System.out.println("Remaining Guesses: " + remainingGuesses);

            if (runningTotal){
                System.out.println("Number of Words Remaining: " + sf.getWordList().size());
            }

            if (remainingGuesses == 0){
                PLAY = false;
            }

        }

        if (!PLAY){
            System.out.println("Game Over");
            System.out.println("-----------------------------");
        }

    }

    private void inputError(){
        System.out.println("Input Error");
    }

    private void logicError(){
        System.out.println("Logic Error");
    }

}
