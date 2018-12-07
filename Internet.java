import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
public class Internet {
	 List<Set<Integer>> list = new ArrayList<Set<Integer>>();
     public int articulationPoints(String[] routers) {
		 int k = 0;
		 int ret = 0;
		 for (String router : routers) {
			 list.add(new HashSet<Integer>());
			 String[] partners = router.split(" ");
			 for (String partner : partners) {
				 list.get(k).add(Integer.parseInt(partner));
			 }
			 k++;
		 }
		 for (int c = 0; c < routers.length; c++) {
			 ret += pathsearch(c);
		 }
		 return ret;
     }
	 private int pathsearch(int skip) {
		 Set<Integer> seen = new HashSet<Integer>();
		 Queue<Integer> q = new LinkedList<Integer>();
		 if (skip == 0) {
			 if (list.size() > 0) q.add(1);
		 }
		 else q.add(0);
		 while (q.size() > 0) {
			 int test = q.remove();
			 if (test != skip) {
				 seen.add(test);
				 q.addAll(list.get(test));
				 q.removeAll(seen);
			 }
		 }
		 if (seen.size() == list.size()-1) return 0;
		 return 1;
	 }
  }