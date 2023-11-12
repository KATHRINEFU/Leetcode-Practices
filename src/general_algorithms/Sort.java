package general_algorithms;

import java.util.Arrays;

/**
 * @ClassName Sort
 * @Description TODO
 * @Author katefu
 * @Date 11/7/23 7:14 PM
 * @Version 1.0
 **/
public class Sort {
    public static void main(String[] args) {
        int[] nums = {92,23,1,213,22,0,-7,32};
//        int [] res1 = insertionSort(nums);
//        for(int i: res1){
//            System.out.print(i + " ");
//        }
//        System.out.println();
//
//        int [] res2 = binaryInsertSort(nums);
//        for(int i: res2){
//            System.out.print(i + " ");
//        }
//        System.out.println();
//
//        int [] res3 = bubbleSort(nums);
//        for(int i: res3){
//            System.out.print(i + " ");
//        }
//        System.out.println();
//
//        int [] res4 = bubbleSort(nums);
//        for(int i: res4){
//            System.out.print(i + " ");
//        }
//        System.out.println();

//        shellSort(nums);

        quickSort(nums, 0, nums.length-1);
        for(int i: nums){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] insertionSort(int[] nums){
        for(int i=1; i<nums.length; i++){
            for(int j = i-1; j>=0; j--){
                if(nums[j+1]<nums[j]){
                    int tmp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        return nums;
    }

    public static int[] binaryInsertSort(int arr[])
    {
        int key, left, right, middle;
        int len = arr.length;
        for (int i=1; i<len; i++)
        {
            key = arr[i];
            left = 0;
            right = i-1;
            while (left<=right)
            {
                middle = (left+right)/2;
                if (arr[middle]>key)
                    right = middle-1;
                else
                    left = middle+1;
            }

            for(int j=i-1; j>=left; j--)
            {
                arr[j+1] = arr[j];
            }

            arr[left] = key;
        }

        return arr;
    }

    public static int[] bubbleSort(int[] arr) {
        int temp = 0; // 临时变量，交换的时候使用
        boolean change = false;
        for (int j = 0; j < arr.length - 1; j++) {
            change = false;
            for (int i = 0; i < arr.length - 1 - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    change = true;
                }
            }
            if (!change) {
                break;
            }
        }

        return arr;
    }

    public static int[] selectSort(int[] arr, boolean asc) {
        for (int i = 0; i < arr.length - 1; i++) {
            int current = arr[i];
            int currentIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (current > arr[j]) {
                    current = arr[j];
                    currentIndex = j;
                }
            }

            if (currentIndex == i) {
                continue;
            }
            arr[currentIndex] = arr[i];
            arr[i] = current;
        }

        return arr;
    }

    public static void shellSort(int[] arr) {
        int temp = 0;
        // 第 1 层循环：得到每一次的增量步长
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 第 2 层和第 3 层循环，是对每一个增量中的每一组进行插入排序
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            System.out.println("增量为 " + gap + " 的这一轮排序后：" + Arrays.toString(arr));
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        // 找到中间值
        int pivotIndex = (left + right) / 2;
        int pivot = arr[pivotIndex];
        int l = left;
        int r = right;
        while (l < r) {
            // 从左往右找，直到找到一个数，比基准值大的数
            while (arr[l] < pivot) {
                l++;
            }
            // 从右往左找，知道找到一个数，比基准值小的数
            while (arr[r] > pivot) {
                r--;
            }
            // 表示未找到
            if (l >= r) {
                break;
            }
            // 进行交换
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // 那么下一轮，左侧的这个值将不再参与排序，因为刚交换过，一定比基准值小
            // 那么下一轮，右侧的这个值将不再参与排序，因为刚交换过，一定比基准值大
            r--;
            l++;
        }

        // 当一轮找完后，没有找到，则是中间值时，
        // 需要让他们插件而过，也就是重新分组，中间值不再参与分组
        // 否则，在某些情况下，会进入死循环
        if (l == r) {
            l++;
            r--;
        }
        // 如果左侧还可以继续分组，则继续快排
        // 由于擦肩而过了，那么左侧的组值，则是最初的开始与中间值的前一个，也就是这里得到的 r
        if (left < r) {
            quickSort(arr, left, r);
        }
        if (right > l) {
            quickSort(arr, l, right);
        }
    }

    public void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 先分解左侧
            mergeSort(arr, left, mid, temp);
            // 再分解右侧
            mergeSort(arr, mid + 1, right, temp);
            // 最后合并
            // 由于是递归，合并这里一定是栈顶的先执行
            // 第一次：left = 0,right=1
            // 第二次：left = 2,right=3
            // 第三次：left = 0，right=3
//            System.out.println("left=" + left + "；right=" + right);
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * <pre>
     *  最难的是合并,所以可以先完成合并的方法，此方法请参考 基本思想 和 思路分析中的图解来完成
     *
     * </pre>
     *
     * @param arr   要排序的原始数组
     * @param left  因为是合并，所以要得到左右两边的的数组信息，这个是左侧数组的第一个索引值
     * @param mid   因为是一个数组，标识是第一个数组的最后一个索引，即 mid+1 是右侧数组的第一个索引
     * @param right 右侧数组的结束索引
     * @param temp  临时空间
     */
    public void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // 1. 按规则将两个数组合并到 temp 中
        // 定时临时变量，用来遍历数组比较
        int l = left;  // 左边有序数组的初始索引
        int r = mid + 1; // 右边有序数组的初始索引
        int t = 0; // temp 数组中当前最后一个有效数据的索引

        // 因为是合并两个数组，所以需要两边的数组都还有值的时候才能进行比较合并
        while (l <= mid && r <= right) {
            // 如果左边的比右边的小，则将左边的该元素填充到 temp 中
            // 并移动 t++,l++,好继续下一个
            if (arr[l] < arr[r]) {
                temp[t] = arr[l];
                t++;
                l++;
            }
            // 否则则将右边的移动到 temp 中
            else {
                temp[t] = arr[r];
                t++;
                r++;
            }
        }
        // 2. 如果有任意一边的数组还有值，则依序将剩余数据填充到 temp 中
        // 如果左侧还有值
        while (l <= mid) {
            temp[t] = arr[l];
            t++;
            l++;
        }
        // 如果右侧还有值
        while (r <= right) {
            temp[t] = arr[r];
            t++;
            r++;
        }

        // 3. 将 temp 数组，拷贝到原始数组
        // 注意：只拷贝当前有效数据到对应的原始数据中
        int tempL = left; // 从左边开始拷贝
        t = 0;  // temp 中的有效值，可以通过下面的 right 判定，因为合并两个数组到 temp 中，最大值则是 right
        while (tempL <= right) {
            arr[tempL] = temp[t];
            tempL++;
            t++;
        }
    }
}
