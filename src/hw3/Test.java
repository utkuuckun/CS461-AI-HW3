package hw3;

import java.util.Stack;

public class Test {
	public static void main(String[] args) {
		int[] initialBoard = {1,2,3,4,5,6,7,8,0};

		Generator G = new Generator(10, initialBoard);
		Board[] boards = G.Generate();
		
		Board initial = boards[197];
		Board current; 
		//a*
		Stack<Board> s = new Stack<Board>();
		s.push(initial);
		while(!s.isEmpty()) {
			current = s.pop();
			int[] neighbours = current.getNeighbours();
			for(int i : neighbours) {
				if(current.getDist() + 1 <= boards[i].getDist() ) {
					
				}
			}
			
		}
		
		
		
		
	}
}
