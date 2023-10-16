package lap2_3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class UniformCostSearchAlgo implements ISearchAlgo {

	@Override
	// task4
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return (int) (o1.getPathCost() - o2.getPathCost());
			}
		});

		List<Node> explore = new ArrayList<Node>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			System.out.println("Current: " + current.getLabel());
			if (current.getLabel().equals(goal)) {
				return current;
			} else {
				explore.add(current);
				for (Node n : current.getChildrenNodes()) {
					if (!frontier.contains(n)) {
						n.setParent(current);
						for (Edge i : n.getParent().getChildren()) {
							if (i.getEnd().getLabel().equals(n.getLabel())) {
								n.setPathCost(i.getWeight() + n.getParent().getPathCost());
							}
						}

						frontier.add(n);
						System.out.println("add: " + n.getLabel());

					} else {
						Node parentBefore = n.getParent();
						double before = n.getPathCost();
						n.setParent(current);
						for (Edge i : n.getParent().getChildren()) {
							if (i.getEnd().getLabel().equals(n.getLabel())) {
								n.setPathCost(i.getWeight() + n.getParent().getPathCost());
							}
						}

						double after = n.getPathCost();
						if (after > before) {
							n.setParent(parentBefore);
							n.setPathCost(before);
						}

					}

				}

			}
			System.out.println(frontier.toString());
			System.out.println("------------\n");
		}
		System.out.println("khong tim thay duong di trong");
		return root;
	}

	@Override
	// task5
	public Node execute(Node root, String start, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return (int) (o1.getPathCost() - o2.getPathCost());
			}
		});

		List<Node> explore = new ArrayList<Node>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node check = frontier.poll();
			if (!check.getLabel().equals(start)) {
				for (Node c : check.getChildrenNodes()) {
					frontier.add(c);
				}
			} else {
				frontier.clear();
				frontier.add(check);

				while (!frontier.isEmpty()) {
					
					Node current = frontier.poll();
					System.out.println("Current: " + current.getLabel());
					if (current.getLabel().equals(goal)) {
						return current;
					} else {
						explore.add(current);
						for (Node n : current.getChildrenNodes()) {
							if (!frontier.contains(n)) {
								n.setParent(current);
								for (Edge i : n.getParent().getChildren()) {
									if (i.getEnd().getLabel().equals(n.getLabel())) {
										n.setPathCost(i.getWeight() + n.getParent().getPathCost());
									}
								}

								frontier.add(n);
								System.out.println("add: " + n.getLabel());

							} else {
								Node parentBefore = n.getParent();
								double before = n.getPathCost();
								n.setParent(current);
								for (Edge i : n.getParent().getChildren()) {
									if (i.getEnd().getLabel().equals(n.getLabel())) {
										n.setPathCost(i.getWeight() + n.getParent().getPathCost());
									}
								}

								double after = n.getPathCost();
								if (after > before) {
									n.setParent(parentBefore);
									n.setPathCost(before);
								}

							}

						}

					}
					System.out.println(frontier.toString());
					System.out.println("------------\n");
				}
			}}
		

		System.out.println("khong tim thay duong di trong");
		return root;
	}

}
