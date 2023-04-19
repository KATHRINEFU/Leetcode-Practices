package string;

/**
 * @ClassName MightyMorpher
 * @Description TODO
 * @Author katefu
 * @Date 9/11/22 6:59 PM
 * @Version 1.0
 **/
public class MightyMorpher {
    public static void main(String[] args) {
        String word = "ucliipt";
//        if(word.substring(0,2).equals("ii")){
//            word = word.replaceFirst("ii","e");
//        }
//        System.out.println(word);
        Morph result = Morpher.morph(word);
        if (result == null)
            System.out.println("morph returned null pointer");
        else if (result.pos.charAt(0) == 'C' || result.pos.charAt(0) == 'R')
            System.out.println(result.root+"+"+result.pos) ;
        else
            System.out.println(result.root+"+"+result.pos+"-"+result.tense+"-"+result.number+"-"+result.gender);
    }
}

class Morpher {
    public static Morph morph(String word) {
// WRITE YOUR CODE HERE
        if(word==null || word.length()<=0) return null;
        Morph m = new Morph();
        if(word.charAt(0)=='a'){
            if(word.length()>1 && word.charAt(1)=='a') m.pos = "C";
            else m.pos = "R";
            m.root = word;
            return m;
        }
        int rootStart = 0;
        boolean needPluralCheck = true;
        //pos = n, v, adj, adv, pn
        checkPrefix(word, m);
        //if starts with 'u', move the prefix
        if(word.charAt(0)=='u') rootStart++;
        if(word.charAt(0)=='y'){
            if(word.length()>1 && word.charAt(1)=='u') rootStart += 2;
            else rootStart+=1;
        }
        //if sta
        //if starts with 'e' 'i' 'o', check plural, if singular, remove, if plural, transform to neuter

        if(word.charAt(0)=='e' || word.charAt(0)=='i' || word.charAt(0)=='o'){
            if(word.length()>1 && word.charAt(0)==word.charAt(1)){
                m.number = "P";
                needPluralCheck = false;
                if(word.substring(0,2).equals("ee")) word = word.replaceFirst("ee", "e");
                else if(word.substring(0,2).equals("ii")) word = word.replaceFirst("ii", "e");
                else if(word.substring(0,2).equals("oo")) word = word.replaceFirst("oo", "e");
            }
        }


        word = checkSurfix(word, m);

        if(needPluralCheck) word = checkPlural(word.substring(rootStart), m);

        m.root = word;
        return m;
    }

    static String checkSurfix(String word, Morph m){
        char last = word.charAt(word.length()-1);
        switch(last){
            case 'y':
                m.tense = "FUT"; //future
                word = word.substring(0, word.length()-1);
                break;
            case 'u':
                m.tense = "PAST"; //past
                word = word.substring(0, word.length()-1);
                break;
            default:
                m.tense = "PRES"; //present
        }
        return word;
    }

    static String checkPrefix(String word, Morph m){
        char first = word.charAt(0);
        switch(first){
            case 'u':
                m.pos = "V"; //verb
                break;
            case 'y':
                if(word.length()>1 && word.charAt(1)=='u') m.pos = "ADV"; //adverb
                else m.pos = "ADJ"; //adjective
                break;
            case 'e':
                m.pos = "PN";
                m.gender = "N"; //neuter
                break;
            case 'i':
                m.pos = "PN";
                m.gender = "F"; //feminine
                break;
            case 'o':
                m.pos = "PN";
                m.gender = "M"; //masculine
                break;
            default:
                m.pos = "N";//noun
                break;
        }

        return word;
    }

    static String checkPlural(String word, Morph m){
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(c=='a' || c=='e' || c == 'i' || c == 'o' || c == 'u'){
                switch(c){
                    case 'a':
                        if(i+1<word.length() && word.charAt(i+1)=='a'){
                            m.number = "P";
                            word =word.replaceFirst("aa","a");
                        }else{
                            m.number = "S";
                        }
                        break;
                    case 'u':
                        if(i+1<word.length() && word.charAt(i+1)=='u'){
                            m.number = "P";
                            word =word.replaceFirst("uu","u");
                        }else{
                            m.number = "S";
                        }
                        break;
                    case 'i':
                        if(m.gender==null) m.gender = "F";
                        if(i+1<word.length() && word.charAt(i+1)=='i'){
                            m.number = "P";
                            word =word.replaceFirst("ii","e");
                        }else{
                            word =word.replaceFirst("i","e");
                            m.number = "S";
                        }
                        break;
                    case 'o':
                        if(m.gender==null) m.gender = "M";
                        if(i+1<word.length() && word.charAt(i+1)=='o'){
                            m.number = "P";
                            word = word.replaceFirst("oo","e");
                        }else{
                            word =word.replaceFirst("o","e");
                            m.number = "S";
                        }
                        break;
                    case 'e':
                        if(m.gender==null) m.gender = "N";
                        if(i+1<word.length() && word.charAt(i+1)=='e'){
                            m.number = "P";
                            word =word.replaceFirst("ee","e");
                        }else{
                            word =word.replaceFirst("e","e");
                            m.number = "S";
                        }
                        break;

                    default:
                        break;
                }
                break;
            }

        }
        return word;
    }
}

class Morph {
    String root;
    String pos;
    String tense;
    String number;
    String gender;
    public Morph() {}
    public Morph(String root_word) { root = root_word ; }

}
