package lap6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

public class Node {
	public static final int N = 8;
	
	private Queen[] state;

	public Node() {

		state = new Queen[N];
		//generateBoard();
	}

	public Node(Queen[] state) {
		this.state = new Queen[N];
		for (int i = 0; i < state.length; i++) {
			this.state[i] = new Queen(state[i].getRow(), state[i].getColumn());
		}
	}

	public Node(Node n) {
		this.state = new Queen[N];
		for (int i = 0; i < N; i++) {
			Queen qi = n.state[i];
			this.state[i] = new Queen(qi.getRow(), qi.getColumn());
		}
	}

	public void generateBoard() {
		Random random = new Random();
		for (int i = 0; i < N; i++) {
			state[i] = new Queen(random.nextInt(N), i);
		}
	}

	public int getH() {
		int heuristic = 0;
		for (int i = 0; i < state.length -1; i++) {
			for (int j = i + 1; j < state.length; j++) {
				if (state[i].isConflict(state[j])) {
					heuristic++;
				}
			}
		}
		return heuristic;
	}

//tao ra cac trang thai con , di chuyen 1 con giu nguyen cac con hau con lai
	public List<Node> generateAllCandidates() {
		List<Node> result = new ArrayList<Node>();
		for (int i = 0; i < N; i++) {
			Node n = new Node(state);
			n.state[i].move();
			result.add(n);
		}
		return result;
	}

	// lay ra trang thai con tot nhat
	public Node getBestCandidate() {
		PriorityQueue<Node> a = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				Integer a = o1.getH();
				Integer b = o2.getH();
				return a.compareTo(b);
			}
		});
		for (Node n : this.generateAllCandidates()) {
			a.add(n);
		}
		Node n = a.peek();
		return n;
	}

	// tao ra 1 trang thai con ngẫu nhiên
	public Node selectNextRandomCandidate() {
		Node result = new Node(this.state);
		Random r = new Random();
		int name_queen = r.nextInt(N);
		int newRow = r.nextInt(N);
		result.state[name_queen].setRow(newRow);
		return result;
	}

	public void displayBoard() {
		int[][] board = new int[N][N];
		// set queen position on the board
		for (int i = 0; i < N; i++) {
			board[state[i].getRow()][state[i].getColumn()] = 1;
		}
		// print board
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 1) {
					System.out.print("Q" + " ");
				} else {
					System.out.print("-" + " ");
				}
			}
			System.out.println();
		}
	}

	

	
	

	
}
