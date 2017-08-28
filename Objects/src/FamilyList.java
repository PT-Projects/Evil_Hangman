import java.util.ArrayList;

public class FamilyList {

    private ArrayList<SpecificFamily> SpecificFamilyList;

    public FamilyList(){
        SpecificFamilyList = new ArrayList<>();
    }

    public void addFamily(SpecificFamily sf){

        String IDENTITY = sf.getIDENTITY();
        boolean check = checkIDENTITY(IDENTITY);

        if (check){
            addFamily(sf.getWordList(),IDENTITY);
        }
        else{
            SpecificFamilyList.add(sf);
        }

    }

    private void addFamily(ArrayList<String> wordList, String code){

        for (SpecificFamily sf : SpecificFamilyList){
            if (sf.getIDENTITY().equals(code)){
                sf.addWords(wordList,code);
            }
        }

    }

    private boolean checkIDENTITY(String code){

        for (SpecificFamily sf : SpecificFamilyList){
            if (sf.getIDENTITY().equals(code)){
                return true;
            }
        }

        return false;

    }

    public ArrayList<SpecificFamily> getSpecificFamilyList() {
        return SpecificFamilyList;
    }

    public SpecificFamily getLargestFamily(){

        int biggest = 0;

        for (SpecificFamily sf : SpecificFamilyList){
            if (sf.getListSize() > biggest){
                biggest = sf.getListSize();
            }
        }

        int x = 0;

        while (biggest != SpecificFamilyList.get(x).getListSize()){
            x++;
        }

        return SpecificFamilyList.get(x);

    }
}
