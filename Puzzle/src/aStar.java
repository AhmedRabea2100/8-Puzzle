import java.util.Comparator;
import java.util.HashMap;

import datastructures.PriorityQueue;

public abstract class aStar extends Search {

	HashMap<String, Integer> costs;

	public aStar(int[][] board) {
		super(null, board);
		fringe = new PriorityQueue<State>(Comparator.comparingInt(a -> (a.getCost() + calcHeuristic(a.getBoard()))));
		costs = new HashMap<>();
	}

	@Override
	public State solve() {
		fringe.add(root);
		costs.put(root.stringify(), 0);
		State currentState = null;
		while (!fringe.isEmpty()) {
			currentState = fringe.remove();
			costs.remove(currentState.stringify());
			if(exploredStates.contains(currentState.stringify()))
				continue;
			exploredStates.add(currentState.stringify());
			if (getNumExploredNodes() == 181440)
				return null;
			maxDepth = Math.max(maxDepth, currentState.getCost());
			if (currentState.isGoal())
				return currentState;

			for (State neighbor : currentState.getNeighbors()) {
				if(!exploredStates.contains(neighbor.stringify())) {

					if(costs.containsKey(neighbor.stringify())) {
						if(neighbor.getCost() < costs.get(neighbor.stringify())) {
							costs.put(neighbor.stringify(), neighbor.getCost());
							fringe.remove(neighbor);
						}else {
							continue;
						}
					}
					fringe.add(neighbor);
				}
			}
		}
		return currentState;
	}

	public abstract int calcHeuristic(int[][] board);
}
