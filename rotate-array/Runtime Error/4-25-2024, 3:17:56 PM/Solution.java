// https://leetcode.com/problems/rotate-array

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;  // Handle the case where k is larger than the length of the array
        int start = 0, j = 0;
        while (true) {
            int count = 0;
            int i = j;
            while (true) {
                int next_j = (i + k) % n;
                if (next_j == start) {
                    break;
                }
                swap(nums, i, next_j);
                i = next_j;
                count++;
            }
            start += count;
            j += count;
            if (start == n) {
                break;
            }
        }
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
