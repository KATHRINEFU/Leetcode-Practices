package medium;

public class FindFirstAndLastPosition {
    public static void main(String[] args) {
        int[] arr = {1, 4};
        int k = 4;
        Solution34 test = new Solution34();
        test.searchRange2(arr,k);
    }
}

class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0) return new int[]{1, 1};
        if(target<nums[0] || target>nums[nums.length-1]) return new int[]{-1,-1};
        int left=0;
        int right = nums.length-1;
        int mid=Integer.MAX_VALUE;
        while(left<=right){
            mid = left+(right-left)/2;
            if(nums[mid]==target) break;
            else if(nums[mid]>target) right = mid-1;
            else left = mid+1;
        }
        if(nums[mid]!=target) return new int[]{-1,-1};
        left = mid-1;
        right = mid+1;
        while(left>=0 || right<=nums.length-1){
            if(left>=0 && nums[left]==target) left--;
            if(right<=nums.length-1 && nums[right]==target) right++;
            if(left>=0 && right<=nums.length-1 &&nums[left]!=target &&nums[right]!=target) break;
            if(left<0 && right>nums.length-1) break;
            if(left<0 && nums[right]!=target) break;
            if(right>nums.length-1 && nums[left]!=target) break;
        }

        return new int[]{left+1, right-1};
    }


    public int[] searchRange2(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = left;
        while(left<=right){
            mid = (right-left)/2+left;
            if(nums[mid]<target){
                left = mid+1;
            }else if(nums[mid]>target){
                right = mid-1;
            }else{
                int i=mid, j = mid;
                while(i>=0 && nums[i]==target){
                    i --;
                }

                while(j<nums.length && nums[j]==target){
                    j++;
                }

                return new int[]{i+1, j-1};

            }
        }

        return new int[]{-1,-1};
    }

    public int[] searchRangeSample(int[] a, int target){

        int[] result = {-1, -1};

        if (a == null || a.length == 0)
            return result;

        result[0] = findStartPosition(a, target);
        result[1] = findEndPosition(a, target);

        return result;
    }

    public int findStartPosition(int[] a, int target){

        int left = 0;
        int right = a.length-1;
        int start =-1;

        while(left<= right){

            int mid = left+(right-left)/2;

            if (a[mid] == target){
                start = mid; // this is start
                right = mid-1; // lets see if there one more on the left
            }else if (target > a[mid]){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        return start;
    }

    public int findEndPosition(int[] a, int target){
        int left = 0;
        int right = a.length-1;
        int end = -1;

        while(left <= right){
            int mid = left + (right-left)/2;

            if (a[mid] == target){
                end = mid;	  // this is the end
                left = mid+1; // lets see if there is one more on the right
            }else if (target > a[mid])
                left = mid +1;
            else
                right = mid -1;

        }

        return end;
    }
}