package hw3;

import java.util.Stack;

public class Test {
	public static void main(String[] args) {
		int[] initialBoard = {1,2,3,4,5,6,7,8,0};

		Generator G = new Generator(100, initialBoard);
		Board[] boards = G.Generate();
		
		Board initial = boards[109];
		Board current; 
		
		AStarSearch ASS = new AStarSearch(boards);
		Path result = ASS.search(initial);
		
		
		System.out.print("done");
		//a*
//		Stack<Board> s = new Stack<Board>();
//		s.push(initial);
//		while(!s.isEmpty()) {
//			current = s.pop();
//			int[] neighbours = current.getNeighbours();
//			for(int i : neighbours) {
//				if(current.getDist() + 1 <= boards[i].getDist() ) {
//					
//				}
//			}			
//		}		
	}
}
