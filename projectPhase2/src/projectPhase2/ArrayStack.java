package projectPhase2;
public class ArrayStack<T> {

	private int maxsize;
	private int top;
	private T[] nodes;

	public ArrayStack() {


		top = -1;
		nodes = (T[]) new Object[4];
	}

	public boolean empty() {
		return top == -1;
	}

	public boolean full() {
		return top == maxsize - 1;
	}

	public void push(T e) {
		nodes[++top] = e;
	}

	public T pop() {
		return nodes[top--];
	}

}