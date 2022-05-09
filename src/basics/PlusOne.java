package basics;

/**
 * @ClassName PlusOne
 * @Description TODO
 * @Author katefu
 * @Date 4/18/22 11:08 PM
 * @Version 1.0
 **/
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {8,9,9,9};
        Solution66 test = new Solution66();
        test.plusOne(digits);

    }
}

class Solution66 {
    public int[] plusOne(int[] digits) {
        if(digits[digits.length-1]!=9) {
            digits[digits.length - 1] += 1;
            return digits;
        }

        boolean allNine=true;
        for(int i=0; i<digits.length; i++) {
            if(digits[i]!=9) {
                allNine=false;
                break;
            }
        }

        if(allNine) {
            int[] res = new int[digits.length+1];
            res[0]=1;
            return res;
        }

        int index = digits.length-1;
        while(digits[index]==9){
            digits[index]=0;
            index--;
        }
        digits[index]++;
        return digits;
    }
}
