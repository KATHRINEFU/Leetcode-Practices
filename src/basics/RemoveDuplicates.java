package basics;

/**
 * @author: Kate Fu
 * @create: 2021-12-23 17:02
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3};
        Solution5 test = new Solution5();
        int res = test.removeDuplicates(nums);
        System.out.println(res);
        int res2 = test.removeDuplicatesSample(nums);
    }
}
class Solution5 {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0 || nums.length==1) return 1;
        int temp;
        int count=0;
        for(int i=0; i<nums.length; i++){
            if(i>=nums.length-count){
                continue;
            }
            temp=nums[i];
            int j;
            if(i+1<nums.length){
                j=i+1;
            }else{
                break;
            }

            while (true) {
                if (temp != nums[j]|| j>=nums.length-count) {
                    break;
                }
                else {
                    if(j!=nums.length-1){
                        moveToBack(nums, j);
                        count++;
                    }else{
                        count++;
                        break;
                    }
                }
            }
        }
        return nums.length-count;
    }

    public void moveToBack(int[] arr, int index){
        int temp = arr[index];
        for(int i=index; i<arr.length-1; i++){
            arr[i]=arr[i+1];
        }
        arr[arr.length-1]=temp;
    }

    public int removeDuplicatesSample(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i == 0 || n > nums[i-1])
                nums[i++] = n;
        return i;
    }
}