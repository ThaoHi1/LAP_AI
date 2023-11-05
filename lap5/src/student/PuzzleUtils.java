package student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PuzzleUtils {

	// distance between P1(x1, y1) and P2(x2, y2)
	public static int manhattanDistance(int[] current, int[] target) {
		return Math.abs(target[0] - current[0]) + Math.abs(target[1] - current[1]);
	}

	// Compare 2 nodes by heuristic values
	public static Comparator<Node> HeuristicComparatorByH = new Comparator<Node>() {

		@Override
		public int compare(Node a, Node b) {
			return a.getH() - b.getH();
		}
	};
	// Compare 2 nodes by F values
	public static Comparator<Node> HeuristicComparatorByF = new Comparator<Node>() {

		@Override
		public int compare(Node a, Node b) {
			return a.getF() - b.getF();
		}
	};
	public static List<Node> print(Node e) {
		if(e!=null) {
			List<Node>result = new ArrayList<Node>();
			result.add(e);
			Node parent;
			while((parent=e.getParent())!=null) {
				result.add(parent);
				e=parent;
			}
			Collections.reverse(result);
			return result;
		}
		return new ArrayList<Node>();
		
	}
	
}
