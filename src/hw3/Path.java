package hw3;

import java.util.ArrayList;

public class Path {
	
	//Properties
	private ArrayList<Board> elements;
	private int distTraveled;
	public int getDistTraveled() {
		return distTraveled;
	}


	public void setDistTraveled(int distTraveled) {
		this.distTraveled = distTraveled;
	}

	private int estimateDist;	//total estimate
	private ArrayList<Integer> visited;
	
	
	public Path(Board input)
	{
		distTraveled = 0;
		setEstimateDist(0);
		elements = new ArrayList<Board>();
		visited = new ArrayList<Integer>();
		elements.add(input);
		visited.add(input.getState_id());
	}
	
	
	public boolean add(Board input)
	{
		if(visited.contains(input.getState_id()))
			return false;
		elements.add(input);
		distTraveled++;
		setEstimateDist(input.getDist()+ distTraveled);
		visited.add(input.getState_id());
		return true;
	}

	
	public Path clone()
	{
		Path temp = new Path(elements.get(0));
		temp.distTraveled = this.distTraveled;
		temp.setEstimateDist(this.getEstimateDist());
		temp.visited = (ArrayList<Integer>) this.visited.clone();
		temp.elements = (ArrayList<Board>) this.elements.clone();
		
		return temp;
	}
	
	
	
	public Board getLastVisited()
	{
		return elements.get(distTraveled);
	}
	
	public int getEstimateDist() {
		return estimateDist;
	}


	public void setEstimateDist(int estimateDist) {
		this.estimateDist = estimateDist;
	}
	
	public boolean contains(int target)
	{
		for( Integer integ : visited)
		{
			if(integ == target)
				return true;
		}
		return false;
			
	}
	
}
