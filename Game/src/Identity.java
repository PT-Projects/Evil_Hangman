import java.util.ArrayList;

public class Identity {

    private ArrayList<String> list;
    private String c;

    public Identity(ArrayList<String> wordList, Character letter){
        list = wordList;
        c = letter.toString();
    }

    public ArrayList<ArrayList> getReturnList() {

        ArrayList<String> IdentityList = new ArrayList<>();
        ArrayList<String> wordList = new ArrayList<>();

        ArrayList<ArrayList> returnList = new ArrayList<>();

        for (String word: list){
            if (!word.contains(c)){
                IdentityList.addAll(getIdentity(word));
                wordList.add(word);
            }
        }

        returnList.add(IdentityList);
        returnList.add(wordList);

        return returnList;
    }

    private ArrayList<String> getIdentity(String word){

        ArrayList<String> wordIdentity = new ArrayList<>();

        for (char alphabet = 'a'; alphabet <= 'z'; alphabet++){

            int x = 0;

            String identity = "";


            while (x < word.length()) {

                String s = word.substring(x, x + 1);

                char sChar = s.charAt(0);

                if (sChar == alphabet) {
                    identity += alphabet;
                } else {
                    identity += '-';
                }
                x++;
            }
            wordIdentity.add(identity);
        }

        return wordIdentity;

    }

}
