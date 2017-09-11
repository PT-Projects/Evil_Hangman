import java.util.ArrayList;

public class Family {

    private String code;
    private ArrayList<String> wordList;

    public Family(String id, String word){
        code = id;
        wordList = new ArrayList<>();
        wordList.add(word);
    }

    public void addWord(String word){
        wordList.add(word);
    }

    public String getCode(){
        return code;
    }

    public int getSize(){
        return wordList.size();
    }

    public ArrayList<String> getWordList() {
        return wordList;
    }
}
