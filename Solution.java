import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {9,6,4,2,3,5,7,0,1};
        sol.mergeSort(nums);
        System.out.println("Missing Number = " + sol.missingNumberV1(nums));
    }
    public int missingNumber(int[] nums) {
        mergeSort(nums);
        int[] lookupArray = new int[nums.length + 1];
        for (int i = 0; i < lookupArray.length; i++) {
            lookupArray[i] = i;
        }
        for (int i = 0; i < nums.length; i++) {
            if(lookupArray[i] != nums[i]){
                return lookupArray[i];
            }
        }
        return nums.length;
    }
    public int missingNumberV1(int[] nums){
        int count1 = 0, count2 = 0;
        int[] lookupArray = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            count1 ^= nums[i];
        }
        for (int i = 0; i < nums.length + 1; i++) {
            count2 ^= i;
        }
    return count1 ^ count2;

    }

    private void mergeSort(int[] nums) {
        if(nums.length < 2) return;
        int[] leftArray = new int[nums.length / 2];
        int[] rightArray = new int[nums.length - leftArray.length];
        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = nums[i];
        }
        for (int i = leftArray.length; i < nums.length ; i++) {
            rightArray[i - leftArray.length] = nums[i];
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, nums);
    }

    private void merge(int[] leftArray, int[] rightArray, int[] nums){
        int i = 0, j = 0, k = 0;
        while(i < leftArray.length && j < rightArray.length){
            if(leftArray[i] <= rightArray[j]){
                nums[k] = leftArray[i];
                i++;
            }else{
                nums[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while(i < leftArray.length){
            nums[k] = leftArray[i];
            i++;
            k++;
        }
        while(j < rightArray.length){
            nums[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
