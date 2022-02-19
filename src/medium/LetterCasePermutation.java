package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Kate Fu
 * @create: 2022-02-18 14:42
 */
public class LetterCasePermutation {
    public static void main(String[] args) {
        String s = "a1b2";
        Solution784 test = new Solution784();
        test.letterCasePermutation(s);
    }
}

class Solution784 {
    public List<String> letterCasePermutation(String s) {
        List<String> list = new ArrayList<>();
        convert(list,0, s.toCharArray());
        return list;
    }

    public void convert(List<String> list, int i, char[] arr){
        if(i==arr.length){
            list.add(new String(arr));
            return;
        }

        if(Character.isLetter(arr[i])){
            arr[i] = Character.toUpperCase(arr[i]);
            convert(list, i+1, arr);
            arr[i] = Character.toLowerCase(arr[i]);
            convert(list, i+1, arr);
        }else{
            convert(list, i+1, arr);
        }

    }
}