
public class LinkedList<T> {
	private Node<T> head;
	private Node<T> current;
	private int size;

	public LinkedList() {
		head = current = null;
	}
	
	public boolean full() {
		return false;
	}

	public boolean empty() {
		return head == null;
	}

	public boolean last() {
		return current.next == null;
	}
	
	public int getSize() {
		return size;
	}
	
	public void findFirst() {
		current = head;
	}

	public void findNext() {
		if (current == null)
			return;
		if (current.next != null)
			current = current.next;
	}

	public T retrieve() {
		return current.data;
	}

	public void update(T val) {
		current.data = val;
	}

	public void insert(T val) {
		Node<T> tmp;
		if (empty()) {
			current = head = new Node<T>(val);
		} else {
			tmp = current.next;
			current.next = new Node<T>(val);
			current = current.next;
			current.next = tmp;
		}
		size = size + 1;
	}

	public void remove() {
		if (empty())
			return;
		
		if (current == head) {
			head = head.next;
		} else {
			Node<T> tmp = head;
			while (tmp.next != current)
				tmp = tmp.next;
			tmp.next = current.next;
		}
		if (current.next == null)
			current = head;
		else
			current = current.next;
		
		size = size - 1;
	}

	

}
