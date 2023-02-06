public class ArrayStack<T> {
	private T[] nodes;
	private int top;
	private int maxSize;

	public ArrayStack() {
		this(100);
	}

	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		this.top = -1;
		this.nodes = (T[]) new Object[maxSize];
	}

	public boolean full() {
		return top == (maxSize - 1);
	}

	public boolean empty() {
		return (top == -1);
	}
	
	public int size() {
		return (top + 1);
	}

	public T pop() {
		if (!empty())
			return nodes[top--];
		else
			return null;
	}

	public T topElem() {
		if (!empty())
			return nodes[top];
		else
			return null;
	}

	public void push(T e) {
		if (!full())
			nodes[++top] = e;
	}

	public String toString() {
		String str = "";
		for (int i = 0; i <= top; i++)
			if (nodes[i] != null)
			str += nodes[i] + ", ";
		
		return str;
	}

}
