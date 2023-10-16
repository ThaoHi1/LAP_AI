package lap2_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearchAlgo_Tree implements ISearchAlgo {
	@Override
	// task3 TreeSearch
	public Node execute(Node root, String goal) {
		Stack<Node> frontier = new Stack<Node>();// hàng đợi
		List<Node> explored = new ArrayList<Node>();// ds da mo rong
		frontier.add(root);

		while (!frontier.isEmpty()) {

			Node current = frontier.peek();
			frontier.remove(frontier.lastElement());
			System.out.println("current  " + current.getLabel());

			if (current.getLabel().equals(goal)) {
				System.out.println("Goal");
				System.out.println("-------------\n");
				return current;

			} else {
				explored.add(current);
				System.out.println("not goal ");
				List<Node> sort = new ArrayList<Node>();
				for (Node a : current.getChildrenNodes()) {
					sort.add(a);
					a.setParent(current);
					System.out.println("add: " + a);

				}
				Collections.reverse(sort);
				for (Node s : sort) {
					frontier.add(s);
				}
				System.out.println(frontier.toString());
				System.out.println("-------------\n");
			}
		}
		System.out.println("khong tim thay duong di trong");
		return root;

	}

	@Override
	// task3 TreeSearch
	public Node execute(Node root, String start, String goal) {
		Stack<Node> frontier = new Stack<Node>();// hàng đợi
		List<Node> explored = new ArrayList<Node>();// ds da mo rong
		frontier.add(root);

		while (!frontier.isEmpty()) {
			Node check = frontier.peek();
			if (!check.getLabel().equals(start)) {
				frontier.remove(frontier.lastElement());
				for (Node c : check.getChildrenNodes()) {
					frontier.add(c);
				}
			} else {
				frontier.clear();
				frontier.add(check);
				while (!frontier.isEmpty()) {

					Node current = frontier.peek();
					frontier.remove(frontier.lastElement());
					System.out.println("current  " + current.getLabel());

					if (current.getLabel().equals(goal)) {
						System.out.println("Goal");
						System.out.println("-------------\n");
						return current;

					} else {
						explored.add(current);
						System.out.println("not goal ");

						List<Node> sort = new ArrayList<Node>();
						for (Node a : current.getChildrenNodes()) {

							sort.add(a);
							a.setParent(current);
							System.out.println("add: " + a);

						}
						Collections.reverse(sort);
						for (Node s : sort) {
							frontier.add(s);
						}
						System.out.println(frontier.toString());
						System.out.println("-------------\n");
					}
				}
			}
		}

		System.out.println("khong tim thay duong di trong");
		return root;

	}
}
