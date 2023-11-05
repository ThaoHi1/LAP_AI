package lap5;

import java.util.Arrays;
import java.util.List;

public class TestNode {

	public static void main(String[] args) {
		Puzzle p = new Puzzle();
		p.readInput("C:\\workspace_AI\\lap5\\src\\lap5\\PuzzleMap.txt", "C:\\workspace_AI\\lap5\\src\\lap5\\PuzzleGoalState.txt");
		IPuzzleAlgo greedy = new GreedyBestFirstSearch();
		IPuzzleAlgo a_star=new A_starSearch();

		System.out.println(p.computeH1(p.getInitialState()));
		System.out.println(p.computeH2(p.getInitialState()));
		//System.out.println(p.moveWhiteTile(p.getInitialState(), 'r'));
		Node gredyy = greedy.execute(p);
		Node a_start = a_star.execute(p);
		for(Node n:PuzzleUtils.print(a_start)) {
			System.out.println(n.getG());
			System.out.println(n);
		}
		
	}
}
