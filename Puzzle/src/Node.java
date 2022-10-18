

import java.util.*;

public class Node {
    private int x;
    private int y;
    private Node parent;
    private int[][] state = new int[3][3];

    public void setNeighbours(List<Node> neighbours) {
        this.neighbours = neighbours;
    }

    private List<Node> neighbours = new ArrayList<>();
    private String path = "";
    private int cost;
    private int depth;

    public int getMaxDepth() {
        return maxDepth;
    }
    private int maxDepth = 0;

    Node(int x, int y,Node parent, int[][] state, int cost, String path) {
        this.x = x;
        this.y = y;
        this.parent = parent;
        this.state = state;
        this.cost = cost;
        this.path = path;
        this.maxDepth = Math.max(this.maxDepth,this.cost);

    }

    private void copyMatrix(int[][] state, int[][] tempState) {
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                tempState[k][l] = state[k][l];
            }
        }
    }


    // right, left, down,up
    private int row[] = {0, 0, 1, -1};
    private int col[] = {1, -1, 0, 0};

    private static boolean isSafe(int x, int y) {
        return (x >= 0 && x < 3 && y >= 0 && y < 3);
    }

    private void getAllNeighbours(Node currNode) {
        for (int i = 0; i < 4; i++) {
            int[][] tempState = new int[3][3];
            copyMatrix(state, tempState);
            int tempX = x + row[i];
            int tempY = y + col[i];
            if (isSafe(tempX, tempY)) {
                int temp = tempState[x][y];
                tempState[x][y] = tempState[tempX][tempY];
                tempState[tempX][tempY] = temp;
                if (i == 0) {
                    Node tempNode = new Node(tempX, tempY,currNode,tempState, cost + 1, path + " R");
                    neighbours.add(tempNode);
                } else if (i == 1) {
                    Node tempNode = new Node(tempX, tempY,currNode ,tempState, cost + 1, path + " L");
                    neighbours.add(tempNode);
                } else if (i == 2) {

                    Node tempNode = new Node(tempX, tempY, currNode,tempState, cost + 1, path + " D");
                    neighbours.add(tempNode);
                } else {
                    Node tempNode = new Node(tempX, tempY, currNode,tempState, cost + 1, path + " U");
                    neighbours.add(tempNode);
                }

            }
        }

    }


    public List<Node> getNeighbors(Node currNode) {

        getAllNeighbours(currNode);
        /*goToUp();
        goToLeft();
        goToRight();
        goToDown();*/
        return neighbours;
    }
    public String getPath(){
        return path;
    }
    public int getCost(){
        return cost;
    }
    public void setState(int[][] state) {
        this.state = state;
    }
    public int[][] getState() {
        return state;
    }
    public Node getParent(){
        return parent;
    }




//    private void goToRight(){
//        int[][] tempState = new int[3][3];
//        copyMatrix(state,tempState);
//        if(y+1<3){
//            int temp = tempState[x][y];
//            tempState[x][y] = tempState[x][y+1];
//            tempState[x][y+1] = temp;
//            Node tempNode = new Node(x,y+1,tempState,cost+1,path+" R");
//            neighbours.add(tempNode);
//        }
//    }
//    private void goToLeft(){
//        int[][] tempState = new int[3][3];
//        copyMatrix(state,tempState);
//        if(y-1>=0){
//            int temp = tempState[x][y];
//            tempState[x][y] = tempState[x][y-1];
//            tempState[x][y-1] = temp;
//            Node tempNode = new Node(x,y-1,tempState,cost+1,path+" L");
//            neighbours.add(tempNode);
//        }
//    }
//    private void goToUp(){
//        int[][] tempState = new int[3][3];
//        copyMatrix(state,tempState);
//        if(x-1>=0){
//            int temp = tempState[x][y];
//            tempState[x][y] = tempState[x-1][y];
//            tempState[x-1][y] = temp;
//            Node tempNode = new Node(x-1,y,tempState,cost+1,path+" U");
//            neighbours.add(tempNode);
//        }
//    }
//    private void goToDown(){
//        int[][] tempState = new int[3][3];
//        copyMatrix(state,tempState);
//        if(x+1<3){
//            int temp = tempState[x][y];
//            tempState[x][y] = tempState[x+1][y];
//            tempState[x+1][y] = temp;
//            Node tempNode = new Node(x+1,y,tempState,cost+1,path+" D");
//            neighbours.add(tempNode);
//        }
//    }

}