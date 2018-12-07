import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
public class FriendScore {
      public int highestScore(String[] friends) {
         List<Set<Integer>> list = new ArrayList<Set<Integer>>();
		 List<Set<Integer>> friends2 = new ArrayList<Set<Integer>>();
		 int k = 0;
		 int max = 0;
		 for (String friend : friends) {
			 list.add(new HashSet<Integer>());
			 for (int c = 0; c < friend.length(); c++) {
				 if (friend.charAt(c) == 'Y') {
					 list.get(k).add(c);
				 }
			 }
			 k++;
		 }
		 for (int c = 0; c < list.size(); c++) {
			 friends2.add(new HashSet<Integer>());
			 friends2.get(c).addAll(list.get(c));
			 for (int f : list.get(c)) {
				 friends2.get(c).addAll(list.get(f));
			 }
			 friends2.get(c).remove(c);
		 }
		 for (Set<Integer> set : friends2) {
			 if (set.size() > max) max = set.size();
		 }
		 return max;
      }
   }