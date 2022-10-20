import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter initial state: \n");
		int[][] state = new int[3][3];
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				state[i][j] = in.nextInt();

		System.out.println("Choose algorithm to Solve : ");
		System.out.println("1) DFS\n2) BFS\n3) A* Manhattan Distances\n4) A* Euclidean Distances");
		int alg = in.nextInt();
		in.close();
		Search s = null;
		switch (alg) {
			case 1 -> s = new DFS(state);
			case 2 -> s = new BFS(state);
			case 3 -> s = new aStarManhattan(state);
			case 4 -> s = new aStarEuclidean(state);
			default -> {
				System.out.println("Wrong Selection\nExiting");
				System.exit(-1);
			}
		}

		long start = System.currentTimeMillis();
		State currentNode = s.solve();
		long end = System.currentTimeMillis();
		if (currentNode == null)
			System.out.println("This method cannot solve this problem.");
		else {
			Print sol = new Print(currentNode, s);
			sol.print();
		}
		System.out.println("time = " + (end - start) + " ms");
	}
}