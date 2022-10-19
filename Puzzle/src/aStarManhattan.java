public class aStarManhattan extends aStar {

	public aStarManhattan(int[][] board) {
		super(board);
	}

	@Override
	public int calcHeuristic(int[][] board) {
		int heuristic = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int correctY = board[i][j] / 3, correctX = board[i][j] % 3;
				heuristic += Math.abs(j - correctX) + Math.abs(i - correctY);
			}
		}
		return heuristic;
	}
}
