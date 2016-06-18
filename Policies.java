import java.util.ArrayList;
import java.util.HashMap;

public class Policies {
	
	//Keep track of all policies based on their mappedToVLAN field, so that
	//we can quickly find a policy when a unit complains using a given VLAN
	
	private HashMap<String, Policy> allPolicies;
	
	public Policies() {
		this.allPolicies = new HashMap<String, Policy>();
	}
	
	public void addPolicy(Policy p) {
		allPolicies.put(p.getMappedToVlan(), p);
	}
	
	public Policy getPolicy(String vlan) {
		return allPolicies.get(vlan);
	}
	
}
