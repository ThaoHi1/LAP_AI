package lap9;

public class MinimaxAlgo {
	public Node execute(Node node) {
		Node A = minValue(node);

		return A;

	}

	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	public Node maxValue(Node node) {

		if (node.isTerminal()) {

			node.setValue(0);
			node.setLabel();
			return node;
		} else {
			Node result = node;
			result.setLabel();
			int v = Integer.MIN_VALUE;
			for (Node n : node.getSuccessors()) {

				n.setParent(node);
				Node a = minValue(n);
				if (v < a.getValue()) {
					v = Math.max(v, a.getValue());

					result=a;
				}
			}
			
			return result;
		}
		

	}

	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v
	public Node minValue(Node node) {

//		if(node.isTerminal()) {
//			return 0;
//		}else {
//			int v=Integer.MAX_VALUE;
//			for(Node n :node.getSuccessors()) {
//				v=Math.min(v, maxValue(n));
//			}
//			return v;
//		}
		if (node.isTerminal()) {
			node.setValue(1);
			node.setLabel();
			return node;
		} else {
			Node result = node;
			result.setLabel();
			int v = Integer.MAX_VALUE;
			for (Node n : node.getSuccessors()) {

				n.setParent(node);
				Node a = maxValue(n);
				if (v > a.getValue()) {
					v = Math.min(v, a.getValue());

					result=a;
				}
			}
			return result;
		}

	}

	public static void main(String[] args) {
		MinimaxAlgo a = new MinimaxAlgo();
		Node b = new Node();
		b.add(7);
		Node z =a.execute(b);
		System.out.println(z.getValue());
		System.out.println(z.getLabel());
		
		

	}
}
