import  java.util.*;


public abstract class aStar {
    PriorityQueue<State> fringe = new PriorityQueue<State>((a, b) -> a.getCost() - b.getCost());
    HashSet<String> exploredNodes = new HashSet<>();
    public State solve(){
        return  new State(new int[3][3], null,0,"");
    }
    public abstract  int calcHeuristic(int[][] board);
}
