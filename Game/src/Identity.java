import java.util.ArrayList;

public class Identity {

    private ArrayList<String> list;

    public Identity(ArrayList<String> wordList){
        list = wordList;
    }

    public ArrayList<String> getIdentityList() {

        ArrayList<String> IdentityList = new ArrayList<>();

        for (String word: list){
            IdentityList.addAll(getIdentity(word));
        }

        return IdentityList;
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
