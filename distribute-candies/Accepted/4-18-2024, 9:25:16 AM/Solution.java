// https://leetcode.com/problems/distribute-candies

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int distributeCandies(int[] candyType) {
        int maxCandies = candyType.length / 2;
        Set<Integer> uniqueCandies = new HashSet<>();
        
        for (int candy : candyType) {
            uniqueCandies.add(candy);
            if (uniqueCandies.size() == maxCandies) {
                break;
            }
        }
        
        return Math.min(uniqueCandies.size(), maxCandies);
    }
}
