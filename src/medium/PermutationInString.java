package medium;

/**
 * @author: Kate Fu
 * @create: 2022-02-13 12:30
 */
public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "lhjkbauoihu";
        Solution567 test = new Solution567();

        boolean res = test.checkInclusionSample(s1,s2);
    System.out.println(res);
    }
}

class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length()) return false;
        int len = s1.length();
        int left=0;
        int right = s1.length()-1;
        char[] arr = s1.toCharArray();
        while(left<=right){
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        String reS1 = new String(arr);

        for(int i=s2.length()-1; i>=0; i--){
            if(s2.charAt(i)==s1.charAt(0)){
                if(i-len+1>=0 && s2.substring(i - len + 1, i + 1).equals(reS1)){
                    return true;
                }
            }
        }

        return false;
    }

    /*
    1. How do we know string p is a permutation of string s? Easy, each character in p is in s too. So we can abstract
    all permutation strings of s to a map (Character -> Count). i.e. abba -> {a:2, b:2}. Since there are only 26 lower
     case letters in this problem, we can just use an array to represent the map.
    2. How do we know string s2 contains a permutation of s1? We just need to create a sliding window with length of s1,
    move from beginning to the end of s2. When a character moves in from right of the window, we subtract 1 to that
    character count from the map. When a character moves out from left of the window, we add 1 to that character count.
    So once we see all zeros in the map, meaning equal numbers of every characters between s1 and the substring in the
    sliding window, we know the answer is true.
     */
    public boolean checkInclusionSample(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if (allZero(count)) return true;

        for (int i = len1; i < len2; i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - len1) - 'a']++;
            if (allZero(count)) return true;
        }

        return false;
    }

    private boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
}