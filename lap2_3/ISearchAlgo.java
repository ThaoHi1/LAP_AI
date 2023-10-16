package lap2_3;

public interface ISearchAlgo {
	public Node execute(Node root, String goal);// find the path from root node to the goal node,tu gôc đến goal

	public Node execute(Node root, String start, String goal); // find the path from start node to the goal node, từ 1 vị trí cho đến goal
	
}