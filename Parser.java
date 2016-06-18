import java.util.ArrayList;
import java.util.HashMap;

public class Parser {
	public Policy parse(String[] s) {
		
		HashMap<String, String> matchMap = new HashMap<String, String>();
		
		Policy p = null;
		String flow = s[0];
		String units = s[1];
		String react = s[2];
		
		//Take care of match fields
		String[] two = flow.split(":");
		String[] matches = two[1].split(",");
		//get values for each match field
		for (int i = 0; i < matches.length; i++) {
			String values[] = matches[i].split("=");
			matchMap.put(values[0], values[1]);
		}
		
		//Take care of services
		//Take care of match fields
		ArrayList<String> services = new ArrayList<String>();
		two = units.split(":");
		String[] allServices = two[1].split(",");		
		for (int i = 0; i < allServices.length; i++) {
			services.add(allServices[i]);
		}
		
		//Take care of reaction
		two = react.split(":");
		String reaction = two[1];
		
		p = new Policy(matchMap, services, reaction, "1");
		return p;
	}
	
	public static void main(String[] args) {
		Parser p = new Parser();
		String[] policy = {"Flow:VLAN=192,TCP=12","Service:DPI,IDS","React:alert"};
		p.parse(policy);
	}
}
