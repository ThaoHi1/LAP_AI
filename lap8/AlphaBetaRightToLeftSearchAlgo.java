package lap8;

import java.util.List;

public class AlphaBetaRightToLeftSearchAlgo implements ISearchAlgo{

	@Override
	public void execute(Node node) {
		int v=maxValue(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println(v);
		
	}
	public int maxValue(Node node, int alpha, int beta) {
		if(node.isTerminal()) {
			return node.getValue();
		}else {
			int v =Integer.MIN_VALUE;
			List<Node> list=node.getChildren();
			list.sort(Node.LabelComparator2);
			for(Node n:list) {
				v=Math.max(v, minValue(n, alpha, beta));
				if(v>=beta) {
					for(int i=list.indexOf(n)+1;i<list.size();i++) {
						System.out.println(list.get(i));
					}
					return v;
				}else {
					alpha=Math.max(alpha, v);
				}
			}
			return v;
		}
	}
	public int minValue(Node node, int alpha, int beta) {
		
		if(node.isTerminal()) {
			return node.getValue();
		}else {
			int v = Integer.MAX_VALUE;
			List<Node> list=node.getChildren();
			list.sort(Node.LabelComparator2);
			for(Node n:list) {
				v=Math.min(v, maxValue(n, alpha, beta));
				if(v<=alpha) {
					for(int i=list.indexOf(n)+1;i<list.size();i++) {
						System.out.println(list.get(i));
					}
					return v;
				} else {
					beta=Math.min(beta, v);
				}
			}
			return v;
		}
	}
}
