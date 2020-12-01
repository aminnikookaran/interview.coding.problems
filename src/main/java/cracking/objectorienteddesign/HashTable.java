package cracking.objectorienteddesign;

import java.util.ArrayList;

public class HashTable {
  public static class Hasher<K, V> {
    /* Linked list node class. Used only within hash table. No one else should get
     * access to this. Implemented as doubly linked list. */
    private static class LinkedListNode<K, V> {
      public LinkedListNode<K, V> next;
      public LinkedListNode<K, V> prev;
      public K key;
      public V value;

      public LinkedListNode(K k, V v) {
        key = k;
        value = v;
      }
    }

    private ArrayList<LinkedListNode<K, V>> arr;

    public Hasher(int capacity) {
      /* Create list of linked lists at a particular size. Fill list with null
       * values, as it's the only way to make the array the desired size. */
      arr = new ArrayList<LinkedListNode<K, V>>();
      arr.ensureCapacity(capacity); // Optional optimization
      for (int i = 0; i < capacity; i++) arr.add(null);
    }

    /* Insert key and value into hash table. */
    public void put(K key, V value) {
      LinkedListNode<K, V> node = getNodeForKey(key);
      if (node != null) { // Already there
        node.value = value; // just update the value.
        return;
      }

      node = new LinkedListNode<K, V>(key, value);
      int index = getindexForKey(key);
      if (arr.get(index) != null) {
        node.next = arr.get(index);
        node.next.prev = node;
      }
      arr.set(index, node);
    }

    /* Remove node for key. */
    public void remove(K key) {
      LinkedListNode<K, V> node = getNodeForKey(key);
      if (node.prev != null) node.prev.next = node.next;
      else {
        /* Removing head - update. */
        int hashKey = getindexForKey(key);
        arr.set(hashKey, node.next);
      }

      if (node.next != null) node.next.prev = node.prev;
    }

    /* Get value for key. */
    public V get(K key) {
      LinkedListNode<K, V> node = getNodeForKey(key);
      return node == null ? null : node.value;
    }

    /* Get linked list node associated with a given key. */
    private LinkedListNode<K, V> getNodeForKey(K key) {
      int index = getindexForKey(key);
      LinkedListNode<K, V> current = arr.get(index);
      while (current != null) {
        if (current.key == key) return current;
        current = current.next;
      }
      return null;
    }

    /* Really naive function to map a key to an index. */
    public int getindexForKey(K key) {
      return Math.abs(key.hashCode() % arr.size());
    }
  }
}
