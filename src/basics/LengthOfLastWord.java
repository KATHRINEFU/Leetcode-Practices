package basics;

/**
 * @author: Kate Fu
 * @create: 2021-12-30 18:04
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "Hello World  ";
        Solution9 test = new Solution9();
        int i = test.lengthOfLastWord(s);
        System.out.println(i);
    }
}
class Solution9 {
    public int lengthOfLastWord(String s) {
        int res=0;
        boolean flag=false;
        for(int i=s.length()-1; i>=0; i--){
            if(flag==false && s.charAt(i)==' ') {
                res=0;
                continue;
            }else if(flag==true && s.charAt(i)==' '){
                break;
            }
            else if(s.charAt(i)!=' '){
                flag=true;
                res+=1;
            }
        }
        return res;
    }
}