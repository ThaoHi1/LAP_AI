package bai4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class AStarSearchAlgo implements IInformedSearchAlgo {

	// task2
	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				Double h_g1 = o1.getG() + o1.getH();
				Double h_g2 = o2.getG() + o2.getH();
				int result = h_g1.compareTo(h_g2);
				if (result == 0) {
					return o1.getLabel().compareTo(o2.getLabel());
				}
				return result;
			}
		});

		List<Node> explore = new ArrayList<Node>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			System.out.println("Current: " + current.getLabel());
			if (current.getLabel().equals(goal)) {
				// System.out.println("of-"+current.getParent().getLabel());
				System.out.println("GOAL");
				System.out.println("Goal :" + current.getLabel() + "-" + current.getG());
				return current;
			} else {
				explore.add(current);
				for (Node n : current.getChildrenNodes()) {
					if ((!frontier.contains(n)) && (!explore.contains(n))) {
						n.setParent(current);
						for (Edge i : n.getParent().getChildren()) {
							if (i.getEnd().getLabel().equals(n.getLabel())) {
								n.setG(i.getWeight() + n.getParent().getG());
							}
						}

						frontier.add(n);
						System.out.println("add: " + n.getLabel() + "-" + n.getG());

					} else {

						Node parentBefore = n.getParent();
						double before_G = n.getG();
						n.setParent(current);
						for (Edge i : n.getParent().getChildren()) {
							if (i.getEnd().getLabel().equals(n.getLabel())) {
								n.setG(i.getWeight() + n.getParent().getG());

							}

						}
						double after_G = n.getG();
						System.out.println("lap lai :" + n.getLabel());
						System.out.println("before_G of " + n.getLabel() + ": " + before_G);
						System.out.println("after_G of " + n.getLabel() + ": " + after_G);
						if (after_G >= before_G) {
							n.setParent(parentBefore);
							n.setG(before_G);
						}

					}

				}

			}
			System.out.print("[");
			for (Node e : frontier) {

				System.out.print(e + "_" + e.getG() + "/" + (e.getG() + e.getH()) + ", ");
			}
			System.out.print("]");
			System.out.println();
			System.out.println("------------\n");
		}
		System.out.println("khong tim thay duong di trong");
		return null;
	}
//task3 
	public boolean isAdmissibleH(Node root, String goal) {
		Queue<Node> front = new LinkedList<Node>();
		List<Node> explored = new ArrayList<Node>();
		front.add(root);
		while (!front.isEmpty()) {
			Node n = front.poll();
			
			double h_ = execute(n, goal).getG()-n.getG();//h*
			System.out.println("***************");
			System.out.println("h: " + n.getLabel() + n.getH());
			System.out.println("h*: " + n.getLabel() + h_);
			System.out.println("*******************");

			
				if ((!(n.getH()>= 0)) &&(!(n.getH() <= h_))) {
					System.out.println("NOT ADMISSIBLE_H");
					return false;
				} else {
					explored.add(n);
					for (Node node : n.getChildrenNodes()) {
						if ((!(front.contains(node))) &&( !(explored.contains(node)))) {
							front.add(node);
							
						}
					}
				}
			}
		

		System.out.println("IS ADMISSIBLE_H");
		return true;

	}

	@Override
	public Node execute(Node root, String start, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				Double h_g1 = o1.getG() + o1.getH();
				Double h_g2 = o2.getG() + o2.getH();
				int result = h_g1.compareTo(h_g2);
				if (result == 0) {
					return o1.getLabel().compareTo(o2.getLabel());
				}
				return result;
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
				// System.out.println("of-"+current.getParent().getLabel());
				System.out.println("GOAL");
				System.out.println("Goal :" + current.getLabel() + "-" + current.getG());
				return current;
			} else {
				explore.add(current);
				for (Node n : current.getChildrenNodes()) {
					if ((!frontier.contains(n)) && (!explore.contains(n))) {
						n.setParent(current);
						for (Edge i : n.getParent().getChildren()) {
							if (i.getEnd().getLabel().equals(n.getLabel())) {
								n.setG(i.getWeight() + n.getParent().getG());
							}
						}

						frontier.add(n);
						System.out.println("add: " + n.getLabel() + "-" + n.getG());

					} else {

						Node parentBefore = n.getParent();
						double before_G = n.getG();
						n.setParent(current);
						for (Edge i : n.getParent().getChildren()) {
							if (i.getEnd().getLabel().equals(n.getLabel())) {
								n.setG(i.getWeight() + n.getParent().getG());

							}

						}
						double after_G = n.getG();
						System.out.println("lap lai :" + n.getLabel());
						System.out.println("before_G of " + n.getLabel() + ": " + before_G);
						System.out.println("after_G of " + n.getLabel() + ": " + after_G);
						if (after_G >= before_G) {
							n.setParent(parentBefore);
							n.setG(before_G);
						}

					}

				}

			}
			
			System.out.print("[");
			for (Node e : frontier) {

				System.out.print(e + "_" + e.getG() + "/" + (e.getG() + e.getH()) + ", ");
			}
			System.out.print("]");
			System.out.println();
			System.out.println("------------\n");
		}
			}
		}
		System.out.println("khong tim thay duong di trong");
		return null;
	}
}
