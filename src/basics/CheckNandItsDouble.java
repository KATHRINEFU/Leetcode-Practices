package basics;

/**
 * @author: Kate Fu
 * @create: 2022-02-23 8:56
 */
public class CheckNandItsDouble {
    public static void main(String[] args) {
        int[] input = {-2,0,10,-19,4,6,-8};
        Solution119 test = new Solution119();
        test.checkIfExist(input);
    }
}

class Solution119 {
    public boolean checkIfExist(int[] arr) {
        for(int i=0; i<arr.length; i++){
            if(arr[i]%2==0){
                for(int j=0; j<arr.length; j++){
                    if(i!=j && arr[j]==arr[i]/2) return true;
                }
            }
        }
        return false;
    }
}