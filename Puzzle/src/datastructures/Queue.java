package datastructures;

public class Queue<T> implements Fringe<T> {

	private java.util.ArrayDeque<T> queue;

	public Queue() {
		queue = new java.util.ArrayDeque<>();
	}

	@Override
	public void add(T e) {
		queue.add(e);
	}

	@Override
	public T remove() {
		return queue.poll();
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public void remove(T e) {
		queue.remove(e);
	}
}
