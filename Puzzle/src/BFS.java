import java.util.*;

public class BFS {
    int[][] initialState = new int[3][3];
    State root;
    State currentNode;
    int[][] goalState = {{0,1,2},{3,4,5},{6,7,8}};
    Queue<State> fringe = new LinkedList<>();
    Set<String> exploredNodes = new HashSet<>();


    public BFS(int[][] state){

        root = new State(state, null,0,"");
    }
    private String arrToString(int[][] state){
        String str = "";
        for (int i=0;i<3;i++)
            for (int j=0;j<3;j++)
                str += Integer.toString(state[i][j]);
        return str;
    }
    private boolean isGoal(){
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                if(currentNode.getBoard()[i][j] != goalState[i][j])
                    return false;
        return true;
    }

    public State solve(){
        fringe.add(root);
        while (!fringe.isEmpty()){

            currentNode = fringe.poll();
            exploredNodes.add(arrToString(currentNode.getBoard()));
            if(isGoal())
                return currentNode;

            for(var neighbour : currentNode.getNeighbors(currentNode))
                if(!exploredNodes.contains(arrToString(neighbour.getBoard())) && !fringe.contains(neighbour))
                    fringe.add(neighbour);

        }
        return currentNode;
    }

    public Set<String> getExploredNodes() {
        return exploredNodes;
    }
}