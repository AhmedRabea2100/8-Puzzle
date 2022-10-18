import java.util.*;

public class BFS {
    int[][] initialState = new int[3][3];
    Node root;
    Node currentNode;
    int[][] goalState = {{0,1,2},{3,4,5},{6,7,8}};
    Queue<Node> fringe = new LinkedList<>();
    Set<String> exploredNodes = new HashSet<>();


    public BFS(int[][] state){
        for(int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                if(state[i][j]==0) {
                    root = new Node(i,j,null,initialState,0,"");
                }
                initialState[i][j] = state[i][j];
            }
        }
        root.setState(initialState);
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
                if(currentNode.getState()[i][j] != goalState[i][j])
                    return false;
        return true;
    }

    public Node solve(){
        fringe.add(root);
        while (!fringe.isEmpty()){

            currentNode = fringe.poll();
            exploredNodes.add(arrToString(currentNode.getState()));
            if(isGoal())
                return currentNode;

            for(var neighbour : currentNode.getNeighbors(currentNode))
                if(!exploredNodes.contains(arrToString(neighbour.getState())) && !fringe.contains(neighbour))
                    fringe.add(neighbour);

        }
        return currentNode;
    }

    public Set<String> getExploredNodes() {
        return exploredNodes;
    }
}