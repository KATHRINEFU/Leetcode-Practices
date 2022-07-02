package contest;

/**
 * @ClassName MaximumScoreOfSplicedArray
 * @Description
 * You are given two 0-indexed integer arrays nums1 and nums2, both of length n.
 *
 * You can choose two integers left and right where 0 <= left <= right < n and swap the subarray nums1[left...right] with the subarray nums2[left...right].
 *
 * For example, if nums1 = [1,2,3,4,5] and nums2 = [11,12,13,14,15] and you choose left = 1 and right = 2, nums1 becomes [1,12,13,4,5] and nums2 becomes [11,2,3,14,15].
 * You may choose to apply the mentioned operation once or not do anything.
 *
 * The score of the arrays is the maximum of sum(nums1) and sum(nums2), where sum(arr) is the sum of all the elements in the array arr.
 *
 * Return the maximum possible score.
 * @Author katefu
 * @Date 7/2/22 7:40 PM
 * @Version 1.0
 **/
public class MaximumScoreOfSplicedArray {
}

class Solution2{
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        //1st thing we have to do is to obviously find the sum of both the arrays.
        //Let them be sum1, sum2.
        //Now either of them will be greater than the other.
        int sum1=0, sum2=0, n=nums1.length;
        for(int num : nums1) sum1+=num;
        for(int num : nums2) sum2+=num;
        if(sum2>sum1){
            int temp = sum2;
            sum2 = sum1;
            sum1 = temp;
            int[] tempArr = nums2;
            nums2 = nums1;
            nums1 = tempArr;
        }
        //Now we have sum1>=sum2

        //maxEndingHere denotes the maximum sum subarray ending at current index(ie. element at current index has to be included)
        //minEndingHere denotes the minimum sum subarray ending at current index
        int maxEndingHere, minEndingHere, maxSoFar, minSoFar, currEle;
        maxEndingHere=minEndingHere=maxSoFar=minSoFar=nums2[0]-nums1[0];

        //Observation:
        //sum(nums1')  = sum(nums1) + { sum(nums2[l...r]) - sum(nums1[l...r]) }
        //sum(nums2')  = sum(nums2) - { sum(nums2[l...r]) - sum(nums1[l...r]) }
        //So basically:
        //to make sum1 larger we maximize { sum(nums2[l...r]) - sum(nums1[l...r]) }
        //to make sum2 larger we minimize { sum(nums2[l...r]) - sum(nums1[l...r]) }

        for(int i=1; i<n; i++){
            currEle = nums2[i]-nums1[i];
            minEndingHere+=currEle;
            maxEndingHere+=currEle;
            if(maxEndingHere<currEle) maxEndingHere = currEle;
            if(minEndingHere>currEle) minEndingHere = currEle;
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
            minSoFar = Math.min(minEndingHere, minSoFar);
        }
        return  Math.max(sum1+Math.max(maxSoFar,0), sum2-Math.min(0, minSoFar));
    }
}