import java.util.Stack;

public class Print {
	private State state;
	private aStarManhattan s;

	public Print(State state, aStarManhattan s) {
		this.state = state;
		this.s = s;
	}

	public void print() {
		printSteps();
		printAnswerDetails();
	}

	private void printSteps() {
		Stack<State> stack = new Stack<>();
		while (state != null) {
			stack.push(state);
			state = state.getParent();
		}
		while (!stack.isEmpty()) {
			state = stack.pop();
			printStep();
		}
	}

	private void printStep() {
		System.out.println("Current state after: " + state.getPath());
		System.out.println(state);
		System.out.println("------------------------------");
	}

	private void printAnswerDetails() {
		System.out.println("Path to goal: " + state.getPath());
		System.out.println("Cost = " + state.getCost());
		System.out.println("Number of expanded nodes = " + s.getNumExploredNodes());
		System.out.println("Max depth = " + s.getMaxDepth());
	}
}