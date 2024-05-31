// https://leetcode.com/problems/lemonade-change

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int count5 = 0, count10 = 0;
        for (int bill : bills) {
            if (bill == 5) {
                count5++;
            } else if (bill == 10) {
                if (count5 == 0) {
                    return false; // Cannot give change
                }
                count5--;
                count10++;
            } else { // bill == 20
                if (count10 > 0 && count5 > 0) {
                    count10--;
                    count5--;
                } else if (count5 >= 3) {
                    count5 -= 3;
                } else {
                    return false; // Cannot give change
                }
            }
        }
        return true; // All customers received correct change
    }
}