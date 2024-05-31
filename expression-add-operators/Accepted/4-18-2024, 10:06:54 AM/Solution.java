// https://leetcode.com/problems/expression-add-operators

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        backtrack(result, num, target, "", 0, 0, 0);
        return result;
    }

    private void backtrack(List<String> result, String num, int target, String expression, int index, long eval, long prevNum) {
        if (index == num.length()) {
            if (eval == target) {
                result.add(expression);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') {
                break; // Skip leading zeros
            }
            long currNum = Long.parseLong(num.substring(index, i + 1));
            if (index == 0) {
                backtrack(result, num, target, expression + currNum, i + 1, currNum, currNum);
            } else {
                backtrack(result, num, target, expression + "+" + currNum, i + 1, eval + currNum, currNum);
                backtrack(result, num, target, expression + "-" + currNum, i + 1, eval - currNum, -currNum);
                backtrack(result, num, target, expression + "*" + currNum, i + 1, eval - prevNum + prevNum * currNum, prevNum * currNum);
            }
        }
    }
}