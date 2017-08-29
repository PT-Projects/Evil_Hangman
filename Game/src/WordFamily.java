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

    private String getIdentity(Character letter, String word){

        int x = 0;

        String identity = "";


        while (x < word.length()) {

            String s = word.substring(x, x + 1);

            if (s.equals(letter.toString())) {
                identity += letter;
            } else {
                identity += '-';
            }
            x++;
        }
        return identity;
    }

    public ArrayList<String> identifyWords(Character letter){

        ArrayList<String> list = new ArrayList<>();

        for (String word : familyList){
            String identity = getIdentity(letter,word);

            list.add(identity);
        }

        return list;
    }

    public ArrayList<String> getFamilyList(){
        return familyList;
    }

}
