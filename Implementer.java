import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Implementer {
	
	private UnitsManager manager;
	private Policies allPolicies;
	private String edgeSwitchId;
	private String edgeSwitchPort;
	
	public Implementer(UnitsManager manager, Policies allPolicies) {
		this.manager = manager;
		this.allPolicies = allPolicies;
	}
	
	public void implement(Policy p) {
		HashMap<String,String> matches = p.getMatchMap();
		ArrayList<String> units = p.getUnits();
		String reaction = p.getReaction();
		String vlanMapped = p.getMappedToVlan();
		
		System.out.println("Match fields");
		Set<String> keys = matches.keySet();
		//OFMatch match = new OFMatch();
		for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			String value = matches.get(string);
			System.out.println(string + "=" + value);
			/*if (string == "VLAN") {
				match.setDataLayerVirtualLan(Short.parseShort(string)));
			} elseif (string == "ipSrc") {
				match.setNetworkSource(IPv4.toIPv4Address(string));
			} elseif (string == "ipDst") {
				match.setNetworkDestination(IPv4.toIPv4Address(string));
			} elseif (string == "tcpPrt") {
				match.setTransportDestination(Short.parseShort(string));
			}*/
		}
		
		
		System.out.println("Units");
		for (Iterator iterator = units.iterator(); iterator.hasNext();) {
			String unitId = (String) iterator.next();
			System.out.println(unitId);
			String switchId = manager.getSwitch(unitId);
			String port = manager.getPort(unitId);
			//For each unit, create actions
			//List<OFAction> actions = new ArrayList<OFAction>();
			//actions.add(sw.getOFFactory().actions().buildOutput().setPort(port).setMaxLen(0xffFFffFF).build());
            //OFActionVirtualLanIdentifier action = new OFActionVirtualLanIdentifier();
            //action.setVirtualLanIdentifier(vlanid);
			//actions.add(action)
			//floodlightModule.add(switchId, match, actions);
		}
		
		System.out.println("Reaction: " + reaction);
	}
	
	public void dealWith(String malicious) {
		String[] split = malicious.split("#");
		String vlan = split[0];
		String mac = split[1];
		Policy p = allPolicies.getPolicy(vlan);
		if (p != null) {
			//Block mac address at edge switch and port
			//floodlightModule.block(edgeSwitchId, edgeSwitchPort, mac);
		}
	}
}
