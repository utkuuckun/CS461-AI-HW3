package hw3;

import java.util.PriorityQueue;
import java.util.Comparator;

public class AStarSearch {
	//properties
	Board[] boards;
	PriorityQueue<Path> PQ;
	int[] shortestDist;			//For keeping shortest distance to specific boards
	Board goalBoard;
	
	public AStarSearch(Board[] B)
	{
		boards = B;
		goalBoard = B[0];
		Comparator<Path> comparator = new PathComperator();
		PQ = new PriorityQueue<Path>(10,comparator);
		shortestDist = new int[B.length];
		for(int i = 0; i < shortestDist.length; i++)
			shortestDist[i] = 10000;
	}
	
	public Path search(Board initialBoard)
	{
		Path initialPath = new Path(initialBoard);
		PQ.add(initialPath);
		
		while(true)
		{
			//remove first path from queue & create new paths
			
			Path tempPath = PQ.remove();
			Board tempBoard = tempPath.getLastVisited();
			
			
			if(tempBoard.compare(goalBoard.getBoard()))
				return tempPath;
			
			for(int i = 0; i < tempBoard.getNeigbourCount(); i++)
			{
				if(!tempPath.contains(tempBoard.neigbours[i]))	//Loop check
				{
					if(tempPath.getDistTraveled()+1 < shortestDist[boards[tempBoard.neigbours[i]].getState_id()])	//Shortest distance checking
					{
						Path newPath = tempPath.clone();
						newPath.add(boards[tempBoard.neigbours[i]]);
						shortestDist[boards[tempBoard.neigbours[i]].getState_id()] = newPath.getDistTraveled();
						PQ.add(newPath);
					}
					
				}
			}
			
			
		}
	}

}
