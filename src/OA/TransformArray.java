package OA;

import java.util.Arrays;

/**
 * @ClassName TransformArray
 * @Description
 * You are given two arrays of integers $a1, a2, ...,an$ and $b1, b2, ..., bn$.
 * Let’s define a transformation of the array $a$: Choose any non-negative integer k
 * such that $0 <= k <= n$. Choose $k$ distinct array indices $1 <= i1 < i2 ... < ik <= n$.
 * And 1 to each of $ai1, ai2, ..., aik$, all other elements of array $a$ remain unchanged.
 * Permute the elements of array $a$ in any order.
 * Is it possible to perform some transformation of the array $a$ exactly once,
 * so that the resulting array is equal to $b$？
 * @Author katefu
 * @Date 10/7/22 11:13 AM
 * @Version 1.0
 **/
public class TransformArray {
    boolean test(String a, String b){
        int[] aNum = Arrays.stream(a.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] bNum = Arrays.stream(b.split(" ")).mapToInt(Integer::parseInt).toArray();
        if(aNum.length!=bNum.length) return false;
        int n = aNum.length;
        Arrays.sort(aNum);
        Arrays.sort(bNum);

        for(int i=0; i<n; i++){
            if(aNum[i]==bNum[i] || aNum[i]+1 == bNum[i])  continue;
            else return false;
        }

        return true;
    }
}
