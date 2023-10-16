package lap2_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class DepthLimitedSearch {
	public Node execute(Node root, String goal, int limitedDept) {
		Stack<Node> frontier = new Stack<Node>();
		List<Node> explore = new ArrayList<Node>();
		root.setDepth(0);
		frontier.add(root);

		while (!frontier.isEmpty()) {
			Node current = frontier.peek();
			System.out.println("current: " + current.getLabel());
			frontier.remove(frontier.lastElement());
			if (current.getLabel().equals(goal)) {
				System.out.println("is goal ");
				System.out.println("----------");
				return current;
			} else {
				if (current.getDepth() <= limitedDept) {
					explore.add(current);
					List<Node> sort = new ArrayList<Node>();
					for (Node n : current.getChildrenNodes()) {
						if (!frontier.contains(n)) {
							n.setParent(current);
							n.setDepth(n.getParent().getDepth() + 1);
							sort.add(n);
							System.out.println("add: " + n.getLabel());
						}

					}
					Collections.reverse(sort);
					frontier.addAll(sort);
					System.out.println(frontier.toString());
					System.out.println("----------\n");
				}

			}
		}

		System.out.println("khong tim duoc duong di trong");
		return root;
	}

}
