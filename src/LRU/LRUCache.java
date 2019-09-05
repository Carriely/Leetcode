package LRU;

import java.util.HashMap;

//LRU缓存机制
//参考：https://leetcode-cn.com/problems/lru-cache/solution/lru-ce-lue-xiang-jie-he-shi-xian-by-labuladong/
public class LRUCache {
	// key -> Node(key, val)
	private HashMap<Integer, Node> map;
	// Node(k1, v1) <-> Node(k2, v2)...
	private DoubleList cache;
	private int cap;

	public LRUCache(int capacity) {
		map = new HashMap<>();
		cache = new DoubleList();
		this.cap = capacity;
	}

	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}
		int val = map.get(key).value;
		// 利用 put 方法把该数据提前
		put(key, val);
		return val;
	}

	public void put(int key, int value) {
		// 先把新节点 x 做出来
		Node x = new Node(key, value);
		if (map.containsKey(key)) {
			// 删除旧的节点，新的插到头部
			cache.remove(map.get(key));
			cache.addFirst(x);
			// 更新 map 中对应的数据
            map.put(key, x);
		} else {
			if (cache.size() == cap) {
				// 删除链表最后一个数据
				Node last = cache.removeLast();
				// 删除 map 中映射到该数据的键
				map.remove(last.key);
				// 为什么要在链表中同时存储 key 和 val，而不是只存储 val
				// 当缓存容量已满，我们不仅仅要删除最后一个 Node 节点，还要把 map 中映射到该节点的 key 同时删除，而这个 key 只能由 Node 得到。如果 Node 结构中只存储 val，那么我们就无法得知 key 是什么，就无法删除 map 中的键，造成错误。
			}
			// 直接添加到头部
			cache.addFirst(x);
			// map 中新建 key 对新节点 x 的映射
			map.put(key, x);
		}
	}
}
