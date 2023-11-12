package lap6;

public class HillClimbingSearch implements ILocalSearchAlgo {
	int stepClimbed = 0;
	int stepClimbedAfterRandomRestart = 0;
	@Override
	public Node execute(Node initialState) {

		Node current = new Node(initialState);

		while (true) {
			Node neighbor = current.getBestCandidate();
			if (neighbor.getH() >= current.getH()) {
				return current;

			} else {
				current = neighbor;
				stepClimbed++;
				stepClimbedAfterRandomRestart++;

			}
		}

	}

}
