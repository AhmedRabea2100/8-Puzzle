package datastructures;

public class Stack<T> implements Fringe<T> {

	private java.util.Stack<T> stack;

	public Stack() {
		stack = new java.util.Stack<>();
	}

	@Override
	public void add(T e) {
		stack.push(e);
	}

	@Override
	public T remove() {
		return stack.pop();
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public void remove(T e) {
		stack.remove(e);
	}
}
