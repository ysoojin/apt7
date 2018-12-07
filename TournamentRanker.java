import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
public class TournamentRanker  {
      Map<String,Team> lookup = new HashMap<String,Team>();
	  public String[] rankTeams(String[] names, String[] lostTo) {
			List<Team> teams = new ArrayList<Team>();
			List<String> ret = new ArrayList<String>();
			for (int c = 0; c < names.length; c++) {
				Team entry = new Team(names[c],lostTo[c],0);
				teams.add(entry);
				lookup.put(names[c],entry);
			}
			for (String loss : lostTo) {
				if (!loss.equals("")) lookup.get(loss).increment();
			}
			Collections.sort(teams);
			for (Team team : teams) {
				ret.add(team.toString());
			}
			return ret.toArray(new String[0]);
      }
	  private class Team implements Comparable<Team> {
		  String myName;
		  int myWins;
		  String myLoss;
		  public Team(String name, String loss, int wins) {
			  myName = name;
			  myLoss = loss;
			  myWins = wins;
		  }
		  public void increment() {
			  myWins++;
		  }
		  public int getWins() {
			  return myWins;
		  }
		  public String getLoss() {
			  return myLoss;
		  }
		  @Override
		  public int compareTo(Team other) {
			  int comp = other.getWins()-myWins;
			  if (comp != 0) return comp;
			  return -lookup.get(other.getLoss()).compareTo(lookup.get(myLoss));
		  }
		  @Override
		  public String toString() {
			  return myName;
		  }
			  
	  }
   }