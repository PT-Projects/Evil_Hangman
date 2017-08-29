import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    Scanner in;

    Dictionary dictionary;

    ArrayList<String> DictionaryList;

    int wordLength;

    public Game() {

        in = new Scanner(System.in);

        dictionary = new Dictionary();

        DictionaryList = dictionary.getDictionaryList();

        getUserLength();

    }

    private void getUserLength(){

        System.out.println("Input Word Length: ");

        try {
            wordLength = in.nextInt();
        }
        catch (Exception e){

        }

    }

}
