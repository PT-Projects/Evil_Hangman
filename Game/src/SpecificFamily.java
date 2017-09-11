import java.util.ArrayList;

public class SpecificFamily{

    private ArrayList<String> familyList = new ArrayList<>();
    private String IDENTITY;

    public SpecificFamily(WordFamily family, String identityCode){

        IDENTITY = identityCode;

        Identity ID = new Identity(family.getFamilyList());

        sortList(family, ID.getIdentityList());

    }

    private void sortList(WordFamily family, ArrayList<String> codeList){

        ArrayList<String> list = family.getFamilyList();

        System.out.println(list.size());

        for (int x = 0; x < list.size(); x++){

            if (codeList.get(x).equals(IDENTITY)){

                familyList.add(list.get(x));
            }



//            if (code.equals(IDENTITY)){
//                familyList.add(list.get(x));
//            }

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
