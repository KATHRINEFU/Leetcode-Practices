package string;

/**
 * @ClassName DecodedStringAtIndex
 * @Description TODO
 * @Author katefu
 * @Date 9/26/23 11:18 PM
 * @Version 1.0
 **/
public class DecodedStringAtIndex {
    public static void main(String[] args) {
        Solution880 test = new Solution880();
        test.decodeAtIndex("a2b3c4d5e6f7g8h9", 10);
    }
}


class Solution880 {
    public String decodeAtIndex(String s, int k) {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++){
            if(arr[i]>= '2' && arr[i]<='9'){
                String curString = sb.toString();
                for(int j = 0; j< (arr[i] - '0') -1; j++){
                    sb.append(curString);
                    if(sb.length()>=k){
                        return String.valueOf(sb.charAt(k-1));
                    }
                }
            }else{
                sb.append(arr[i]);
                if(sb.length()>=k){
                    return String.valueOf(sb.charAt(k-1));
                }
            }
        }

        return String.valueOf(sb.charAt(k-1));
    }


    public String decodeAtIndexSample(String s, int k) {
        long length = 0;
        int i = 0;

        while (length < k) {
            if (Character.isDigit(s.charAt(i))) {
                length *= s.charAt(i) - '0';
            } else {
                length++;
            }
            i++;
        }

        for (int j = i - 1; j >= 0; j--) {
            if (Character.isDigit(s.charAt(j))) {
                length /= s.charAt(j) - '0';
                k %= length;
            } else {
                if (k == 0 || k == length) {
                    return Character.toString(s.charAt(j));
                }
                length--;
            }
        }

        return "";
    }
}