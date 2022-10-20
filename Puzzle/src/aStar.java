import java.util.Comparator;

import datastructures.PriorityQueue;

public abstract class aStar extends Search {

	public aStar(int[][] board) {
		super(null, board);
		fringe = new PriorityQueue<State>(Comparator.comparingInt(a -> (a.getCost() + calcHeuristic(a.getBoard()))));
	}

	@Override
	public State solve() {
		fringe.add(root);
		State currentState = null;
		while (!fringe.isEmpty()) {
			currentState = fringe.remove();
			maxDepth = Math.max(maxDepth, currentState.getCost());
			// Mark the current state as visited
			exploredStates.add(currentState.stringify());

			// Return null if maximum number of states that can be explored is reached
			if (getNumExploredNodes() == 181440)
				return null;

			// The goal state has been found.
			if (currentState.isGoal())
				return currentState;

			/*
			 * Loop through the successors.
			 * Check if they've already been evaluated or currently in the fringe,
			 * if not, add them to the fringe.
			 */
			for (State neighbor : currentState.getNeighbors()) {
				if (!exploredStates.contains(neighbor.stringify()))
					fringe.add(neighbor);
			}
		}
		return currentState;
	}

	public abstract int calcHeuristic(int[][] board);
}
