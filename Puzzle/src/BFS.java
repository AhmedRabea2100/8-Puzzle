import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFS {

	private State root;
	private State currentState;
	private Queue<State> fringe = new LinkedList<>();
	private Set<String> exploredStates = new HashSet<>();
	private Set<String> fringeSet = new HashSet<>();
	private int maxDepth = 0;

	public BFS(int[][] board) {
		root = new State(board, null, 0, "");
	}

	public State solve() {
		fringe.add(root);
		fringeSet.add(root.stringify());
		while (!fringe.isEmpty()) {
			currentState = fringe.poll();
			maxDepth = Math.max(maxDepth, currentState.getCost());
			fringeSet.remove(currentState.stringify());
			exploredStates.add(currentState.stringify());
			if (currentState.isGoal())
				return currentState;

			for (State neighbor : currentState.getNeighbors())
				if (!exploredStates.contains(neighbor.stringify()) && !fringeSet.contains(neighbor.stringify())) {
					fringe.add(neighbor);
					fringeSet.add(neighbor.stringify());
				}
		}
		return currentState;
	}

	public int getNumExploredNodes() {
		return exploredStates.size();
	}

	public int getMaxDepth() {
		return maxDepth;
	}
}