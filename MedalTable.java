import java.util.Comparator;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class MedalTable {
   public String[] generate(String[] results) {
      Map<String,List<Integer>> map = new HashMap<String,List<Integer>>();
	  List<Country> list = new ArrayList<Country>();
	  List<String> ret = new ArrayList<String>();
	  for (String result : results) {
		  String[] ranks = result.split(" ");
		  for (int c = 0; c < ranks.length; c++) {
			  if (!map.containsKey(ranks[c])) {
				  map.put(ranks[c],new ArrayList<Integer>(3));
				  for (int k = 0; k < 3; k++) {
					  map.get(ranks[c]).add(0);
				  }
			  }
			  map.get(ranks[c]).set(c,map.get(ranks[c]).get(c)+1);
		  }
	  }
	  for (Map.Entry<String,List<Integer>> entry : map.entrySet()) {
		  list.add(new Country(entry.getKey(),entry.getValue()));
	  }
	  Collections.sort(list,new MedalCompare());
	  for (Country country : list) {
		  ret.add(country.toString());
	  }
	  return ret.toArray(new String[0]);
		  
   }
   private class MedalCompare implements Comparator<Country> {
	   @Override
	   public int compare(Country a, Country b) {
		   String[] asplit = a.toString().split(" ");
		   String[] bsplit = b.toString().split(" ");
		   int comp = Integer.parseInt(bsplit[1])-Integer.parseInt(asplit[1]);
		   if (comp != 0) return comp;
		   comp = Integer.parseInt(bsplit[2])-Integer.parseInt(asplit[2]);
		   if (comp != 0) return comp;
		   comp = Integer.parseInt(bsplit[3])-Integer.parseInt(asplit[3]);
		   if (comp != 0) return comp;
		   return asplit[0].compareTo(bsplit[0]);
	   }
   }
   private class Country {
	   String myName;
	   int gold;
	   int silver;
	   int bronze;
	   public Country(String name, List<Integer> medals) {
		   myName = name;
		   gold = medals.get(0);
		   silver = medals.get(1);
		   bronze = medals.get(2);
	   }
	   @Override
	   public String toString() {
		   return myName + " " + Integer.toString(gold)+ " " + Integer.toString(silver) + " " + Integer.toString(bronze);
	   }
   }
 }