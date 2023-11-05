package lap5;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class A_starSearch implements IPuzzleAlgo{

	@Override
	public Node execute(Puzzle model) {
	PriorityQueue<Node> frontier = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByF);
	List<Node > explored = new ArrayList<Node>();
	frontier.add(model.getInitialState());
	while(!frontier.isEmpty()) {
		Node current = frontier.poll();
		if(current.equals(model.getGoalState())) {
			return current;
		}else {
			explored.add(current);
			for(Node n: model.getSuccessors(current)) {
				if((!frontier.contains(n))&&(!explored.contains(n))) {
					n.setParent(current);
					frontier.add(n);
				}else if(frontier.contains(n)&&(n.getF()<current.getF()+1)) {
					frontier.remove(n);
					n.setParent(current);
					frontier.add(n);
				}
			}
		}
	}
	
	
		return null;
	}

}
