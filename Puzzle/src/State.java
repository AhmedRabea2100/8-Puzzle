import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class State {
	private int[][] board;
	private Point emptyTile;
	private State parent;
	private int cost;
	private String path;
	public enum Direction {
		Left(new Point(-1, 0), "L"),
		UP(new Point(0, -1), "U"),
		Right(new Point(1, 0), "R"),
		Down(new Point(0, 1), "D");

		private Point direction;
		private String path;

		private Direction(Point direction, String path) {
			this.direction = direction;
			this.path = path;
		}

		public int getX() {
			return direction.x;
		}

		public int getY() {
			return direction.y;
		}

		public String getPath() {
			return path;
		}
	};

	State(int[][] board, State parent, int cost, String path) {
		this.board = board;
		this.parent = parent;
		emptyTile = findEmptyTile();
		this.cost = cost;
		this.path = path;
	}

	private Point findEmptyTile() {
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				if (board[y][x] == 0)
					return new Point(x, y);
			}
		}
		return null;
	}

	private List<State> findNeighbours(State state) {
		List<State> neighbours = new ArrayList<>();
		for(Direction direction : Direction.values()) {
			if(isSafe(emptyTile.y + direction.getY(), emptyTile.x + direction.getX()))
				neighbours.add(swap(direction, state));
		}
		return neighbours;
	}

	private State swap(Direction direction, State state) {
		int[][] newBoard = new int[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)
				newBoard[i][j] = board[i][j];
		}
		newBoard[emptyTile.y + direction.getY()][emptyTile.x + direction.getX()] = board[emptyTile.y][emptyTile.x];
		newBoard[emptyTile.y][emptyTile.x] = board[emptyTile.y + direction.getY()][emptyTile.x + direction.getX()];
		return new State(newBoard, state, cost + 1, path + direction.getPath());
	}

	private static boolean isSafe(int y, int x) {
		return (x >= 0 && x < 3 && y >= 0 && y < 3);
	}

	public String arrToString(){
		String str = "";
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				str += Integer.toString(board[i][j]);
		return str;
	}

	public boolean isGoal(){
		return "012345678".equals(arrToString());
	}

	public int[][] getBoard() {
		return board;
	}

	public State getParent() {
		return parent;
	}

	public List<State> getNeighbors(State state) {
		return findNeighbours(state);
	}

	public String getPath() {
		return path;
	}

	public int getCost() {
		return cost;
	}

}
