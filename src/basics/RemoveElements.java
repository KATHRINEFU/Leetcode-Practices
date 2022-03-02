package basics;

/**
 * @author: Kate Fu
 * @create: 2021-12-24 16:46
 */
public class RemoveElements {
    public static void main(String[] args) {
        int[] nums ={0,1,2,2,3,0,4,2};
        int val=2;
        Solution6 test = new Solution6();
        int res = test.removeElement(nums, val);
        System.out.println(res);
    }
}
class Solution6 {
    public int removeElement(int[] nums, int val) {
        if(nums.length==0) return 0;
        int count=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==val && i<nums.length-count){
                moveToBack(nums, i);
                count++;
                i--;
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

    public int removeElementSample(int[] nums, int val) {
        int m = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[m] = nums[i];
                m++;
            }
        }
        return m;
    }
}