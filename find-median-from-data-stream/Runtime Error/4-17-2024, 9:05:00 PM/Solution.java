// https://leetcode.com/problems/find-median-from-data-stream

class MedianFinder {
    private PriorityQueue<Integer> minHeap; // Stores the smaller half of the elements (ascending order)
    private PriorityQueue<Integer> maxHeap; // Stores the larger half (descending order)

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a)); // Reverse order for descending priority using Integer.compare()
    }

    public void addNum(int num) {
        maxHeap.offer(num); // Initially add to maxHeap

        // Balance the heaps: move elements from maxHeap to minHeap if maxHeap size is larger
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.isEmpty() && maxHeap.isEmpty()) {
            throw new RuntimeException("No elements added yet!");
        }

        // If both heaps have the same size, the median is the average of their tops
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + (double) maxHeap.peek()) / 2.0;
        } else {
            // If minHeap has one more element, the median is its top
            return minHeap.peek();
        }
    }
}
