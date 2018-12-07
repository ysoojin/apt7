import java.util.TreeMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
public class ErdosNumber {
	TreeMap<String,Set<String>> coauthors = new TreeMap<String,Set<String>>();
	TreeMap<String,Integer> distances = new TreeMap<String,Integer>();
	public String[] calculateNumbers(String[] pubs) {
      for (String pub : pubs) {
		  String[] authors = pub.split(" ");
		  for (String author : authors) {
			  coauthors.putIfAbsent(author, new TreeSet<String>());
			  Set<String> s = new TreeSet<String>(Arrays.asList(authors));
			  s.remove(author);
			  coauthors.get(author).addAll(s);
		  }
	  }
	  distances.put("ERDOS",0);
	  bfs();
	  ArrayList<String> list = new ArrayList<String>();
	  for (String author : coauthors.keySet()) {
		  if (distances.containsKey(author)) {
			  author = author + " " + distances.get(author);
		  }
		  list.add(author);
	  }
	  return list.toArray(new String[0]);
    }
	private void bfs() {
		Set<String> visited = new TreeSet<String>();
		Queue<String> qu = new LinkedList<String>();
		visited.add("ERDOS");
		qu.add("ERDOS");
		while (qu.size() > 0) {
			String v = qu.remove();
			for (String adj : coauthors.get(v)) {
				if (!visited.contains(adj)) {
					visited.add(adj);
					qu.add(adj);
					distances.putIfAbsent(adj, distances.get(v)+1);
				}
			}
		}
	}
  }