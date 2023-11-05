package lap5;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class GreedyBestFirstSearch implements IPuzzleAlgo{

	@Override
	public Node execute(Puzzle model) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByH);
		List<Node> explored = new ArrayList<Node>();
		frontier.add(model.getInitialState());
		while(!frontier.isEmpty()) {
			Node current =frontier.poll();//lay cai node dau tien trong hang doi ra
			if(current.equals(model.getGoalState())) {
				return current;
			}else {
				explored.add(current);
				for(Node n:model.getSuccessors(current)) {
					if((!frontier.contains(n))&&(!explored.contains(n))) {
						n.setParent(current);
						frontier.add(n);
					}
				}
				
			}
		}
		
		return null;
	}

}
