import java.util.ArrayList;
import java.util.List;

public class Node {

	private int[][] state = new int[3][3];
	private int x;
	private int y;
	private Node parent;
	private List<Node> neighbours = new ArrayList<>();
	private int cost;
	private String path = "";
	private int depth;
	private int maxDepth = 0;

	// right, left, down,up
	private int[] row = { 0, 0, 1, -1 };
	private int[] col = { 1, -1, 0, 0 };

	Node(int x, int y, Node parent, int[][] state, int cost, String path) {
		this.x = x;
		this.y = y;
		this.parent = parent;
		this.state = state;
		this.cost = cost;
		this.path = path;
		this.maxDepth = Math.max(this.maxDepth, this.cost);
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
					Node tempNode = new Node(tempX, tempY, currNode, tempState, cost + 1, path + " R");
					neighbours.add(tempNode);
				} else if (i == 1) {
					Node tempNode = new Node(tempX, tempY, currNode, tempState, cost + 1, path + " L");
					neighbours.add(tempNode);
				} else if (i == 2) {
					Node tempNode = new Node(tempX, tempY, currNode, tempState, cost + 1, path + " D");
					neighbours.add(tempNode);
				} else {
					Node tempNode = new Node(tempX, tempY, currNode, tempState, cost + 1, path + " U");
					neighbours.add(tempNode);
				}
			}
		}
	}

	private void copyMatrix(int[][] state, int[][] tempState) {
		for (int k = 0; k < 3; k++) {
			for (int l = 0; l < 3; l++) {
				tempState[k][l] = state[k][l];
			}
		}
	}

	private static boolean isSafe(int x, int y) {
		return (x >= 0 && x < 3 && y >= 0 && y < 3);
	}

	public List<Node> getNeighbors(Node currNode) {
		getAllNeighbours(currNode);
		return neighbours;
	}

	public void setNeighbours(List<Node> neighbours) {
		this.neighbours = neighbours;
	}

	public int[][] getState() {
		return state;
	}

	public void setState(int[][] state) {
		this.state = state;
	}

	public String getPath() {
		return path;
	}

	public int getCost() {
		return cost;
	}

	public int getMaxDepth() {
		return maxDepth;
	}

	public Node getParent() {
		return parent;
	}
}
