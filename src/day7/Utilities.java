package day7;

import java.util.Collections;
import java.util.List;

public class Utilities {
	public static int doSum(List<Integer> inc) { // this is the same method from day6 just by a different name
		int total = 0;
		for (int i=0;i<inc.size();i++) {
			total += inc.get(i);
		} // end for
		return total;
	} // end doSum
	
	public static int doMin(List<Integer> inc) {
		return Collections.min(inc);
	} // end doMin
	
	public static int doMax(List<Integer> inc) {
		return Collections.max(inc);
	} // end doMax
	
	public static double doMean(List<Integer> inc) {
		return doSum(inc) / (double) inc.size();
	} // end doMean
	
	public static double doMedian(List<Integer> inc) {
		if (inc.size() % 2 != 0) { // What is the semantic meaning of this? Why is it necessary here?
			Collections.sort(inc);
			return inc.get(inc.size()/2); // Why does this give the correct index value?
		} else {
			int over = inc.get(inc.size()/2); // Why does this give the correct index value?
			int under = inc.get(inc.size()/2-1); // Why does this give the correct index value?
			return (over + under) / 2.0;
		} // end else
	} // end doMedian
} // end Utilities