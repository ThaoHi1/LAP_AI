package lap2_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NodeUtils {
	public static List<String> printPath(Node node) {
		if (node != null) {
			List<String> result = new ArrayList<String>();
			result.add(node.getLabel());
			Node tmp;
			while ((tmp = node.getParent()) != null) {

				result.add(tmp.getLabel());
				node = tmp;
			}
			Collections.reverse(result);
			System.out.println("Path:  ");
			return result;
		} else
			return new ArrayList<String>();
	}
	public static void main(String[] args) {
//		Node nodeS = new Node("S");
//		Node nodeA = new Node("A"); Node nodeB = new Node("B");
//		Node nodeC = new Node("C"); Node nodeD = new Node("D");
//		Node nodeE = new Node("E"); Node nodeF = new Node("F");
//		Node nodeG = new Node("G"); Node nodeH = new Node("H");
//		nodeS.addEdge(nodeA, 5); nodeS.addEdge(nodeB, 2);
//		nodeS.addEdge(nodeC, 4); nodeA.addEdge(nodeD, 9);
//		nodeA.addEdge(nodeE, 4); nodeB.addEdge(nodeG, 6);
//		nodeC.addEdge(nodeF, 2); nodeD.addEdge(nodeH, 7);
//		nodeE.addEdge(nodeG, 6); nodeF.addEdge(nodeG, 1);
		
		
		Node nodeStart = new Node("Start");
		Node nodeA = new Node("A"); Node nodeB = new Node("B");
		Node nodeC = new Node("C"); Node nodeD = new Node("D");
		Node nodeE = new Node("E"); Node nodeF = new Node("F");
		Node nodeR = new Node("R"); Node nodeH = new Node("H");
		 Node nodeP = new Node("P");
		 Node nodeQ = new Node("Q");
		 Node nodeGoal = new Node("Goal");
		 nodeStart.addEdge(nodeD, 3); nodeStart.addEdge(nodeE, 9); nodeStart.addEdge(nodeP, 1);
		nodeB.addEdge(nodeA, 2);
		nodeC.addEdge(nodeA, 2);
		nodeD.addEdge(nodeB, 1);nodeD.addEdge(nodeC, 8);nodeD.addEdge(nodeE, 2);
		nodeE.addEdge(nodeH, 1);nodeE.addEdge(nodeR, 9);
		nodeF.addEdge(nodeC, 5);nodeF.addEdge(nodeGoal, 5);
		nodeH.addEdge(nodeP, 4);nodeH.addEdge(nodeQ, 4);
		nodeP.addEdge(nodeQ, 15);
		nodeQ.addEdge(nodeR, 3);
		nodeR.addEdge(nodeF, 5);
		 
		ISearchAlgo algo3=new BreadthFirstSearchAlgo_Tree();
		ISearchAlgo algo4=new DepthFirstSearchAlgo_Tree();
		ISearchAlgo algo2 = new DepthFirstSearchAlgo();
		ISearchAlgo algo1 = new BreadthFirstSearchAlgo();
		ISearchAlgo algo5=new UniformCostSearchAlgo();
		DepthLimitedSearch a = new DepthLimitedSearch();
		//Node result = algo1.execute(nodeS, "G");
	//	Node bfs2 = algo1.execute(nodeS,"A", "G");
	//Node bfsTree = algo1.executeTree(nodeStart, "Goal");
		//Node bfsTree2 = algo3.execute(nodeStart, "Start", "Goal");
		//Node dfs2 = algo2.execute(nodeS, "C","G");
		//Node dfsTree=algo2.executeTree(nodeStart, "Goal");
		//Node dfsTree2=algo4.execute(nodeStart, "Start", "Goal");
		//Node ucs = algo5.execute(nodeS, "G");
		//Node ucs2 = algo5.execute(nodeS, "S", "G");
		Node limit=a.execute(nodeStart, "R", 2);
	System.out.println(printPath(limit));
	}
}
