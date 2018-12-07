public class PrefixCode { 
      public String isOne(String[] words) {
          int ret = 0;
		  for (String word : words) {
			  for (String comp : words) {
				  if (comp != word && word.length() <= comp.length() && word.equals(comp.substring(0,word.length()))) return "No, " + ret;
			  }
			  ret++;
		  }
		  return "Yes";
      }
   }