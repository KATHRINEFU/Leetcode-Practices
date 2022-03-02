package basics;

/**
 * @author: Kate Fu
 * @create: 2022-02-23 7:28
 */
public class DuplicateZeros {
    public static void main(String[] args) {
        int[] input = {1,0,2,3,0,4,5,0};
        Solution1089 test = new Solution1089();
        test.duplicateZeros(input);
    }
}

class Solution1089 {
    public void duplicateZeros(int[] arr) {
        for(int i=0; i<arr.length; i++){
            if(arr[i]==0 && i!=arr.length-1){
                duplicateZero(arr, i);
                i++;
            }
        }
    }

    public void duplicateZero(int[] arr, int i){
        for(int j=arr.length-1; j>i+1; j--){
            arr[j+1]=arr[j];
        }
        arr[i+1]=0;
    }

    public void duplicateZerosSample(int[] a) {
        int i = 0, sh = 0;
        for (i = 0; sh + i < a.length; ++i) sh += a[i] == 0 ? 1 : 0;
        for (i = i - 1; sh > 0; --i) {
            if (i + sh < a.length) a[i + sh] = a[i];
            if (a[i] == 0) a[i + --sh] = a[i];
        }
    }
}