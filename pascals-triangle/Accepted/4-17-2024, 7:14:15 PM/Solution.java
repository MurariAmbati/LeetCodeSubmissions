// https://leetcode.com/problems/pascals-triangle

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        
        // Base case: First row is always [1]
        pascalTriangle.add(Collections.singletonList(1));

        // Iterate for remaining rows
        for (int i = 1; i < numRows; i++) {
            List<Integer> previousRow = pascalTriangle.get(i - 1);
            List<Integer> currentRow = new ArrayList<>();
            
            // First element is always 1
            currentRow.add(1);
            
            // Middle elements are sum of elements above
            for (int j = 1; j < i; j++) {
                currentRow.add(previousRow.get(j - 1) + previousRow.get(j));
            }
            
            // Last element is always 1
            currentRow.add(1);
            
            pascalTriangle.add(currentRow);
        }
        
        return pascalTriangle;
    }
}
