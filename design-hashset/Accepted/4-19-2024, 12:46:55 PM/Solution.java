// https://leetcode.com/problems/design-hashset

class MyHashSet {
  private static final int BUCKET_SIZE = 1000; // Adjust bucket size as needed
  private List<List<Integer>> buckets;

  public MyHashSet() {
    buckets = new ArrayList<>(BUCKET_SIZE);
    for (int i = 0; i < BUCKET_SIZE; i++) {
      buckets.add(new LinkedList<>());
    }
  }
  
  public void add(int key) {
    int bucketIndex = getBucketIndex(key);
    List<Integer> bucket = buckets.get(bucketIndex);
    if (!bucket.contains(key)) {
      bucket.add(key);
    }
  }

  public boolean contains(int key) {
    int bucketIndex = getBucketIndex(key);
    List<Integer> bucket = buckets.get(bucketIndex);
    return bucket.contains(key);
  }

  public void remove(int key) {
    int bucketIndex = getBucketIndex(key);
    List<Integer> bucket = buckets.get(bucketIndex);
    bucket.remove(Integer.valueOf(key)); // Remove by value (avoid boxing overhead)
  }

  private int getBucketIndex(int key) {
    return key % BUCKET_SIZE;
  }
}
