public class Main {

	public static void main(String[] args) {
		int[][] state = { { 1, 0, 2 }, { 5, 3, 4 }, { 6, 7, 8 } };
		Search s = new DFS(state);
		long start = System.currentTimeMillis();
		State currentNode = s.solve();
		long end = System.currentTimeMillis();
		Print sol = new Print(currentNode, s);
		sol.print();
		System.out.println("time = " + (end - start) + " ms");
	}
}