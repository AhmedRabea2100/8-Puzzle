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
	/**
	 * Search for the goal state using BFS/DFS algorithm.
	 * initialState
	 * starting state.
	 * explored states
	 * exploredStates object to store number of expanded nodes in it.
	 * @return
	 * currentNode if goal state is reached.
	 * null otherwise.
	 */

	public State solve() {
		fringe.add(root);
		fringeSet.add(root.stringify());
		State currentState = null;

		while (!fringe.isEmpty()) {
			currentState = fringe.remove();
			maxDepth = Math.max(maxDepth, currentState.getCost());
			fringeSet.remove(currentState.stringify());
			// Mark the current state as visited
			exploredStates.add(currentState.stringify());

			if (getNumExploredNodes() == 181440)
				return null;
			if (currentState.isGoal())
				// The goal state has been found.
				return currentState;
			/*
			 * Loop through the successors
			 * check if they've already been evaluated, and if not, add them to the fringe
			 */
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