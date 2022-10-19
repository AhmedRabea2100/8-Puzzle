import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public abstract class aStar {
	private State root;
	private int maxDepth = 0;
	private PriorityQueue<State> fringe = new PriorityQueue<>(
			Comparator.comparingInt(a -> (a.getCost() + calcHeuristic(a.getBoard()))));
	private HashSet<String> exploredStates = new HashSet<>();

	public aStar(int[][] board) {
		root = new State(board, null, 0, "");
	}

	public State solve() {
		fringe.add(root);
		State currentState = null;
		while (!fringe.isEmpty()) {
			currentState = fringe.poll();
//			if(exploredNodes.contains(currentState.stringify()) && !currentState.isGoal())
//				continue;
			exploredStates.add(currentState.stringify());
			maxDepth = Math.max(maxDepth, currentState.getCost());
			if (currentState.isGoal())
				return currentState;

			for (State neighbor : currentState.getNeighbors()) {
				if (!exploredStates.contains(neighbor.stringify()))
					fringe.add(neighbor);
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

	public abstract int calcHeuristic(int[][] board);
}
