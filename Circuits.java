import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Stack;
public class Circuits {
       public int howLong(String[] connects, String[] costs) {
          int max = 0;
		  int coord = 0;
		  int path = 0;
		  List<Set<Link>> links = new ArrayList<Set<Link>>();
		  Set<Integer> visited = new HashSet<Integer>();
		  for (int c = 0; c < connects.length; c++) {
			  links.add(new HashSet<Link>());
			  String[] connections = connects[c].split(" ");
			  String[] weights = costs[c].split(" ");
			  for (int k = 0; k < connections.length; k++) {
				  if (!connections[k].equals("")) links.get(c).add(new Link(Integer.parseInt(connections[k]),Integer.parseInt(weights[k])));
			  }
		  }
		  for (Set<Link> dests : links) {
			  //Stack<Link> s = new Stack<Link>();
			  //if (!visited.contains(coord)) s.addAll(dests);
			  if (!visited.contains(coord)) path = findmax(links, dests);
			  for (Link dest : dests) {
				  visited.add(dest.getDest());
			  }
			  if (path > max) max = path;
			  coord++;
		  }
		  return max;
       }
	   private int findmax(List<Set<Link>> links, Set<Link> dests) {
		   if (dests.isEmpty()) return 0;
		   int max = 0;
		   for (Link dest : dests) {
			   int test = findmax(links,links.get(dest.getDest())) + dest.getWeight();
			   if (test > max) max = test;
		   }
		   return max;
	   }
	   private class Link {
		   int myDest;
		   int myWeight;
		   public Link(int dest, int weight) {
			   myDest = dest;
			   myWeight = weight;
		   }
		   public int getDest() {
			   return myDest;
		   }
		   public int getWeight() {
			   return myWeight;
		   }
	   }
   }