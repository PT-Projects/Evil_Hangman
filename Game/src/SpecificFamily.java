import java.util.ArrayList;

public class SpecificFamily{

    private ArrayList<String> familyList = new ArrayList<>();
    private String IDENTITY;

    public SpecificFamily(WordFamily family, String identityCode, Character letter){

        IDENTITY = identityCode;

        sortList(family,identityCode,letter);

    }

    private void sortList(WordFamily family, String code, Character letter){

        for (String word : family.getFamilyList()){
            if (toID(word,letter).equals(code)){
                familyList.add(toID(word,letter));
            }
        }

    }

    private String toID(String word, Character letter){

        String identity = "";

        return identity;
    }

    public ArrayList<String> getWordList() {
        return familyList;
    }

    public String getIDENTITY(){
        return IDENTITY;
    }

    public void addWords(ArrayList<String> wordList, String code){
        if (IDENTITY.equals(code)){
            familyList.addAll(wordList);
        }
    }

    public int getListSize(){
        return familyList.size();
    }
}
