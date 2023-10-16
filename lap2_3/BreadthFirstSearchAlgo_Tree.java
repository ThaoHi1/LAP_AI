package lap2_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchAlgo_Tree implements ISearchAlgo{

	// task3 TreeSearch
		public Node execute(Node root, String goal) {
			Queue<Node> frontier = new LinkedList<Node>();// hàng đợi
			List<Node> explored = new ArrayList<Node>();// ds da mo rong

			frontier.add(root);

			while (!frontier.isEmpty()) {

				Node current = frontier.poll();
				System.out.println("current  " + current.getLabel());

				if (current.getLabel().equals(goal)) {
					System.out.println("Goal");
					System.out.println("-------------\n");
					return current;

				} else {
					System.out.println("not goal ");
					explored.add(current);
					for (Node a : current.getChildrenNodes()) {
						if (!frontier.contains(a)) {
							frontier.add(a);
							a.setParent(current);
							System.out.println("add: " + a);

						}else {
							frontier.add(a);
							System.out.println("add: " + a);
						}
					}
					System.out.println(frontier.toString());
					System.out.println("-------------\n");
				}
			}
			System.out.println("khong tim thay duong di trong");
			return root;

		}

		// task3 TreeSearch
		@Override
		public Node execute(Node root, String start, String goal) {
			Queue<Node> frontier = new LinkedList<Node>();// hàng đợi
			List<Node> explored = new ArrayList<Node>();// ds da mo rong
			frontier.add(root);

			while (!frontier.isEmpty()) {
				Node check = frontier.peek();
				if (!check.getLabel().equals(start)) {
					frontier.remove();

					for (Node c : check.getChildrenNodes()) {
						frontier.add(c);
					}

				} else {
					frontier.clear();
					
					frontier.add(check);
					while (!frontier.isEmpty()) {
						Node current = frontier.poll();
						System.out.println("current  " + current.getLabel());

						if (current.getLabel().equals(goal)) {
							System.out.println("Goal");
							System.out.println("-------------\n");
							return current;

						} else {
							System.out.println("not goal ");
							explored.add(current);
							for (Node a : current.getChildrenNodes()) {
								if (!frontier.contains(a)) {
									a.setParent(current);
									frontier.add(a);
								
									System.out.println("add: " + a);

								}
								else {
									frontier.add(a);
								}
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
