// https://leetcode.com/problems/unique-binary-search-trees

class MyHashMap {
  private static final int BUCKET_SIZE = 1000; // Adjust bucket size as needed
  private List<Node>[] buckets;

  public MyHashMap() {
    buckets = new ArrayList<>(BUCKET_SIZE);
    for (int i = 0; i < BUCKET_SIZE; i++) {
      buckets.add(null);
    }
  }

  public void put(int key, int value) {
    int bucketIndex = getBucketIndex(key);
    Node head = buckets[bucketIndex];

    // Traverse the bucket list and update if key found, otherwise insert a new node
    while (head != null) {
      if (head.key == key) {
        head.value = value;
        return;
      }
      head = head.next;
    }

    // If key not found, create a new node and insert it at the beginning of the bucket list
    Node newNode = new Node(key, value);
    newNode.next = buckets[bucketIndex];
    buckets[bucketIndex] = newNode;
  }

  public int get(int key) {
    int bucketIndex = getBucketIndex(key);
    Node head = buckets[bucketIndex];

    // Traverse the bucket list and search for the key
    while (head != null) {
      if (head.key == key) {
        return head.value;
      }
      head = head.next;
    }

    // Key not found, return -1
    return -1;
  }

  public void remove(int key) {
    int bucketIndex = getBucketIndex(key);
    Node head = buckets[bucketIndex];
    Node prev = null;

    // Traverse the bucket list and remove the node with the matching key
    while (head != null) {
      if (head.key == key) {
        if (prev == null) {
          buckets[bucketIndex] = head.next;
        } else {
          prev.next = head.next;
        }
        return;
      }
      prev = head;
      head = head.next;
    }
  }

  private int getBucketIndex(int key) {
    return key % BUCKET_SIZE;
  }

  // Node class to store key-value pairs within a bucket
  private static class Node {
    int key;
    int value;
    Node next;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }
}