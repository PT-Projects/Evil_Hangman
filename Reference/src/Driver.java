import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by rritz on 8/26/2014.
 */
public class Driver {

    public static void main(String[] args) {

        //create File object associated with the dictionary file
        File myFile = new File("Evil Hangman/dictionary.txt");

        //Create a Scanner associated to the above file
        Scanner in = null;
        try {
            in = new Scanner(myFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Read all lines from the file
        while(in.hasNextLine()) {

            String line = in.nextLine();

            System.out.println(line);

        }
    }
}
