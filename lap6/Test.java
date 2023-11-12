package lap6;

public class Test {
	public static void main(String[] args) {
		ILocalSearchAlgo hc = new HillClimbingSearch();
		ILocalSearchAlgo hcRandom = new HillClimbingWithRandomRestart();
		ILocalSearchAlgo sa = new SASearch();
		Queen[] q = { new Queen(4,0),new Queen(5, 1),new Queen(6, 2),new Queen(3, 3), new Queen(4, 4),new Queen(5, 5), new Queen(6, 6),new Queen(5, 7)};
		Node iNode = new Node(q);
		System.out.println("H= "+iNode.getH());
		iNode.displayBoard();
		System.out.println("\n");
//		Node a = new Node();
//		a.generateBoard();
		//Node testHc = hc.execute(iNode);
		//Node testHcRandom = hcRandom.execute(iNode);
		Node testSA = sa.execute(iNode);
		Node test =testSA;
		System.out.println("H= "+test.getH());
		test.displayBoard();

	}

}
