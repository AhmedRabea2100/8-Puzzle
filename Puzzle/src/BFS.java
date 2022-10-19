import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFS {

	private State root;
	private State currentState;
	private Queue<State> fringe = new LinkedList<>();
	private Set<String> exploredStates = new HashSet<>();

	public BFS(int[][] board) {
		root = new State(board, null, 0, "");
	}

	public State solve() {
		fringe.add(root);
		while (!fringe.isEmpty()) {
			currentState = fringe.poll();
			exploredStates.add(currentState.stringify());
			if (currentState.isGoal())
				return currentState;

			for (State neighbor : currentState.getNeighbors())
				if (!exploredStates.contains(neighbor.stringify()) && !fringe.contains(neighbor))
					fringe.add(neighbor);
		}
		return currentState;
	}

	public int getNumExploredNodes() {
		return exploredStates.size();
	}
}