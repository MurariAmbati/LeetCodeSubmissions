// https://leetcode.com/problems/flipping-an-image

import java.util.Arrays;

class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        for (int[] row : image) {
            // Reverse the row
            reverse(row);
            // Invert each element in the row
            for (int i = 0; i < n; i++) {
                row[i] ^= 1;
            }
        }
        return image;
    }
    
    // Function to reverse an array
    private void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

}