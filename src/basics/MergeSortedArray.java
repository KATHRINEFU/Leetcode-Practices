package basics;

/**
 * @author: Kate Fu
 * @create: 2022-01-23 19:00
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {4,0,0,0,0,0};
        int[] nums2 = {1,2,3,5,6};
        int m=1;
        int n=5;
        Solution88 test = new Solution88();
        test.merge(nums1, m, nums2, n);
        for(int i=0; i<nums1.length; i++){
            System.out.println(nums1[i]);
        }
    }
}

class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m==0){
            nums1 = nums2;
            return;
        }
        int index=0;
        for(int i=0; i<nums2.length; i++){
            if(nums2[i]> nums1[m-1+i]){
                nums1[m+i]=nums2[i];
            }
            if(nums2[i]<nums1[0]){
                for(int a = nums1.length-2; a>=0; a--){
                    nums1[a+1]=nums1[a];
                }
                nums1[0]=nums2[i];
            }
            for(int j=index; j<m-1; j++){
                if(nums2[i]>nums1[j] && nums2[i]<=nums1[j+1]){
                    index=j+1;
                    for(int a = nums1.length-2; a>=j; a--){
                        nums1[a+1]=nums1[a];
                    }
                    nums1[j+1]=nums2[i];
                    break;
                }
            }
        }
    }

    public void mergeSample(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1, tail2 = n - 1, finished = m + n -  1;
        while (tail1 >= 0 && tail2 >= 0) {
            nums1[finished--] = (nums1[tail1] > nums2[tail2]) ?
                    nums1[tail1--] : nums2[tail2--];
        }

        while (tail2 >= 0) { //only need to combine with remaining nums2
            nums1[finished--] = nums2[tail2--];
        }
    }
}