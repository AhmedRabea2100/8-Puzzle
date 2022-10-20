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
			// Mark the current state as visited
			exploredStates.add(currentState.stringify());
			if (getNumExploredNodes() == 181440)
				return null;
			maxDepth = Math.max(maxDepth, currentState.getCost());
			if (currentState.isGoal())
				// The goal state has been found.
				return currentState;
			/*
			 * Loop through the successors
			 * check if they've already been evaluated, and if not, add them to the priority queue
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
