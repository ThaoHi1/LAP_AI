package lap7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GA_NQueenAlgo {
	public static final int POP_SIZE = 100;// Population size
	public static final double MUTATION_RATE = 0.03;
	public static final int MAX_ITERATIONS = 1000;
	List<Node> population = new ArrayList<Node>();
	Random rd = new Random();

// initialize the individuals of the population
	public void initPopulation() {
		for (int i = 0; i < POP_SIZE; i++) {
			Node ni = new Node();
			ni.generateBoard();
			population.add(ni);
		}
	}

	public Node execute() {
		initPopulation();
		int k = 0;
		while (k++ < MAX_ITERATIONS) {
			List<Node> new_population = new ArrayList<Node>();
			for (int i = 0; i < POP_SIZE; i++) {
				Node x = getParentByRandomSelection();
				Node y = getParentByRandomSelection();
				Node child = reproduce(x, y);

				if (MUTATION_RATE > rd.nextDouble()) {
					mutate(child);
				}
				if (child.getH() == 0) {
					return child;
				} else {
					new_population.add(child);
				}
			}
			population = new_population;

		}
		Collections.sort(population);
		return population.get(0);

	}

// Mutate an individual by selecting a random Queen and 
//move it to a random row.
	public void mutate(Node node) {
		int i = rd.nextInt(Node.N);
		int row = rd.nextInt(Node.N);
		if (row != node.getRow(i)) {
			node.setRow(i, row);
		}else {
		mutate(node);
		}
	}

//Crossover x and y to reproduce a child
	public Node reproduce(Node x, Node y) {
		int c = rd.nextInt(Node.N);
		Node result = new Node();
		result.generateBoard();
		for (int i = 0; i < c; i++) {
			result.setRow(i, x.getRow(i));
		}
		for (int i = c; i < Node.N; i++) {
			result.setRow(i, y.getRow(i));
		}
		return result;
	}

// Select K individuals from the population at random and 
//select the best out of these to become a parent.
	public Node getParentByTournamentSelection(int k) {
		List<Node> list = new ArrayList<Node>();
		for (int i = 0; i < k; i++) {
			Node a = population.get(rd.nextInt(POP_SIZE));
			list.add(a);
		}
		Collections.sort(list);
		return list.get(0);

	}

//Select a random parent from the population
	public Node getParentByRandomSelection() {
		int node = rd.nextInt(POP_SIZE);
		return population.get(node);
	}
}
