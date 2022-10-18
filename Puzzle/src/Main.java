
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        int[][] state = {{1,2,5},{3,4,0},{6,7,8}};
        BFS bfs = new BFS(state);
        Node currentNode = bfs.solve();
        Print sol = new Print(currentNode,bfs);
        sol.print();

    }
}