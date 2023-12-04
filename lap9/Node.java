package lap9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Node {
	String label;
	Node parent;
	int value;
	 List<Integer> data = new ArrayList<Integer>();


	public String getLabel() {
	return label;
}



public void setLabel() {
	this.label = data.toString();
}

public void setLabel(String label) {
	this.label = label;
}



	public void add(Integer val) {
		this.data.add(val);
	}

	public void addAll(List<Integer> data) {
		this.data.addAll(data);
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}


	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	// Get children of the current nodes
	public List<Node> getSuccessors() {
		data.sort(DESCOMPARATOR);
		List<Node> result = new ArrayList<Node>();
		List<Integer> visited= new ArrayList<Integer>();
		for (int i = 0; i < data.size(); i++) {
			int current = data.get(i);
			if(!(visited.contains(current))) {
			int count = (current % 2 == 0) ? (current / 2) : (current / 2 + 1);
			for (int j = 1; j < count; j++) {
				if (current>2) {
					Node n = new Node();
					n.add(j);
					n.add(current - j);
					for (int k = 0; k < data.size(); k++) {
						if (k != i) {
							n.add(data.get(k));
						}
						
					}
					n.setParent(this);
					result.add(n);
					

				}
				

			}
			
			visited.add(current);
			}
		}
			return result;
	}

	// Check whether a node is terminal or not
	public boolean isTerminal() {
		data.sort(DESCOMPARATOR);
		for (Integer i : data) {
			if (i > 2) {
				return false;
			}
		}
		return true;
	}

	public static final Comparator<Integer> DESCOMPARATOR = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	};

	@Override
	public String toString() {
		Collections.sort(this.data, DESCOMPARATOR);
		return this.data.toString();
	}

	public static void main(String[] args) {

		Node n = new Node();
		n.add(7);
		List<Node> a = n.getSuccessors();
		for (Node z : a) {
			System.out.println(z);
		}
		
	}
	

}
