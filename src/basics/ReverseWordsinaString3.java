package basics;

/**
 * @author: Kate Fu
 * @create: 2022-02-12 7:30
 */
public class ReverseWordsinaString3 {
    public static void main(String[] args) {
        String s = "Let's take Leetcode contest";
        Solution557 test = new Solution557();
        test.reverseWords(s);
    }
}

class Solution557 {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length;i++){
            int j=i;
            for(; j<arr.length; j++){
                if(arr[j]==' '){
                    reverseWord(arr, i, j-1);
                    break;
                }else if(j==arr.length-1){
                    reverseWord(arr,i,j);
                    break;
                }
            }
            i=j;
        }

        String res = new String(arr);
        return res;
    }

    public void reverseWord(char[] arr, int i, int j){
        int a=i;
        int b=j;
        char temp= ' ';
        while(a<b){
            temp = arr[a];
            arr[a]=arr[b];
            arr[b]=temp;
            a++;
            b--;
        }
    }

    public String reverseWordsSample(String s)
    {
        char[] s1 = s.toCharArray();
        int i = 0;
        for(int j = 0; j < s1.length; j++)
        {
            if(s1[j] == ' ')
            {
                reverseWord(s1, i, j - 1);
                i = j + 1;
            }
        }
        reverseWord(s1, i, s1.length - 1);
        return new String(s1);
    }
}