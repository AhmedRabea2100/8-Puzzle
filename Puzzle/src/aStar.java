import  java.util.*;

public abstract class aStar {
    private State root;
    private PriorityQueue<State> fringe = new PriorityQueue<>(Comparator.comparingInt(a -> (a.getCost() + calcHeuristic(a.getBoard()))));
    private HashSet<String> exploredNodes = new HashSet<>();
    //private HashSet<String> inFringe = new HashSet<>();

    public aStar(int[][] board){
        root = new State(board, null, 0, "");
    }

    public State solve(){
        fringe.add(root);
        State currentNode = null;
        while (!fringe.isEmpty()){
            currentNode = fringe.poll();
            //inFringe.remove(currentNode.arrToString());
            System.out.println(currentNode.getCost());
            exploredNodes.add(currentNode.arrToString());
            if(currentNode.isGoal())
                return currentNode;
            for(State neighbour : currentNode.getNeighbors(currentNode)) {
                if (!exploredNodes.contains(neighbour.arrToString())) {
                    fringe.add(neighbour);
                }
            }
        }
        return currentNode;
    }

    public int getNumExploredNodes(){
        return exploredNodes.size();
    }
    public abstract  int calcHeuristic(int[][] board);
}
