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

    public ArrayList getFamilyList(){
        return familyList;
    }

}
