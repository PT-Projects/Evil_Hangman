import java.util.ArrayList;

public class Object_Driver {

    public static void main(String[] args) {

        Dictionary d = new Dictionary();

        ArrayList<String> list = d.getDictionaryList();

//        for (String word : list){
//            System.out.println(word);
//        }
//
//        System.out.println(d.getWords(4));

        WordFamily wf = new WordFamily(list,4);

//        ArrayList<String> wflist = wf.getFamilyList();
//
//        for (String word : wflist){
//            System.out.println(word);
//        }

        SpecificFamily sf = new SpecificFamily(wf,'e');

        System.out.println(sf.getIDENTITY());

    }

}
