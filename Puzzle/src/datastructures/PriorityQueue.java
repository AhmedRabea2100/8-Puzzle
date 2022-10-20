package datastructures;

import java.util.Comparator;

public class PriorityQueue<T> implements Fringe<T> {

	private java.util.PriorityQueue<T> queue;

	public PriorityQueue(Comparator<T> comparator) {
		queue = new java.util.PriorityQueue<>(comparator);
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
}
