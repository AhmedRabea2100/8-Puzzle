import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFS {

	private State root;
	private State currentState;
	private int[][] goalState = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 } };
	private Queue<State> fringe = new LinkedList<>();
	private Set<String> exploredStates = new HashSet<>();

	public BFS(int[][] board) {
		root = new State(board, null, 0, "");
	}

	private String stringify(int[][] board) {
		String str = "";
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				str += Integer.toString(board[i][j]);
		return str;
	}

	private boolean isGoal() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (currentState.getBoard()[i][j] != goalState[i][j])
					return false;
		return true;
	}

	public State solve() {
		fringe.add(root);
		while (!fringe.isEmpty()) {
			currentState = fringe.poll();
			exploredStates.add(stringify(currentState.getBoard()));
			if (isGoal())
				return currentState;

			for (State neighbor : currentState.getNeighbors())
				if (!exploredStates.contains(stringify(neighbor.getBoard())) && !fringe.contains(neighbor))
					fringe.add(neighbor);

		}
		return currentState;
	}

	public int getNumExploredNodes() {
		return exploredStates.size();
	}
}