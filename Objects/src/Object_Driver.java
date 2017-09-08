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

//        WordFamily wf = new WordFamily(list,4);
//
//        System.out.println(wf.identifyWords('e'));

//        ArrayList<String> wflist = wf.getFamilyList();
//
//        for (String word : wflist){
//            System.out.println(word);
//        }

//        SpecificFamily sf = new SpecificFamily(wf,'e');
//
//        System.out.println(sf.getIDENTITY());

        WordFamily wf = new WordFamily(list, 4);

        ArrayList<String> identityList = wf.identifyWords('e');

//        String code = identityList.get(0);

//        String code = "-e--";
//        String code2 = "-ee-";
//
//        System.out.println("1: " + code);
//        System.out.println("2: " + code2);
//
//        SpecificFamily sf = new SpecificFamily(wf, identityList, code);
//        SpecificFamily sf2 = new SpecificFamily(wf, identityList, code2);
//
//        FamilyList fl = new FamilyList();
//
//        fl.addFamily(sf);
//        fl.addFamily(sf2);
//
//        ArrayList<SpecificFamily> sfList = fl.getSpecificFamilyList();
//
//        System.out.println(sfList.get(0).getIDENTITY());
//
//        System.out.println(sfList.get(1).getIDENTITY());
//
//        System.out.println(sfList.get(0).getWordList());
//
//        System.out.println(sfList.get(1).getWordList());
//
//        System.out.println(fl.getLargestFamily().getListSize());



    }

}
