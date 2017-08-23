public class development {

    private String LETTER = "m";


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
}
