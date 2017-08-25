import java.util.ArrayList;

/**
 * Created by Linnea on 8/21/17.
 */
public class FamilyList {
    private ArrayList<Family> familyList;

    public FamilyList() {
        familyList = new ArrayList<>();
    }

    public void addFamily(Family f) {
        familyList.add(f);
    }

    public int getNumFamilies() {
        return familyList.size();
    }

    public Family getFamily(int index) {
        return familyList.get(index);
    }

    public Family getGreatestFamily() {
        int size = 0;
        Family family = familyList.get(0);
        for (Family f : familyList) {
            if (f.getSize() > size) {
                size = f.getSize();
                family = f;
            }
        }
        return family;
    }

    public void addToFamily(String word, char input) {
        String identifier = "";
        boolean done = false;
        for (int c=0; c<word.length(); c++) {
            if (word.charAt(c) == input)
                identifier += word.charAt(c);
            else
                identifier += "-";
        }
        for (Family f : familyList) {
            if (identifier.equals(f.getIdentifier())) {
                f.addWord(word);
                done = true;
            }
        }
        if (!done) {
            familyList.add(new Family(identifier,word));
        }
    }


}
