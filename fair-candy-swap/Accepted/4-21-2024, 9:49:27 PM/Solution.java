// https://leetcode.com/problems/fair-candy-swap

import java.util.*;

class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceTotal = 0;
        int bobTotal = 0;
        Set<Integer> bobSet = new HashSet<>();
        
        // Calculate total candies for Alice and build a set of Bob's candies
        for (int candy : aliceSizes) {
            aliceTotal += candy;
        }
        for (int candy : bobSizes) {
            bobTotal += candy;
            bobSet.add(candy);
        }
        
        // Calculate the difference in total candies
        int diff = (bobTotal - aliceTotal) / 2;
        
        // Look for a candy in Alice's set that, when swapped with one from Bob's set, makes the totals equal
        for (int candy : aliceSizes) {
            if (bobSet.contains(candy + diff)) {
                return new int[]{candy, candy + diff};
            }
        }
        
        return new int[]{};
    }
}