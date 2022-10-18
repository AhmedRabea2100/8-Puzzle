
import java.util.Stack;

public class Print {
    static Node currentNode;
    static BFS  bfs;
    public Print(Node currentNode,BFS bfs){
        this.currentNode = currentNode;
        this.bfs = bfs;
    }
    private static void printCurrentState() {
        System.out.println("Current state after: " + currentNode.getPath());
        for(int i = 0;i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                System.out.print(currentNode.getState()[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("------------------------------");
    }
    private static   void  printPath(){
        Stack<Node> sol = new Stack<>();
        sol.push(currentNode);
        currentNode = currentNode.getParent();
        while (currentNode.getParent() != null) {
            sol.push(currentNode);
            currentNode = currentNode.getParent();
        }
        sol.push(currentNode);
        int size = sol.size();
        for (int i=0;i<size;i++){
            currentNode = sol.pop();
            printCurrentState();
        }
    }

    private   static void printCost(){
        System.out.println(currentNode.getCost());
    }
    private static void path(){
        System.out.println(currentNode.getPath());
    }
    private static void printExploredNodes(){
        System.out.println(bfs.getExploredNodes().size());
    }



    public void print(){
        printPath();
        path();
        printCost();
        printExploredNodes();
    }


}