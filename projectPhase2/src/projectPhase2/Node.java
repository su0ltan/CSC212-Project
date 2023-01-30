package projectPhase2;
public class Node<T> {
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public T data;
	public Node<T> next;
	
	public Node() {
		data =null;
		next =null;
	}
	
	public Node (T val) {
		data = val;
		next = null;
		}


}