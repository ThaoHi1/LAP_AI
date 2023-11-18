package lap7;

public class Test {
	public static void main(String[] args) {
		GA_NQueenAlgo ga = new GA_NQueenAlgo();
//		ga.initPopulation();
//		Node x =ga.getParentByRandomSelection();
//		x.displayBoard();
//		System.out.println("----------");
//		Node y=ga.getParentByRandomSelection();
//		y.displayBoard();
//		System.out.println("---------");
//		Node a=ga.reproduce(x, y);
//		a.displayBoard();
		System.out.println("Test for GA_ALgo");
		Node test=ga.execute();
		test.displayBoard();
		System.out.println("H= "+test.getH());
	}

}
