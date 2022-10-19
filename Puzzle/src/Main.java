public class Main {

	public static void main(String[] args) {
		int[][] state = { { 0, 1, 2 }, { 5, 3, 4 }, { 6, 7, 8 } };
		aStarManhattan s = new aStarManhattan(state);
		long start = System.currentTimeMillis();
		State currentNode = s.solve();
		long end = System.currentTimeMillis();
		System.out.println("time = " + (end - start));
		Print sol = new Print(currentNode, s);
		sol.print();
	}
}