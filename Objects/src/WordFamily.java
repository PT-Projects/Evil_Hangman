import java.lang.reflect.Array;
import java.util.ArrayList;

public class WordFamily {

    private ArrayList<String> familyList;

    public WordFamily(ArrayList<String> wordList, int wordLength){
        familyList = wordList;
        removeSize(wordLength);
    }

    /**
     * Removes all words not matching length
     * @param length
     */
    private void removeSize(int length){

        ArrayList<String> removeWords = new ArrayList<>();

        for (String word : familyList){
            if (word.length() != length){
                removeWords.add(word);
            }
        }

        for (String word : removeWords){
            familyList.remove(word);
        }
    }

    private String identity(Character letter, String word){

        int x = 0;

        String identify = "";


        while (x < word.length()) {

            String s = word.substring(x, x + 1);

            if (s.equals(letter.toString())) {
                identify += letter;
            } else {
                identify += '-';
            }
            x++;
        }
        return identify;
    }

    public ArrayList<String> identifyWords(Character letter){

        ArrayList<String> list = new ArrayList<>();

        for (String word : familyList){
            String identify = identity(letter,word);

            list.add(identify);
        }

        return list;
    }

    public ArrayList getFamilyList(){
        return familyList;
    }

}
