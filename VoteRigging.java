public class VoteRigging {
      public int minimumVotes(int[] votes) {
          int k = 0;
		  while (max(votes)!=0) {
			  int index = max(votes);
			  votes[index] -= 1;
			  votes[0] += 1;
			  k++;
		  }
		  return k;
      }
	  private int max(int[] votes) {
		  int max = 0;
		  int ret = 0;
		  for (int c = 0; c < votes.length; c++) {
			  if (votes[c] >= max) {
				  max = votes[c];
				  ret = c;
			  }
		  }
		  return ret;
	  }
   }