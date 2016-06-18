import java.util.ArrayList;
import java.util.HashMap;

public class Policy {
	
	private HashMap<String, String> matchMap;
	private ArrayList<String> units;
	private String reaction;
	private String mappedToVlan;
	
	public Policy(HashMap<String, String> matches, ArrayList<String> units, String reaction, String vlan) {
		this.matchMap = matches;
		this.units = units;
		this.reaction = reaction;
		mappedToVlan = vlan;
	}
	
	
	public HashMap<String, String> getMatchMap() {
		return matchMap;
	}
	public void setMatchMap(HashMap<String, String> matchMap) {
		this.matchMap = matchMap;
	}
	public ArrayList<String> getUnits() {
		return units;
	}
	public void setUnits(ArrayList<String> units) {
		this.units = units;
	}
	public String getReaction() {
		return reaction;
	}
	public void setReaction(String reaction) {
		this.reaction = reaction;
	}
	
	public String getMappedToVlan() {
		return this.mappedToVlan;
	}

}
