import datastructures.Queue;

public class BFS extends Search {

	public BFS(int[][] board) {
		super(new Queue<>(), board);
	}
}