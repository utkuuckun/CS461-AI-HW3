package hw3;

import java.util.Comparator;

public class PathComperator implements Comparator<Path> {

	public int compare(Path x, Path y)
	{
		if (x.getEstimateDist() < y.getEstimateDist())
        {
            return -1;
        }
        if (x.getEstimateDist() > y.getEstimateDist())
        {
            return 1;
        }
        return 0;
	}
}
