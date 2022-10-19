public class Main {
	public static void main(String[] args) {
		int[][] state = { { 1, 2, 5 }, { 3, 4, 0 }, { 6, 7, 8 } };
		BFS bfs = new BFS(state);
		State currentNode = bfs.solve();
		Helpers sol = new Helpers(currentNode, bfs);
		sol.print();
	}
}