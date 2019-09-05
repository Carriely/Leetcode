package LRU;

//双链表
// 为什么必须要用双向链表?
// 因为我们需要删除操作。
// 删除一个节点不光要得到该节点本身的指针，也需要操作其前驱节点的指针，而双向链表才能支持直接查找前驱，保证操作的时间复杂度 O(1)。
public class DoubleList {
	// 头尾虚节点
	private Node head, tail;
	private int size;

	public DoubleList() {
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head.next = tail;
		tail.prev = head;
		this.size = 0;

	}

	// 在链表头部添加节点 x
	public void addFirst(Node x) {
		x.next = head.next;
		x.prev = head;
		head.next.prev = x;
		head.next = x;
		size++;
	}

	// 删除链表中的 x 节点（x 一定存在)
	public void remove(Node x) {
		x.prev.next = x.next;
		x.next.prev = x.prev;
		size--;
	}

	// 删除链表中最后一个节点，并返回该节点
	public Node removeLast() {
		if (tail.prev == head) {
			return null;
		}
		Node last = tail.prev;
		remove(last);
		return last;
	}

	// 返回链表长度
	public int size() {
		return size;
	}
}
