import java.util.ArrayList;

public class SpecificFamily{

    private ArrayList<String> familyList = new ArrayList<>();
    private String IDENTITY;

    public SpecificFamily(WordFamily family, ArrayList<String> IdentityList, String identityCode){

        IDENTITY = identityCode;

        sortList(family, IdentityList);

    }

    private void sortList(WordFamily family, ArrayList<String> codeList){

        ArrayList<String> list = family.getFamilyList();

        int x = 0;

        for (String code : codeList){
            if (code.equals(IDENTITY)){
                familyList.add(list.get(x));
            }
            x++;
        }
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
