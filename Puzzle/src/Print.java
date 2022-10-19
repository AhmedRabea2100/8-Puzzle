import java.util.Stack;

public class Print {

	private State state;
	private BFS bfs;

	public Print(State state, BFS bfs) {
		this.state = state;
		this.bfs = bfs;
	}

	public void print() {
		printStates();
		printPath();
		printCost();
		printNumExploredStates();
		printMaxDepth();
	}

	private void printStates() {
		Stack<State> stack = new Stack<>();
		while (state != null) {
			stack.push(state);
			state = state.getParent();
		}
		while (!stack.isEmpty()) {
			state = stack.pop();
			printCurrentState();
		}
	}

	private void printCurrentState() {
		System.out.println("Current state after: " + state.getPath());
		System.out.println(state);
		System.out.println("------------------------------");
	}

	private void printPath() {
		System.out.println("Path to goal: " + state.getPath());
	}

	private void printCost() {
		System.out.println("Cost = " + state.getCost());
	}

	private void printNumExploredStates() {
		System.out.println("Number of expanded nodes = " + bfs.getNumExploredNodes());
	}
	private void  printMaxDepth(){
		System.out.println("Max depth = "+bfs.getMaxDepth());
	}
}