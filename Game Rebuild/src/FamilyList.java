import java.util.ArrayList;

public class FamilyList {

    private ArrayList<Family> familyList;

    public FamilyList(){
        familyList = new ArrayList<>();
    }

    public void addFamily(String word, char letter){

        String code = "";

        boolean done = false;

        for (int x = 0; x < word.length(); x++){
            System.out.print("loop1");
            if (word.charAt(x) == letter || word.charAt(x)!='-'){
                code += word.charAt(x);
            }
            else{
                code += "-";
            }
        }

        for (Family f: familyList){
            System.out.print("loop2");
            if (code.equals(f.getCode())){
                f.addWord(word);
                done = true;
            }
        }

        if (!done){
            System.out.println("boolean");
            familyList.add(new Family(code,word));
        }
    }

    public Family getLargestFamily(){
        int size = 0;

        Family LargestFamily = familyList.get(0);

        for (Family fam: familyList){
            if (fam.getSize() > size){
                size = fam.getSize();
                LargestFamily = fam;
            }
        }

        return LargestFamily;

    }

}
