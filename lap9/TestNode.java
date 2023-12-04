package lap9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestNode {
	public static void print(Node n) {
		List<String> result = new ArrayList<String>();
		Node z = n;
		result.add(n.label);
		while (z.getParent() != null) {
			Node a = z.getParent();
			z = a;
			result.add(a.getLabel());
		}
		Collections.reverse(result);
		
		System.out.println("best move" + result.get(1));
	}

	public static void main(String[] args) {
		Node node = new Node();
		Integer[] data = { 7 };
		node.addAll(Arrays.asList(data));

//		node.add(5);
//		node.add(1);
//		node.add(1);
		MinimaxAlgo algo = new MinimaxAlgo();
		Node z = algo.execute(node);
		print(z);

		System.out.println("result " + z.getLabel());
		System.out.println("result-value " + z.getValue());
	}
}