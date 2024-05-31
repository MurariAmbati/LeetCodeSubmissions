// https://leetcode.com/problems/pascals-triangle-ii

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> currentRow = new ArrayList<>();
        currentRow.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            int prev = 1;  // Store the previous element
            for (int j = 1; j < i; j++) {
                int temp = currentRow.get(j);  // Store current element for update
                currentRow.set(j, prev + temp);  // Update current with sum of previous and itself
                prev = temp;  // Update previous for next iteration
            }
            currentRow.add(1);  // Add 1 for the last element
        }

        return currentRow;
    }
}
