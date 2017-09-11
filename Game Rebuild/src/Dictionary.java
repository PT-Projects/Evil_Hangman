import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {

    ArrayList<String> DictionaryList = new ArrayList<>();

    public Dictionary(){
        readDictionary();
    }

    /**
     * Get words from dictionary.txt
     */
    private void readDictionary(){

        //Directory will need to change upon computer change
        File dictionary = new File("/Users/oliverscotten/IdeaProjects/Evil_Hangman/Game/src/dictionary.txt");

        Scanner in = null;
        try {
            in = new Scanner(dictionary);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Read all lines from the file
        while(in.hasNextLine()) {

            String line = in.nextLine();

            DictionaryList.add(line);

        }

    }

    /**
     * Get dictionary in list form
     * @return DictionaryList
     */
    public ArrayList<String> getDictionaryList() {
        return DictionaryList;
    }

    /**
     * Get number of words with length
     * @param length
     * @return numWords
     */
    public int getWords(int length){

        int numWords = 0;

        for (String word : DictionaryList){
            if (word.length() == length){
                numWords++;
            }
        }

        return numWords;

    }

}
