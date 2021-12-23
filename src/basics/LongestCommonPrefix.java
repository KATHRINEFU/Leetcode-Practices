package basics;

/**
 * @author: Kate Fu
 * @create: 2021-10-21 11:14
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[]{"",""};
        Solution3 test = new Solution3();
        String res = test.longestCommonPrefix(strs);
        System.out.println(res);
    }

}
class Solution3 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }
        for(int i=0; i<strs.length; i++){
            if(strs[i]=="")
                return "";
        }
        char first = strs[0].charAt(0);
        for(int i=0; i<strs.length; i++){
            if(strs[i].charAt(0)!=first)
                return "";
        }
        String res=strs[0];
        for(int i=1; i<strs.length; i++){
            int j=0;
            String temp="";
            while(j<strs[i].length() && strs[i].charAt(j)==res.charAt(j)){
                temp+=res.charAt(j);
                j++;
            }
            res=temp;
        }
        return res;
    }

    public String sampleLongestCommonPrefix(String[] strs){
        if (strs.length == 0) return "";
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++)
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length()-1);
        return pre;
    }
}
