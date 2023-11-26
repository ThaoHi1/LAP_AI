package lap8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphaBetaSearchAlgo implements ISearchAlgo {

	// function ALPHA-BETA-SEARCH(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state, Integer.MIN_VALUE , Integer.MAX_VALUE)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		int v = maxValue(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println("result"+v);

	}

	// function MAX-VALUE(state, alpha, beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- MIN_VALUE;
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s, alpha, beta))
	// if v >= beta then return v
	// alpha <- MAX(alpha, v)
	// return v

	public int maxValue(Node node, int alpha, int beta) {
		if (node.isTerminal()) {
			return node.getValue();
		} else {

			int v = Integer.MIN_VALUE;
			List<Node> list = node.getChildren();
			list.sort(Node.LabelComparator);
			for (Node n : list) {
				v = Math.max(v, minValue(n, alpha, beta));
				if (v >= beta) {

					for (int i = list.indexOf(n) + 1; i < list.size(); i++) {
						System.out.println("pruned: "+list.get(i) + "(" + node.getLabel() + ")");
					}

					return v;
				} else {

					alpha = Math.max(alpha, v);

				}
			}
			return v;
		}
	}
	// function MIN-VALUE(state, alpha , beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s, alpha , beta))
	// if v <= alpha then return v
	// beta <- MIN(beta ,v)
	// return v

	public int minValue(Node node, int alpha, int beta) {
		if (node.isTerminal()) {
			return node.getValue();
		} else {
			int v = Integer.MAX_VALUE;
			List<Node> list = node.getChildren();
			list.sort(Node.LabelComparator);
			for (Node n : list) {
				v = Math.min(v, maxValue(n, alpha, beta));
				if (v <= alpha) {
					for (int i = list.indexOf(n) + 1; i < list.size(); i++) {
						System.out.println("pruned: "+list.get(i) + "(" + node.getLabel() + ")");
					}
					return v;
				} else {
					beta = Math.min(beta, v);
				}
			}
			return v;
		}
	}
}
