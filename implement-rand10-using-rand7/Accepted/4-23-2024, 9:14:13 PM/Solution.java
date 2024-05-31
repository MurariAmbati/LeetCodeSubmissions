// https://leetcode.com/problems/implement-rand10-using-rand7

class Solution extends SolBase {
    public int rand10() {
        while (true) {
            int num = (rand7() - 1) * 7 + rand7();
            if (num <= 40) {
                return 1 + (num - 1) % 10;
            }
        }
    }
}
