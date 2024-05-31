// https://leetcode.com/problems/number-of-boomerangs

public int numberOfBoomerangs(int[][] points) {
        int count = 0;
        // Iterate through each point in the input
        for (int[] p : points) {
            // Create a hashmap to store distances
            HashMap<Integer, Integer> map = new HashMap<>();
            // Iterate through each other point
            for (int[] q : points) {
                // Calculate distance between p and q
                int distance = (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
                // Update the count for this distance in the hashmap
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }
            // Iterate through the distances in the hashmap
            for (int dist : map.values()) {
                // For each distance, add the count of boomerangs
                // originating from this point to the total count
                count += dist * (dist - 1);
            }
        }
        return count;
    }
}