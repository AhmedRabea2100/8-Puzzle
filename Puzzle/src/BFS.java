import java.util.*;

public class BFS {
    State root;
    Queue<State> fringe = new LinkedList<>();
    Set<String> exploredNodes = new HashSet<>();
    public BFS(int[][] board){
        root = new State(board, null,0,"");
    }
    State currentNode;
    public State solve(){
        fringe.add(root);
        while (!fringe.isEmpty()){
            currentNode = fringe.poll();
            exploredNodes.add(currentNode.arrToString());
            if(currentNode.isGoal())
                return currentNode;
            for(var neighbour : currentNode.getNeighbors(currentNode))
                if(!exploredNodes.contains(neighbour.arrToString()) && !fringe.contains(neighbour))
                    fringe.add(neighbour);
        }
        return currentNode;
    }
    public int getExploredNodes() {
        return exploredNodes.size();
    }
}