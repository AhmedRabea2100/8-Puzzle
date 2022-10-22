package datastructures;

public interface Fringe<T> {

	public void add(T e);

	public T remove();

	public boolean isEmpty();
	public void remove(T e);
}
