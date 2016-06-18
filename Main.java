
public class Main {
	
	public static void main(String[] args) {
		
		Parser parser = new Parser();
		UnitsManager unitsManager = new UnitsManager();
		Policies allPolicies = new Policies();
		Implementer implementer = new Implementer(unitsManager, allPolicies);
		
		//Parse policy
		String[] policyString = {"Flow:VLAN=192,TCP=12","Service:DPI,IDS","React:alert"};
		Policy policy = parser.parse(policyString);
		allPolicies.addPolicy(policy);
		
		//Implement policy
		implementer.implement(policy);
	}

	
}
