package exercices;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
	int size;
	// map to store the cache
	HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
	// store the cache access
	LinkedList<Integer> access = new LinkedList<Integer>();

	public LRUCache(int size) {
		this.size = size;
	}

	public int get(int key) {
		Integer value = cache.get(key);
		if (value != null) {
			access.remove(value);
			access.addFirst(key);
		} else {
			value = -1;
		}
		return value;
	}

	public void put(int key, int value) {
		if (access.size() >= size) {
			cache.remove(access.removeLast());
		}
		access.addFirst(key);
		cache.put(key, value);
	}
	
	public class Solution {
		public static void main(String[] args) throws Exception {
			LRUCache lRUCache = new LRUCache(2);
			lRUCache.put(1, 1); // cache is {1=1}
			lRUCache.put(2, 2); // cache is {1=1, 2=2}
			//lRUCache.get(1);    // return 1
			System.out.println(lRUCache.get(1));
			
			lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
			//lRUCache.get(2);    // returns -1 (not found)
			System.out.println(lRUCache.get(2));
			
			lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
			//lRUCache.get(1);    // return -1 (not found)
			System.out.println(lRUCache.get(1));
			//lRUCache.get(3);    // return 3
			System.out.println(lRUCache.get(3));
			//lRUCache.get(4);    // return 4
			System.out.println(lRUCache.get(4));
//
//			System.out.println(lRUCache);
		}
	}
}
