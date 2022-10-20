import java.util.HashSet;
import java.util.Set;

import datastructures.Fringe;

public class Search {
	protected State root;
	protected Fringe<State> fringe;
	protected Set<String> exploredStates = new HashSet<>();
	private Set<String> fringeSet = new HashSet<>();
	protected int maxDepth = 0;

	public Search(Fringe<State> fring, int[][] board) {
		root = new State(board, null, 0, "");
		this.fringe = fring;
	}

	public State solve() {
		fringe.add(root);
		fringeSet.add(root.stringify());
		State currentState = null;

		while (!fringe.isEmpty()) {
			currentState = fringe.remove();
			maxDepth = Math.max(maxDepth, currentState.getCost());
			fringeSet.remove(currentState.stringify());
			exploredStates.add(currentState.stringify());
			if (getNumExploredNodes() == 181440)
				return null;
			if (currentState.isGoal())
				return currentState;

			for (State neighbor : currentState.getNeighbors()) {
				if (!exploredStates.contains(neighbor.stringify()) && !fringeSet.contains(neighbor.stringify())) {
					fringe.add(neighbor);
					fringeSet.add(neighbor.stringify());
				}
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