public class Main {

	public static void main(String[] args) {
		int[][] state = { { 2, 1, 3 }, { 6, 0, 7 }, { 8, 5, 4 } };
		Search s = new aStarManhattan(state);
		long start = System.currentTimeMillis();
		State currentNode = s.solve();
		long end = System.currentTimeMillis();
		if (currentNode == null)
			System.out.println("NO Sol");
		else {
			Print sol = new Print(currentNode, s);
			sol.print();
		}
		System.out.println("time = " + (end - start) + " ms");
	}
}