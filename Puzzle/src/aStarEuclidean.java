public class aStarEuclidean extends aStar {
	public aStarEuclidean(int[][] board) {
		super(board);
	}

	@Override
	public int calcHeuristic(int[][] board) {
		int heuristic = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int correctY = board[i][j] / 3, correctX = board[i][j] % 3;
				heuristic += Math.sqrt((j - correctX) * (j - correctX) + (i - correctY) * (i - correctY));
			}
		}
		return heuristic;
	}
}
