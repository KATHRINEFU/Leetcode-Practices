package OA;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Alibaba1 {
    public static void main(String[] args) {
        String a = "Jan:7 niiso:8";
        String reg2 = ".*?:(.*) ";
        Pattern p2 = Pattern.compile(reg2);
        Matcher m = p2.matcher(a);
        System.out.println(m.replaceAll("").trim());
    }

}

class Solution01{
    public List<String> process(List<String> input){
        List<String> res = new ArrayList<>();
        double[] months = new double[12];
        String reg1 = "[^0-9]";
        Pattern p1 = Pattern.compile(reg1);
        String reg2 = ".*?:(.*) ";
        Pattern p2 = Pattern.compile(reg2);
        int count=0;

        for(int i=0; i<input.size();i++){
            if(i%2!=0){
                count = Integer.parseInt(p1.matcher(input.get(i)).replaceAll("").trim());
            }
            if(i%2==0){
                p2.matcher(input.get(i));
            }
        }

        return res;
    }
}
