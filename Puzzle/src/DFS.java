import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Set;

public class DFS {
    private State root;
    private State currentState;
    private Stack<State> fringe = new Stack<>();
    private Set<String> exploredStates = new HashSet<>();
    private Set<String> fringeSet = new HashSet<>();
    private int maxDepth = 0;

    public DFS(int[][] board) {
        root = new State(board, null, 0, "");
    }

    public State solve() {
        fringe.add(root);
        fringeSet.add(root.stringify());
        while (!fringe.isEmpty()) {
            currentState = fringe.pop();
            maxDepth = Math.max(maxDepth, currentState.getCost());
            fringeSet.remove(currentState.stringify());
            exploredStates.add(currentState.stringify());
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