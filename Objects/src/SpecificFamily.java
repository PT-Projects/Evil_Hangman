import java.util.ArrayList;

public class SpecificFamily{

    private String IDENTITY = "";
    private ArrayList<String> wordList;
    private Character LETTER;

    public SpecificFamily(WordFamily family, Character letter){
        LETTER = letter;
        setWordList(family);


        for (String word : getWordList()){
            String text = setIDENTITY(word);
            IDENTITY += text + " ";
        }

    }

    private void setWordList(WordFamily family){
        wordList = family.getFamilyList();
    }

    private String setIDENTITY(String word){

        int x = 0;

        String identify = "";


            while (x < word.length()) {

                String s = word.substring(x, x + 1);

                if (s.equals(LETTER.toString())) {
                    identify += LETTER;
                } else {
                    identify += '-';
                }

                x++;
            }


        return identify;

    }

    public ArrayList<String> getWordList() {
        return wordList;
    }

    public String getIDENTITY(){
        return IDENTITY;
    }
}
