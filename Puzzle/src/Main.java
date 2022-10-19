public class Main {

	public static void main(String[] args) {
		int[][] state = { { 0, 2, 3 }, { 1, 4, 5 }, { 7, 8, 6 } };
		BFS bfs = new BFS(state);
		State currentNode = bfs.solve();
		Print sol = new Print(currentNode, bfs);
		sol.print();
	}
}