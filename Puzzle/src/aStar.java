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

	public abstract int calcHeuristic(int[][] board);
}
