 import java.util.Map;
 import java.util.HashMap;
 public class HuffmanDecoding {
      public String decode(String archive, String[] dictionary) {
            Map<String,Character> map = new HashMap<String,Character>();
			char a = 'A';
			StringBuilder search = new StringBuilder();
			StringBuilder ret = new StringBuilder();
			for (String entry : dictionary) {
				map.put(entry,new Character(a));
				a += 1;
			}
			for (int c = 0; c < archive.length(); c++) {
				search.append(archive.charAt(c));
				if (map.containsKey(search.toString())) {
					ret.append(map.get(search.toString()));
					search = new StringBuilder();
				}
			}
			return ret.toString();
      }
   }