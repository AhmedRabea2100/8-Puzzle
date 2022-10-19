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
		Right(new Point(1, 0), "R"),
		Left(new Point(-1, 0), "L"),
		UP(new Point(0, -1), "U"),
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

	public String stringify() {
		String str = "";
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				str += Integer.toString(board[i][j]);
		return str;
	}

	public int[][] getBoard() {
		return board;
	}

	public State getParent() {
		return parent;
	}

	public List<State> getNeighbors() {
		List<State> neighbors = new ArrayList<>();
		for (Direction direction : Direction.values()) {
			if (isSafe(emptyTile.y + direction.getY(), emptyTile.x + direction.getX()))
				neighbors.add(swap(direction));
		}
		return neighbors;
	}

	private boolean isSafe(int y, int x) {
		return (x >= 0 && x < 3 && y >= 0 && y < 3);
	}

	private State swap(Direction direction) {
		int[][] newBoard = new int[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)
				newBoard[i][j] = board[i][j];
		}

		newBoard[emptyTile.y + direction.getY()][emptyTile.x + direction.getX()] = board[emptyTile.y][emptyTile.x];
		newBoard[emptyTile.y][emptyTile.x] = board[emptyTile.y + direction.getY()][emptyTile.x + direction.getX()];
		return new State(newBoard, this, cost + 1, path + direction.getPath());
	}

	public boolean isGoal() {
		return "012345678".equals(stringify());
	}

	public String getPath() {
		return path;
	}

	public int getCost() {
		return cost;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("+---+---+---+" + "\n");
		for (int i = 0; i < 3; i++) {
			builder.append("| ");
			for (int j = 0; j < 3; j++) {
				if(board[i][j] == 0)
					builder.append(" " + " | ");
				else
					builder.append(board[i][j] + " | ");
			}
				builder.append("\n"+"+---+---+---+");
			if(i != 2)
				builder.append("\n");
		}
		return builder.toString();
	}
}
