public class Main {
	public static void main(String[] args) {
		int[][] state = { { 4, 1, 2 }, { 3, 0, 5 }, { 7, 6, 8 } };
		aStarManhattan ecludian = new aStarManhattan(state);
		State currentNode = ecludian.solve();
		Print sol = new Print(currentNode, ecludian);
		sol.print();
	}
}